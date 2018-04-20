package package;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin implements Listener {

	public void onEnable() {
		InventoryMakerManager inventoryMakerManager = new InventoryMakerManager();

		inventoryMakerManager.register();
		inventoryMakerManager.addInventory(new Hub());

		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		new Hub().open(event.getPlayer());
	}

}