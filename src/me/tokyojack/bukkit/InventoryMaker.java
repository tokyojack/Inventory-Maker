package com.valeon.core.inventory;

import com.valeon.core.Valeon;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class InventoryMaker {

    private Inventory inventory;

    private List<InventoryClick> inventoryClickList = new ArrayList<InventoryClick>();

    public InventoryMaker(){
        this.inventory = Bukkit.createInventory(null, 54, "GUI");
        buildInventory();
    }

    public InventoryMaker(String inventoryName){
        this.inventory = Bukkit.createInventory(null, 54, inventoryName);
        buildInventory();
    }

    public InventoryMaker(String inventoryName, int size){
        this.inventory = Bukkit.createInventory(null, size, inventoryName);
        buildInventory();
    }

    public abstract void buildInventory();

    public void addItem(ItemStack item){
        this.inventory.addItem(item);
    }

    public void addItem(InventoryClick inventoryClick){
        this.inventory.addItem(inventoryClick.getItem());
        this.inventoryClickList.add(inventoryClick);
    }

    public void setItem(int slot, ItemStack item){
        this.inventory.setItem(slot, item);
    }

    public void setItem(int slot, InventoryClick inventoryClick){
        Bukkit.broadcastMessage(inventoryClick.getItem().getType().toString());
        this.inventory.setItem(slot, inventoryClick.getItem());
        this.inventoryClickList.add(inventoryClick);
    }

    public String getInventoryName(){
        return this.inventory.getName();
    }

    public void open(Player player){
        player.openInventory(this.inventory);
    }

}