package com.bgsoftware.wildtools.api.hooks;

import org.bukkit.inventory.ItemStack;

public final class SoldItem{

    private final ItemStack item;
    private final double price;

    /**
     * Constructor for a sold item.
     * @param itemStack The item that was sold.
     * @param price The price of the item.
     */
    public SoldItem(ItemStack itemStack, double price){
        this.item = itemStack;
        this.price = price;
    }

    /**
     * Get the item that was sold.
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * Get the price of this item.
     */
    public double getPrice() {
        return price;
    }
}
