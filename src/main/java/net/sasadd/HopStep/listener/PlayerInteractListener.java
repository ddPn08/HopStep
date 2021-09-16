package net.sasadd.HopStep.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import net.sasadd.HopStep.HopStep;

public class PlayerInteractListener implements Listener{

    private HopStep plugin;

    public PlayerInteractListener(HopStep plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(!event.hasItem())
            return;
        if(!event.getAction().name().equals("RIGHT_CLICK_AIR") && !event.getAction().name().equals("RIGHT_CLICK_BLOCK"))
            return;
        final ItemStack item = event.getItem();
        if(!item.hasItemMeta() || !item.getItemMeta().hasCustomModelData() || item.getItemMeta().getCustomModelData() != 80101)
            return;
        

        final Player player = event.getPlayer();

        //item meta
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes("&".charAt(0), 
            "HopStep &b| &cloading &b|"));
        meta.setCustomModelData(80102);
        item.setItemMeta(meta);

        

        //Sound & Perticle
        player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1, 1);
        player.spawnParticle(Particle.CLOUD, player.getLocation(), 250, 1.5, 1.5, 1.5, 0.05);

        //set Velocity
        Vector vector;
        int coolDown;
        if(player.isSneaking()){
            vector = new Vector(0, 1, 0);
            coolDown = 1;
        } else if(player.getScoreboardTags().contains(HopStep.JumpingTag)){
            vector = new Vector(0, 2, 0);
            coolDown = 3;
        } else {
            vector = new Vector(0, 1.25, 0);
            coolDown = 2;
        }
    
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
            @Override
            public void run() {
                meta.setDisplayName("HopStep");
                meta.setCustomModelData(80101);
                item.setItemMeta(meta);
            }
        }, 20 * coolDown);
        player.setVelocity(vector);
    }
    
}
