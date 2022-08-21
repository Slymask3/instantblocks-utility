package com.slymask3.instantblocks.utility.registry;

import com.slymask3.instantblocks.utility.block.instant.*;
import net.minecraft.world.level.block.Block;

public class ModBlocks {
    public static Block INSTANT_MINING_LADDER;
    public static Block INSTANT_GRINDER;
    public static Block INSTANT_ESCAPE_LADDER;
    public static Block INSTANT_WATER;
    public static Block INSTANT_LAVA;
    public static Block INSTANT_SUCTION;
    public static Block INSTANT_HARVEST;
    public static Block INSTANT_LIGHT;

    public static void init() {
        INSTANT_MINING_LADDER = new InstantMiningLadderBlock();
        INSTANT_GRINDER = new InstantGrinderBlock();
        INSTANT_ESCAPE_LADDER = new InstantEscapeLadderBlock();
        INSTANT_WATER = new InstantWaterBlock();
        INSTANT_LAVA = new InstantLavaBlock();
        INSTANT_SUCTION = new InstantSuctionBlock();
        INSTANT_HARVEST = new InstantHarvestBlock();
        INSTANT_LIGHT = new InstantLightBlock();
    }
}