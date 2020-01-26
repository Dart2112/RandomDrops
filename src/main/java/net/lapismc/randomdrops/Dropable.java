package net.lapismc.randomdrops;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Dropable {

    List<ItemStack> getDrops(Location loc);

    void dropItems(Location loc);

}
