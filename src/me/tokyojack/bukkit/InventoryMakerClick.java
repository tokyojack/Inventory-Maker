package com.valeon.core.inventory;

import com.valeon.core.Valeon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryMakerClick implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInventoryMakerClick(InventoryClickEvent event) {
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR)
            return;

        for (InventoryMaker inventoryMaker : Valeon.getAPI().getInventoryMakerManager().getInventoryMakers()) {
            if (!stripColor(event.getInventory().getName()).equals(stripColor(inventoryMaker.getInventoryName())))
                continue;

            for (InventoryClick inventoryClick : inventoryMaker.getInventoryClickList()) {
                if(inventoryClick.getItem().equals(clickedItem)){
                    inventoryClick.click(event);
                    break;
                }
            }
        }

    }

    public String stripColor(String string) {
        return ChatColor.stripColor(string);
    }

}