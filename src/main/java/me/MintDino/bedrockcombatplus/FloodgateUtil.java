package me.mintdino.bedrockcombatplus;

import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

public class FloodgateUtil {
    public static boolean isBedrock(Player p) {
        return FloodgateApi.getInstance().isFloodgatePlayer(p.getUniqueId());
    }
}
