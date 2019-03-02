package com.bgsoftware.wildtools.hooks;

import com.bgsoftware.wildtools.WildToolsPlugin;
import me.vagdedes.spartan.api.API;
import me.vagdedes.spartan.system.Enums;

import org.bukkit.entity.Player;

public final class AntiCheatProvider_Spartan implements AntiCheatProvider {

    public AntiCheatProvider_Spartan(){
        WildToolsPlugin.log(" - Using Spartan as AntiCheatProvider.");
    }

    @Override
    public void enableBypass(Player player) {
        for(Enums.HackType type : Enums.HackType.values())
            API.stopCheck(player, type);
    }

    @Override
    public void disableBypass(Player player) {
        for(Enums.HackType type : Enums.HackType.values())
            API.startCheck(player, type);
    }
}