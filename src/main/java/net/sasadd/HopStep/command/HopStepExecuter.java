package net.sasadd.HopStep.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.sasadd.HopStep.Item.HopStepItem;

public class HopStepExecuter implements TabExecutor {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String arg2, String[] arg3) {
        List<String> tabs = new ArrayList<>();
        switch(arg3.length){
            case 1:{
                tabs.add("give");
                break;
            }
            default:
                break;
        }
        return tabs;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg2, String[] arg3) {
        if(arg3.length < 1){
            sender.sendMessage("引数が足りません。");
            return false;
        }

        final Player player = (Player)sender;

        switch(arg3[0]){
            case "give":{
                final ItemStack item = new HopStepItem(1);
                player.getWorld().dropItem(player.getLocation(), item);
                break;
            }
            default:
                break;
        }
        return true;
    }
    
    
}
