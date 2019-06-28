package com.bgsoftware.wildtools.hooks;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Relation;
import de.erethon.factionsone.FactionsOneAPI;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public final class BlocksProvider_FactionsOne implements BlocksProvider {

    @Override
    public boolean canBreak(Player player, Block block, boolean onlyInClaim) {
        FPlayer fPlayer = FactionsOneAPI.getFPlayer(player.getUniqueId());
        boolean overriding = fPlayer.isAdminBypassing();
        Faction faction = null;

        try{
            //noinspection JavaReflectionMemberAccess
            faction = (Faction) Board.class.getMethod("getFactionAt", Location.class).invoke(null, block.getLocation());
        }catch(Throwable ignored){}

        if(onlyInClaim && faction == null) return false;

        return faction == null || overriding || (fPlayer.hasFaction() && (fPlayer.getFaction().equals(faction) ||
                faction.getRelationWish(fPlayer.getFaction()) == Relation.ALLY));
    }
}