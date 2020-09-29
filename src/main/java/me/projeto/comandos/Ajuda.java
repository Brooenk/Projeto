package me.projeto.comandos;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Ajuda implements CommandExecutor {

    private HashMap<Player, Long> ajuda = new HashMap();

    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(!(s instanceof Player)) return false;

        Player p = (Player) s;

        if(c.getName().equalsIgnoreCase("ajuda")){

            if(ajuda.containsKey(p) && ! (System.currentTimeMillis() >= ajuda.get(p))){
                p.sendMessage("§aAguarde, comando em Cooldown, aguarde §c" +converter(p)+ " §asecundos.");
                return false;
            }else ajuda.remove(p);

            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));

            if(args.length == 0){
                p.sendMessage("");
                p.sendMessage("Digite /ajuda 1 - para o servidor");
                p.sendMessage("Digite /ajuda 2 - para youtube");
                return true;
            }
            if(args.length ==1){

                    return true;
                }
                if(args[0].equalsIgnoreCase("2")){
                    p.sendMessage("§cO nosso canal do YouTube esta indisponível");
                    return true;
                }


        }

        return false;
    }

    private long converter(Player p){
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }
}
