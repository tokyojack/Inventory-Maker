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

	/**
	 * Adds a item to the inventory
	 *
	 * @param ItemStack
	 *            - The item you want to add
	 */
    protected void addItem(ItemStack item){
        this.inventory.addItem(item);
    }

	/**
	 * Adds a item with a click
	 *
	 * @param InventoryClick
	 *            - Inventory click with an item
	 */
    protected void addItem(InventoryClick inventoryClick){
        this.inventory.addItem(inventoryClick.getItem());
        this.inventoryClickList.add(inventoryClick);
    }

	/**
	 * Sets a item to the inventory
	 *
	 * @param ItemStack
	 *            - The item you want to add
	 */
    protected void setItem(int slot, ItemStack item){
        this.inventory.setItem(slot, item);
    }

	/**
	 * Sets a item with a click
	 *
	 * @param InventoryClick
	 *            - Inventory click with an item
	 */
    protected void setItem(int slot, InventoryClick inventoryClick){
        this.inventory.setItem(slot, inventoryClick.getItem());
        this.inventoryClickList.add(inventoryClick);
    }

	/**
	 * Gets the inventories name
	 *
	 * @return String - Inventory name
	 */
    public String getInventoryName(){
        return this.inventory.getName();
    }

	/**
	 * Open's the inventory for a player
	 */
    public void open(Player player){
        player.openInventory(this.inventory);
    }

}