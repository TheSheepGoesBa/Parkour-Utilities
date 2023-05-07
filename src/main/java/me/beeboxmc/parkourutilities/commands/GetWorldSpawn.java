package me.beeboxmc.parkourutilities.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetWorldSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player && sender.hasPermission("parkourutil.getworldspawn")) {
            Location loc = player.getWorld().getSpawnLocation();
            player.sendMessage(Component.text("X: " + loc.getBlockX() + ", Y: " + loc.getBlockY() +
                            ", Z: " + loc.getBlockZ(), NamedTextColor.AQUA));
            return true;
        }
        return false;
    }
}
