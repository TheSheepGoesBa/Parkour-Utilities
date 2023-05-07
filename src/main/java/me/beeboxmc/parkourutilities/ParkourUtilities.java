package me.beeboxmc.parkourutilities;

import me.beeboxmc.parkourutilities.commands.GetWorldSpawn;
import me.beeboxmc.parkourutilities.generator.EmptyChunkGenerator;
import me.beeboxmc.parkourutilities.listeners.DenyInteract;
import me.beeboxmc.parkourutilities.listeners.RespawnEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ParkourUtilities extends JavaPlugin {

    private static ParkourUtilities plugin;

    public static ParkourUtilities getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        registerCommand("getworldspawn", new GetWorldSpawn());

        registerEvent(new RespawnEvent());
        registerEvent(new DenyInteract());
    }

    public void registerEvent(Listener event) {
        this.getServer().getPluginManager().registerEvents(event, this);
    }

    public void registerCommand(String command, CommandExecutor executor) {
        Objects.requireNonNull(getCommand(command)).setExecutor(executor);
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, String id) {
        return new EmptyChunkGenerator();
    }
}
