package net.lapismc.randomdrops;

import org.bukkit.Material;
import org.bukkit.loot.LootTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DropMapper {

    public static HashMap<Material, Dropable> dropsMap = new HashMap<>();

    private List<Dropable> allDrops = new ArrayList<>();
    private RandomDrops plugin;

    public DropMapper(RandomDrops plugin) {
        this.plugin = plugin;
        if (dropsMap.isEmpty()) {
            List<Material> breakableBlocks = new ArrayList<>();
            for (Material mat : Material.values()) {
                //Get every item that is a block and add it to breakableBlocks
                if (mat.isBlock()) {
                    breakableBlocks.add(mat);
                }
            }
            populateAllDrops();
            Random random = new Random();
            //Generate map
            for (Material block : breakableBlocks) {
                //If the all drops list empties because of white/blacklisting we want to regen it
                if (allDrops.isEmpty())
                    populateAllDrops();
                Dropable drop = allDrops.get(random.nextInt(allDrops.size()));
                dropsMap.put(block, drop);
                allDrops.remove(drop);
            }
        }
    }

    private void populateAllDrops() {
        //TODO: add whitelist/blacklist here
        for (Material mat : Material.values()) {
            //Add every item
            allDrops.add(new ItemDropable(mat));
        }
        for (String lootTypeName : plugin.getConfig().getStringList("LootDrops")) {
            //Add all loot drops
            LootTables lootType = LootTables.valueOf(lootTypeName);
            allDrops.add(new LootDropable(lootType));
        }
    }

}
