package co.shanedev.sdanticraft.events;

import co.shanedev.sdanticraft.config;
import co.shanedev.sdanticraft.util.BlockedRecipes;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.List;

public class CraftEvent implements Listener {

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        Recipe recipe = event.getRecipe();
        if (recipe != null) {
            ItemStack result = recipe.getResult();
            Material itemType = result.getType();
            if(config.get().getStringList("Blocked-Recipes").contains("ALL-RECIPES")) {
                event.getInventory().setResult(null);
            }
            else if (BlockedRecipes.isRecipeBlocked(itemType)) {
                event.getInventory().setResult(null); // This cancels the crafting result
                event.getViewers().forEach(viewer -> viewer.sendMessage(config.get().getString("Prefix").replace("&", "§") + config.get().getString("Blocked-Message").replace("&", "§")));
            }
        }
    }
}