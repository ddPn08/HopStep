package net.sasadd.HopStep;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import net.sasadd.HopStep.Item.HopStepItem;
import net.sasadd.HopStep.command.HopStepExecuter;
import net.sasadd.HopStep.listener.PlayerInteractListener;
import net.sasadd.HopStep.listener.PlayerMoveListener;

public class HopStep extends JavaPlugin {
    
    public static final String JumpingTag = "HopStep.Jumping";

    @Override
    public void onEnable() {
        this.getServer().getPluginCommand("hopstep").setExecutor(new HopStepExecuter());
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);

        InitRecipe();
    }

    private void InitRecipe(){
        ItemStack result = new HopStepItem(1);
        NamespacedKey key = new NamespacedKey(this, "HopStep");

        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape("frf","fpf","fff");

        recipe.setIngredient("f".charAt(0),Material.FEATHER);
        recipe.setIngredient("r".charAt(0),Material.RABBIT_FOOT);
        recipe.setIngredient("p".charAt(0),Material.PAPER);

        this.getServer().addRecipe(recipe);
    }
}
