package me.beeboxmc.parkourutilities.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;

public class DenyInteract implements Listener {

    public boolean isAllowed(Player player) {
        return player.hasPermission("group.developer") ||
                player.hasPermission("group.admin") ||
                player.hasPermission("group.moderator");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (isAllowed(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER){
            Player player = ((Player) event.getEntity()).getPlayer();
            assert player != null;
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (isAllowed(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getTarget() instanceof Player){
            Player player = ((Player) event.getTarget()).getPlayer();
            assert player != null;
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        if (event.getEntityType() == EntityType.PLAYER){
            Player player = ((Player) event.getEntity()).getPlayer();
            assert player != null;
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (isAllowed(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onItemPickup(PlayerAttemptPickupItemEvent event) {
        Player player = event.getPlayer();
        if (isAllowed(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onArrowPickup(PlayerPickupArrowEvent event) {
        Player player = event.getPlayer();
        if (isAllowed(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (isAllowed(player)) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void preventDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() == EntityType.PLAYER){
            Player player = ((Player) event.getDamager()).getPlayer();
            assert player != null;
            event.setCancelled(true);
        }
    }
}

