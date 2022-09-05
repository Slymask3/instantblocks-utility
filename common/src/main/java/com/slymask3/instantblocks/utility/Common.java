package com.slymask3.instantblocks.utility;

import com.slymask3.instantblocks.core.Core;
import com.slymask3.instantblocks.core.init.IBasicHelper;
import com.slymask3.instantblocks.utility.config.IConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Common {
    public static final String MOD_ADDON = "utility";
    public static final String FABRIC_MOD_ID = Core.MOD_BASE + "-" + MOD_ADDON;
    public static final String FORGE_MOD_ID = Core.MOD_BASE + "_" + MOD_ADDON;
    public static final Logger LOG = LoggerFactory.getLogger(FABRIC_MOD_ID);

    public static IBasicHelper TILES;
    public static IConfig CONFIG = new IConfig(){};

    public static void init() {

    }

    public static class Strings {
        private static final String ERROR = "ib.message.error.";
        public static final String ERROR_GRINDER = ERROR + "grinder";
        public static final String ERROR_LADDER = ERROR + "mining_ladder";
        public static final String ERROR_ESCAPE_LADDER = ERROR + "escape_ladder";
        public static final String ERROR_WATER_MAX = ERROR + "water_max";
        public static final String ERROR_LAVA_MAX = ERROR + "lava_max";
        public static final String ERROR_NO_LIQUID = ERROR + "no_liquid";
        public static final String ERROR_SUCTION = ERROR + "suction";
        public static final String ERROR_WATER_DISABLED = ERROR + "water_disabled";

        private static final String CREATE = "ib.message.create.";
        public static final String CREATE_DOME = CREATE + "dome";
        public static final String CREATE_GRINDER = CREATE + "grinder";
        public static final String CREATE_MINING_LADDER = CREATE + "mining_ladder";
        public static final String CREATE_LAVA = CREATE + "lava";
        public static final String CREATE_LAVA_1 = CREATE + "lava_single";
        public static final String CREATE_WATER = CREATE + "water";
        public static final String CREATE_WATER_1 = CREATE + "water_single";
        public static final String CREATE_SUCTION = CREATE + "suction";
        public static final String CREATE_SUCTION_1 = CREATE + "suction_single";
        public static final String CREATE_HARVEST = CREATE + "harvest";
        public static final String CREATE_LIGHT = CREATE + "light";
        public static final String CREATE_ESCAPE_LADDER = CREATE + "escape_ladder";
    }
}