package me.mintdino.bedrockcombatplus;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Particle;

public class CombatListener implements Listener {

    private final BedrockCombatPlus plugin;

    public CombatListener(BedrockCombatPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player attacker)) return;
        if (!(e.getEntity() instanceof LivingEntity target)) return;
        if (!FloodgateUtil.isBedrock(attacker)) return;

        if (isCrit(attacker)) {
            e.setDamage(e.getDamage() * 1.5);
            attacker.getWorld().spawnParticle(Particle.CRIT, target.getLocation().add(0, 1, 0), 8, 0.2, 0.5, 0.2);
        }
    }

    private boolean isCrit(Player p) {
        if (p.isOnGround()) return false;
        if (p.getFallDistance() <= 0) return false;
        if (p.isSprinting()) return false;
        if (p.getLocation().getBlock().isLiquid()) return false;
        if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) return false;
        return true;
    }
}
