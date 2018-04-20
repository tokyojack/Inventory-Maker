package me.tokyojack.spigot.airdrop;


import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.valeon.core.inventory.InventoryClick;
import com.valeon.core.inventory.InventoryMaker;

public class Hub extends InventoryMaker {

    public Hub() {
        super("Hub", 8);
    }

    @Override
    public void buildInventory() {
        addItem(new ItemStack(Material.ANVIL));

        setItem(1, new InventoryClick(new ItemStack(Material.DIAMOND_SWORD)) {

            @Override
            public void click(InventoryClickEvent event) {
                event.setCancelled(true);
                // Send to different server
            }

        });
        addItem(new ItemStack(Material.ANVIL));
    }

}