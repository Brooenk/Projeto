package me.projeto.entities;

import me.projeto.items.ItemBuilder;
import me.projeto.items.SkullBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WelcomeIventory {

    private Inventory inventory;

    public WelcomeIventory() {
        inventory = Bukkit.createInventory(null, 9 * 3, "§7Bem Vindo ao servidor");
        insertItens();
    }

    private void insertItens() {
        ItemStack item = new ItemBuilder(Material.DIAMOND_AXE)
                .setDisplayName("&6ESPADA VIP").setLore("&4Forjada por", "&aJOGADOR VIP")
                .addEnchantment(Enchantment.FIRE_ASPECT, 2)
                .addEnchantment(Enchantment.DURABILITY, 3)
                .addEnchantment(Enchantment.DAMAGE_ALL, 5).build();

        inventory.setItem(13, item);

    }
    public Inventory getInventory(){
        return inventory;
}
}
