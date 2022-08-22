package com.slymask3.instantblocks.utility.config;

import com.slymask3.instantblocks.core.Core;
import com.slymask3.instantblocks.utility.Common;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

@Config(name = Core.MOD_BASE + "/" + Common.MOD_ADDON)
public class ClothConfig implements ConfigData, IConfig {
    public static void register() {
        AutoConfig.register(ClothConfig.class, Toml4jConfigSerializer::new);
    }

    public static ClothConfig get() {
        return AutoConfig.getConfigHolder(ClothConfig.class).getConfig();
    }

    public void reload() {
        AutoConfig.getConfigHolder(ClothConfig.class).load();
        Common.CONFIG = get();
    }

    @ConfigEntry.Category("blocks")
    @ConfigEntry.Gui.CollapsibleObject
    SectionMining mining = new SectionMining();
    static class SectionMining {
        @ConfigEntry.BoundedDiscrete(min = -64, max = 320)
        int MINING_LADDER_LAYER = Defaults.MINING_LADDER_LAYER;
    }

    @ConfigEntry.Category("blocks")
    @ConfigEntry.Gui.CollapsibleObject
    SectionGrinder grinder = new SectionGrinder();
    static class SectionGrinder {
        boolean TP_GRINDER = Defaults.TP_GRINDER;
    }

    @ConfigEntry.Category("blocks")
    @ConfigEntry.Gui.CollapsibleObject
    SectionLiquid liquid = new SectionLiquid();
    static class SectionLiquid {
        int MAX_LIQUID = Defaults.MAX_LIQUID;
        int MAX_FILL = Defaults.MAX_FILL;
        boolean SIMPLE_LIQUID = Defaults.SIMPLE_LIQUID;
    }

    @ConfigEntry.Category("blocks")
    @ConfigEntry.Gui.CollapsibleObject
    SectionHarvest harvest = new SectionHarvest();
    static class SectionHarvest {
        int RADIUS_HARVEST = Defaults.RADIUS_HARVEST;
    }

    @ConfigEntry.Category("blocks")
    @ConfigEntry.Gui.CollapsibleObject
    SectionLight light = new SectionLight();
    static class SectionLight {
        int RADIUS_LIGHT = Defaults.RADIUS_LIGHT;
        @ConfigEntry.BoundedDiscrete(min = 0, max = 15)
        int LIGHT_MAX = Defaults.LIGHT_MAX;
    }

    @ConfigEntry.Category("toggle")
    @ConfigEntry.Gui.PrefixText()
    @ConfigEntry.Gui.TransitiveObject
    SectionToggle toggle = new SectionToggle();
    static class SectionToggle {
        boolean ENABLE_MINING_LADDER = Defaults.ENABLE_MINING_LADDER;
        boolean ENABLE_GRINDER = Defaults.ENABLE_GRINDER;
        boolean ENABLE_ESCAPE_LADDER = Defaults.ENABLE_ESCAPE_LADDER;
        boolean ENABLE_WATER = Defaults.ENABLE_WATER;
        boolean ENABLE_LAVA = Defaults.ENABLE_LAVA;
        boolean ENABLE_SUCTION = Defaults.ENABLE_SUCTION;
        boolean ENABLE_HARVEST = Defaults.ENABLE_HARVEST;
        boolean ENABLE_LIGHT = Defaults.ENABLE_LIGHT;
    }

    public boolean TP_GRINDER() { return grinder.TP_GRINDER; }
    public int RADIUS_HARVEST() { return harvest.RADIUS_HARVEST; }
    public int RADIUS_LIGHT() { return light.RADIUS_LIGHT; }
    public int LIGHT_MAX() { return light.LIGHT_MAX; }
    public int MINING_LADDER_LAYER() { return mining.MINING_LADDER_LAYER; }
    public int MAX_LIQUID() { return liquid.MAX_LIQUID; }
    public int MAX_FILL() { return liquid.MAX_FILL; }
    public boolean SIMPLE_LIQUID() { return liquid.SIMPLE_LIQUID; }
    public boolean ENABLE_MINING_LADDER() { return toggle.ENABLE_MINING_LADDER; }
    public boolean ENABLE_GRINDER() { return toggle.ENABLE_GRINDER; }
    public boolean ENABLE_ESCAPE_LADDER() { return toggle.ENABLE_ESCAPE_LADDER; }
    public boolean ENABLE_WATER() { return toggle.ENABLE_WATER; }
    public boolean ENABLE_LAVA() { return toggle.ENABLE_LAVA; }
    public boolean ENABLE_SUCTION() { return toggle.ENABLE_SUCTION; }
    public boolean ENABLE_HARVEST() { return toggle.ENABLE_HARVEST; }
    public boolean ENABLE_LIGHT() { return toggle.ENABLE_LIGHT; }
}