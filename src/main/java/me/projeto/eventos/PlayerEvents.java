package me.projeto.eventos;

import me.projeto.entities.WelcomeIventory;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerEvents implements Listener {



    @EventHandler
    public void quandoQuebrarBloco(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(b.getType() != Material.GRASS)return;

        p.sendMessage("§eVocê quebrou um bloco de grama! ");
        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20*10,1,false,true));
    }

    @EventHandler
    public void quandoEntrarServidor(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.sendMessage("§2Olá jogador, seja bem vindo ao meu servidor de testes");

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§eSeja Bem vindo " + p.getName()));

    }

    @EventHandler
    public void quandoChamarComando(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if(e.getMessage().equalsIgnoreCase("/youtube")){
            p.openInventory(new WelcomeIventory().getInventory());
            e.setCancelled(true);
        }
    }
}