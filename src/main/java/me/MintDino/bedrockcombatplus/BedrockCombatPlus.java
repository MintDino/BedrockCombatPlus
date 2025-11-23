package me.mintdino.bedrockcombatplus;

import org.bukkit.plugin.java.JavaPlugin;

public class BedrockCombatPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BedrockListener(this), this);
        getServer().getPluginManager().registerEvents(new ShieldListener(this), this);
        getServer().getPluginManager().registerEvents(new CombatListener(this), this);
    }

    @Override
    public void onDisable() {
    }
}
