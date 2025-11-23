package me.mintdino.bedrockcombatplus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.Material;

public class ShieldListener implements Listener {

    private final BedrockCombatPlus plugin;

    public ShieldListener(BedrockCombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        if (!FloodgateUtil.isBedrock(p)) return;

        ItemStack off = p.getInventory().getItemInOffHand();
        if (off.getType() != Material.SHIELD) return;

        double angle = p.getLocation().getDirection().dot(
                e.getDamager().getLocation().toVector().subtract(p.getLocation().toVector()).normalize()
        );

        if (angle > -0.5) return;

        e.setCancelled(true);

        if (off.getItemMeta() instanceof Damageable dmg) {
            dmg.setDamage(dmg.getDamage() + 1);
            off.setItemMeta(dmg);
        }
    }
}
