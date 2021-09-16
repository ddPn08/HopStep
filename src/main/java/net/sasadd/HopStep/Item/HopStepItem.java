package net.sasadd.HopStep.Item;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HopStepItem extends ItemStack {

    public HopStepItem(int count){
        super(Material.PAPER,count);

        final ItemMeta meta = this.getItemMeta();

        //Name
        meta.setDisplayName("HopStep");

        List<String> lore = Arrays.asList("持ってみ、飛ぶぞ。");
        meta.setLore(lore);

        //Enchant Effect
        meta.addEnchant(Enchantment.KNOCKBACK, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //CustomModelData
        meta.setCustomModelData(80101);

        //other

        this.setItemMeta(meta);
    }
    
}
