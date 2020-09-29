package me.projeto.eventos;

import me.projeto.entities.WelcomeIventory;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class NPCevents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if(!(e.getRightClicked() instanceof Villager)) return;
        Villager v = (Villager) e.getRightClicked();
        if(v.getCustomName() == null || !v.getCustomName().equalsIgnoreCase("§bMercador")) return;

        e.setCancelled(true);
        p.openInventory(new WelcomeIventory().getInventory());

    }

}
