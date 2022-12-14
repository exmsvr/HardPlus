package xyz.tetratheta.hardplus.module;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.potion.PotionEffectType;
import xyz.tetratheta.hardplus.util.HPPerm;
import xyz.tetratheta.hardplus.util.HPPlayer;

public class NoFireResistance implements Listener {
  @EventHandler
  public void onFireResistanceAdded(EntityPotionEffectEvent e) {
    if (!(e.getEntity() instanceof Player p)) return;
    if (!HPPlayer.checkPermGameMode(p, HPPerm.NO_FIRE_RESISTANCE.value)) return;

    if (e.getAction().equals(EntityPotionEffectEvent.Action.ADDED)) {
      if (e.getNewEffect() != null && e.getNewEffect().getType().equals(PotionEffectType.FIRE_RESISTANCE)) {
        e.setCancelled(true);
      }
    }
  }
}
