package me.projeto;

import me.projeto.comandos.Ajuda;
import me.projeto.comandos.Entidades;
import me.projeto.eventos.NPCevents;
import me.projeto.eventos.PlayerEvents;
import me.projeto.eventos.ServerEvents;
import me.projeto.eventos.iventoryClick;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Projeto extends JavaPlugin {

    private static Projeto instance;


    @Override
    public void onEnable() {
        instance = this;
        loadConfiguration();
        registrarEventos();
        registrarComandos();


    }


    private void registrarEventos() {
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new ServerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new iventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new NPCevents(), this);
    }

    private void registrarComandos() {
        getCommand("ajuda").setExecutor(new Ajuda());
        getCommand("entidade").setExecutor(new Entidades());
    }

    private void loadConfiguration() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Projeto getInstance(){return instance;}
}






