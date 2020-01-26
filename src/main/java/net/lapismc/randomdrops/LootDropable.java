package net.lapismc.randomdrops;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootDropable implements Dropable {

    private LootTables lootType;
    private Random random;

    public LootDropable(LootTables lootType){
        this.lootType = lootType;
        random = new Random();
    }

    @Override
    public List<ItemStack> getDrops(Location loc) {
        return new ArrayList<>(lootType.getLootTable().populateLoot(random, new LootContext.Builder(loc).build()));
    }

    @Override
    public void dropItems(Location loc) {
        for (ItemStack drop : getDrops(loc)) {
            loc.getWorld().dropItem(loc, drop);
        }
    }
}
