package co.shanedev.sdanticraft.util;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class BlockedRecipes {

    private static FileConfiguration config;

    public static void initialize(JavaPlugin plugin) {
        config = plugin.getConfig();
    }

    public static boolean isRecipeBlocked(Material material) {
        List<String> blockedRecipes = config.getStringList("Blocked-Recipes");
        return blockedRecipes.contains(material.toString());
    }
}