package me.projeto.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import javax.net.ssl.SSLKeyException;

public class Entidades implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(!(s instanceof Player))return false;
        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("entidade")){

            if(args.length == 0){
                p.sendMessage("A entidade foi spawnada");


                spawnarNPC(p);


            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("remover")){
                    for (World world : Bukkit.getWorlds()){
                        for(Entity en : world.getEntities()){
                            if(en.getCustomName() != null && en.getCustomName().equalsIgnoreCase("§cJorginho")) {
                                en.remove();
                                p.sendMessage("§cEntidades removidas!");
                            }
                        }
                    }
                }
            }


        }
        return false;
    }
/*
    private void spawnerEntidade(Player p){
        Skeleton skeleton = (Skeleton) p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);

        ItemStack item = new ItemStack(Material.IRON_SWORD,1);
        skeleton.setCustomName("§cJorginho");
        skeleton.setCustomNameVisible(true);



        skeleton.setGlowing(true);
        skeleton.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.4);

        skeleton.getEquipment().setItemInMainHand(item);
        skeleton.getEquipment().setItemInMainHandDropChance(0);
    }
*/
    private void spawnarNPC(Player p){

        Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
        villager.setCustomNameVisible(true);
        villager.setCustomName("§bMercador");
        villager.setProfession((Villager.Profession.BLACKSMITH));
        villager.setCareer(Villager.Career.WEAPON_SMITH);
        villager.setAI(false);



    }
}