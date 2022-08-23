package com.slymask3.instantblocks.utility.init;

import com.slymask3.instantblocks.core.Core;
import com.slymask3.instantblocks.core.init.IRegistryHelper;
import com.slymask3.instantblocks.utility.Common;
import com.slymask3.instantblocks.utility.registry.ModBlocks;
import com.slymask3.instantblocks.utility.registry.ModTiles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Registration {
    public static final class Names {
        public static final String IB_MINING_LADDER = "instant_mining_ladder";
        public static final String IB_GRINDER = "instant_grinder";
        public static final String IB_ESCAPE_LADDER = "instant_escape_ladder";
        public static final String IB_WATER = "instant_water";
        public static final String IB_LAVA = "instant_lava";
        public static final String IB_SUCTION = "instant_suction";
        public static final String IB_HARVEST = "instant_harvest";
        public static final String IB_LIGHT = "instant_light";
    }
    
    public static void registerBlocks(IRegistryHelper<Block> helper) {
        ModBlocks.init();
        helper.register(resource(Names.IB_MINING_LADDER), ModBlocks.INSTANT_MINING_LADDER);
        helper.register(resource(Names.IB_GRINDER), ModBlocks.INSTANT_GRINDER);
        helper.register(resource(Names.IB_ESCAPE_LADDER), ModBlocks.INSTANT_ESCAPE_LADDER);
        helper.register(resource(Names.IB_WATER), ModBlocks.INSTANT_WATER);
        helper.register(resource(Names.IB_LAVA), ModBlocks.INSTANT_LAVA);
        helper.register(resource(Names.IB_SUCTION), ModBlocks.INSTANT_SUCTION);
        helper.register(resource(Names.IB_HARVEST), ModBlocks.INSTANT_HARVEST);
        helper.register(resource(Names.IB_LIGHT), ModBlocks.INSTANT_LIGHT);
    }

    public static void registerItems(IRegistryHelper<Item> helper) {
        helper.register(resource(Names.IB_MINING_LADDER), blockItem(ModBlocks.INSTANT_MINING_LADDER));
        helper.register(resource(Names.IB_GRINDER), blockItem(ModBlocks.INSTANT_GRINDER));
        helper.register(resource(Names.IB_ESCAPE_LADDER), blockItem(ModBlocks.INSTANT_ESCAPE_LADDER));
        helper.register(resource(Names.IB_WATER), blockItem(ModBlocks.INSTANT_WATER));
        helper.register(resource(Names.IB_LAVA), blockItem(ModBlocks.INSTANT_LAVA));
        helper.register(resource(Names.IB_SUCTION), blockItem(ModBlocks.INSTANT_SUCTION));
        helper.register(resource(Names.IB_HARVEST), blockItem(ModBlocks.INSTANT_HARVEST));
        helper.register(resource(Names.IB_LIGHT), blockItem(ModBlocks.INSTANT_LIGHT));
    }

    public static void registerTiles(IRegistryHelper<BlockEntityType<?>> helper) {
        Common.TILES.init();
        helper.register(resource(Names.IB_HARVEST), ModTiles.HARVEST);
    }

    private static ResourceLocation resource(String name) {
        return new ResourceLocation(Common.FABRIC_MOD_ID,name);
    }
    
    private static BlockItem blockItem(Block block) {
        Common.LOG.info("Core.ITEM_GROUP: {}", Core.ITEM_GROUP);
        return new BlockItem(block,new Item.Properties().tab(Core.ITEM_GROUP));
    }
}