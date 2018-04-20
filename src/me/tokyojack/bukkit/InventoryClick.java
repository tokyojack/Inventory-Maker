package com.valeon.core.inventory;

import lombok.Getter;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class InventoryClick {

    private ItemStack item;

    public InventoryClick(ItemStack item){
        this.item = item;
    }

    public abstract void click(InventoryClickEvent event);

}
