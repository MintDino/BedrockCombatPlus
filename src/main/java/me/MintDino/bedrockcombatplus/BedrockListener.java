package me.mintdino.bedrockcombatplus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

public class BedrockListener implements Listener {

    private final BedrockCombatPlus plugin;

    public BedrockListener(BedrockCombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        if (!FloodgateUtil.isBedrock(p)) return;

        e.setCancelled(true);

        ItemStack main = e.getMainHandItem();
        ItemStack off = e.getOffHandItem();

        p.getInventory().setItemInMainHand(off);
        p.getInventory().setItemInOffHand(main);
    }
}
