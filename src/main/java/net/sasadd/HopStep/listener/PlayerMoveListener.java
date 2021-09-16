package net.sasadd.HopStep.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.sasadd.HopStep.HopStep;

public class PlayerMoveListener implements Listener{

    private HopStep plugin;

    public PlayerMoveListener(HopStep plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if(event.getFrom().getY() < event.getTo().getY()){
            double diffRaw = event.getTo().getY() - event.getFrom().getY();
            double diff  = ((double)Math.round(diffRaw*1000)/1000);
            // Bukkit.broadcastMessage("Difference : " + 
            //     String.valueOf(diff));
            
            final Player player = event.getPlayer();

            player.addScoreboardTag(HopStep.JumpingTag);
            Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable(){
                @Override
                public void run(){
                    player.getScoreboardTags().remove(HopStep.JumpingTag);
                }
            }, 10);
        }
    }
    
}
