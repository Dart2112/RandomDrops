package net.lapismc.randomdrops;

import net.lapismc.lapiscore.LapisCoreConfiguration;
import net.lapismc.lapiscore.LapisCorePlugin;

public class RandomDrops extends LapisCorePlugin {

    @Override
    public void onEnable() {
        registerConfiguration(new LapisCoreConfiguration(this, 1, 1));
        new DropMapper(this);
        getLogger().info(getName() + " v." + getDescription().getVersion() + " has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info(getName() + " has been disabled!");
    }
}
