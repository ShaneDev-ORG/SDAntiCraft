package co.shanedev.sdanticraft;

import co.shanedev.sdanticraft.events.CraftEvent;
import co.shanedev.sdanticraft.util.BlockedRecipes;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SDAntiCraft extends JavaPlugin {


    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        config.setup();
        config.get().addDefault("Prefix", "&f&lAntiCraft &8&l» ");
        config.get().addDefault("Blocked-Message", "This recipe is blocked!");
        config.get().addDefault("Blocked-Recipes", "MATERIAL");
        config.get().options().copyDefaults(true);

        BlockedRecipes.initialize(this);
        getServer().getPluginManager().registerEvents(new CraftEvent(), this);

        getServer().getConsoleSender().sendMessage("Blocking recipes: " + config.get().getStringList("Blocked-Recipes"));

        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "==================================================");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage("§cPlugin: §7SDAntiCraft");
        getServer().getConsoleSender().sendMessage("§cAuthor: §7ShaneDev");
        getServer().getConsoleSender().sendMessage("§cVersion: §71.0");
        getServer().getConsoleSender().sendMessage("§cDiscord: §7discord.gg/Z6eF4QP4gD");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "==================================================");

    }

    @Override
    public void onDisable() {

    }
}
