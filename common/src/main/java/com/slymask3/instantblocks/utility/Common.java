package com.slymask3.instantblocks.utility;

import com.slymask3.instantblocks.core.Core;
import com.slymask3.instantblocks.core.init.ITileHelper;
import com.slymask3.instantblocks.utility.config.IConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Common {
    public static final String MOD_ADDON = "utility";
    public static final String FABRIC_MOD_ID = Core.MOD_BASE + "-" + MOD_ADDON;
    public static final String FORGE_MOD_ID = Core.MOD_BASE + "_" + MOD_ADDON;
    public static final Logger LOG = LoggerFactory.getLogger(FABRIC_MOD_ID);
    public static ITileHelper TILES;
    public static IConfig CONFIG = new IConfig(){};

    public static void init() {

    }
}