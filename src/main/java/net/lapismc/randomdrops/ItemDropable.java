package net.lapismc.randomdrops;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemDropable implements Dropable {

    private Material mat;

    public ItemDropable(Material mat) {
        this.mat = mat;
    }

    @Override
    public List<ItemStack> getDrops(Location loc) {
        List<ItemStack> items = new ArrayList<>();
        items.add(new ItemStack(mat));
        return items;
    }

    @Override
    public void dropItems(Location loc) {
        loc.getWorld().dropItem(loc, new ItemStack(mat));
    }
}
