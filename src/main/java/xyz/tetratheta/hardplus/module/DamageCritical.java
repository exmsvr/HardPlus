package xyz.tetratheta.hardplus.module;

import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import xyz.tetratheta.hardplus.util.HPPerm;
import xyz.tetratheta.hardplus.util.HPPlayer;

public class DamageCritical implements Listener {
  @EventHandler
  public void onPlayerInflictCriticalDamage(EntityDamageByEntityEvent e) {
    if (e.getDamager() instanceof AbstractArrow arrow) {
      if (!(arrow.getShooter() instanceof Player p)) return;
      if (!HPPlayer.checkPermGameMode(p, HPPerm.DAMAGE_CRITICAL.value)) return;
      arrow.setCritical(false);
    } else if (e.getDamager() instanceof Player p) {
      if (!HPPlayer.checkPermGameMode(p, HPPerm.DAMAGE_CRITICAL.value)) return;
      e.setDamage(e.getDamage() / 3 * 2);
    }
  }
}
