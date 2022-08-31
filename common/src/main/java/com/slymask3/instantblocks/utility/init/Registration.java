package com.slymask3.instantblocks.utility.init;

import com.slymask3.instantblocks.core.Core;
import com.slymask3.instantblocks.core.init.IRegistryHelper;
import com.slymask3.instantblocks.utility.Common;
import com.slymask3.instantblocks.utility.registry.ModBlocks;
import com.slymask3.instantblocks.utility.registry.ModTiles;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Registration {
    public static final class Names {
        public static final String MINING_LADDER = "instant_mining_ladder";
        public static final String GRINDER = "instant_grinder";
        public static final String ESCAPE_LADDER = "instant_escape_ladder";
        public static final String WATER = "instant_water";
        public static final String LAVA = "instant_lava";
        public static final String SUCTION = "instant_suction";
        public static final String HARVEST = "instant_harvest";
        public static final String LIGHT = "instant_light";
    }
    
    public static void registerBlocks(IRegistryHelper<Block> helper) {
        ModBlocks.init();
        helper.register(resource(Names.MINING_LADDER), ModBlocks.INSTANT_MINING_LADDER);
        helper.register(resource(Names.GRINDER), ModBlocks.INSTANT_GRINDER);
        helper.register(resource(Names.ESCAPE_LADDER), ModBlocks.INSTANT_ESCAPE_LADDER);
        helper.register(resource(Names.WATER), ModBlocks.INSTANT_WATER);
        helper.register(resource(Names.LAVA), ModBlocks.INSTANT_LAVA);
        helper.register(resource(Names.SUCTION), ModBlocks.INSTANT_SUCTION);
        helper.register(resource(Names.HARVEST), ModBlocks.INSTANT_HARVEST);
        helper.register(resource(Names.LIGHT), ModBlocks.INSTANT_LIGHT);
    }

    public static void registerItems(IRegistryHelper<Item> helper) {
        helper.register(resource(Names.MINING_LADDER), blockItem(ModBlocks.INSTANT_MINING_LADDER));
        helper.register(resource(Names.GRINDER), blockItem(ModBlocks.INSTANT_GRINDER));
        helper.register(resource(Names.ESCAPE_LADDER), blockItem(ModBlocks.INSTANT_ESCAPE_LADDER));
        helper.register(resource(Names.WATER), blockItem(ModBlocks.INSTANT_WATER));
        helper.register(resource(Names.LAVA), blockItem(ModBlocks.INSTANT_LAVA));
        helper.register(resource(Names.SUCTION), blockItem(ModBlocks.INSTANT_SUCTION));
        helper.register(resource(Names.HARVEST), blockItem(ModBlocks.INSTANT_HARVEST));
        helper.register(resource(Names.LIGHT), blockItem(ModBlocks.INSTANT_LIGHT));
    }

    public static void registerTiles(IRegistryHelper<BlockEntityType<?>> helper) {
        Common.TILES.init();
        helper.register(resource(Names.HARVEST), ModTiles.HARVEST);
    }

    private static ResourceLocation resource(String name) {
        return new ResourceLocation(Common.FABRIC_MOD_ID,name);
    }
    
    private static BlockItem blockItem(Block block) {
        Common.LOG.info("Core.ITEM_GROUP: {}", Core.ITEM_GROUP);
        return new BlockItem(block,new Item.Properties().tab(Core.ITEM_GROUP).rarity(Rarity.RARE));
    }
}