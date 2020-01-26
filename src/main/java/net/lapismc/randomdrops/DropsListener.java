package net.lapismc.randomdrops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DropsListener implements Listener {

    private RandomDrops plugin;

    public DropsListener(RandomDrops plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        e.setDropItems(false);
        Material broken = e.getBlock().getType();
        Dropable toDrop = DropMapper.dropsMap.get(broken);
        Bukkit.getScheduler().runTaskLater(plugin, () -> toDrop.dropItems(e.getBlock().getLocation()), 1);
    }

}
