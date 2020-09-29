package me.projeto.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class iventoryClick implements Listener {

    @EventHandler
    public void quandoClicar(InventoryClickEvent e){
        if(!e.getInventory().getName().equalsIgnoreCase("§7Bem Vindo ao servidor"))return;
        e.setCancelled(true);

        ItemStack i = e.getCurrentItem();


        Player p = (Player) e.getWhoClicked();
        if(i.getType() == Material.DIAMOND_AXE){
            p.sendMessage("§aVocê Clicou no machado");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,10,10);
        }



    }
}
