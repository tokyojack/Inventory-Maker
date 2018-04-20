package com.valeon.core.inventory;

import com.valeon.core.Valeon;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InventoryMakerManager {

    private List<InventoryMaker> inventoryMakers = new ArrayList<InventoryMaker>();

    public InventoryMakerManager(){

    }

    public void addInventory(InventoryMaker inventoryMaker){
        this.inventoryMakers.add(inventoryMaker);
    }

    // I could stick this in the constructor, but this is more understandable.
    public void register(){
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryMakerClick(), Valeon.getAPI());
    }

}
