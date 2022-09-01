package com.slymask3.instantblocks.utility.config;

public interface IConfig {
    default void reload() {}

    default boolean TP_GRINDER() { return Defaults.TP_GRINDER; }
    default int RADIUS_HARVEST() { return Defaults.RADIUS_HARVEST; }
    default int RADIUS_LIGHT() { return Defaults.RADIUS_LIGHT; }
    default int LIGHT_MAX() { return Defaults.LIGHT_MAX; }
    default int MINING_LADDER_LAYER() { return Defaults.MINING_LADDER_LAYER; }
    default int RADIUS_DOME() { return Defaults.RADIUS_DOME; }

    default int MAX_LIQUID() { return Defaults.MAX_LIQUID; }
    default int MAX_FILL() { return Defaults.MAX_FILL; }
    default boolean SIMPLE_LIQUID() { return Defaults.SIMPLE_LIQUID; }

    default boolean ENABLE_MINING_LADDER() { return Defaults.ENABLE_MINING_LADDER; }
    default boolean ENABLE_GLASS_DOME() { return Defaults.ENABLE_GLASS_DOME; }
    default boolean ENABLE_GRINDER() { return Defaults.ENABLE_GRINDER; }
    default boolean ENABLE_ESCAPE_LADDER() { return Defaults.ENABLE_ESCAPE_LADDER; }
    default boolean ENABLE_WATER() { return Defaults.ENABLE_WATER; }
    default boolean ENABLE_LAVA() { return Defaults.ENABLE_LAVA; }
    default boolean ENABLE_SUCTION() { return Defaults.ENABLE_SUCTION; }
    default boolean ENABLE_HARVEST() { return Defaults.ENABLE_HARVEST; }
    default boolean ENABLE_LIGHT() { return Defaults.ENABLE_LIGHT; }

    class Defaults {
        public static boolean TP_GRINDER = true;
        public static int RADIUS_HARVEST = 25;
        public static int RADIUS_LIGHT = 25;
        public static int LIGHT_MAX = 5;
        public static int MINING_LADDER_LAYER = -59;
        public static int RADIUS_DOME = 4;

        public static int MAX_LIQUID = 1000;
        public static int MAX_FILL = 1000;
        public static boolean SIMPLE_LIQUID = false;

        public static boolean ENABLE_MINING_LADDER = true;
        public static boolean ENABLE_GLASS_DOME = true;
        public static boolean ENABLE_GRINDER = true;
        public static boolean ENABLE_ESCAPE_LADDER = true;
        public static boolean ENABLE_WATER = true;
        public static boolean ENABLE_LAVA = true;
        public static boolean ENABLE_SUCTION = true;
        public static boolean ENABLE_HARVEST = true;
        public static boolean ENABLE_LIGHT = true;
    }
}