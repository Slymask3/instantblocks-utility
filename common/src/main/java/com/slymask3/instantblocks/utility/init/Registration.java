package com.slymask3.instantblocks.utility.init;

import com.slymask3.instantblocks.utility.Common;
import com.slymask3.instantblocks.utility.registry.ModBlocks;
import com.slymask3.instantblocks.utility.registry.ModTiles;
import com.slymask3.instantblocks.utility.item.InstantBlockItem;
import com.slymask3.instantblocks.utility.reference.Names;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Registration {
    public static void registerBlocks(IRegistryHelper<Block> helper) {
        ModBlocks.init();
        helper.register(Names.Blocks.IB_MINING_LADDER, ModBlocks.INSTANT_MINING_LADDER);
        helper.register(Names.Blocks.IB_GRINDER, ModBlocks.INSTANT_GRINDER);
        helper.register(Names.Blocks.IB_ESCAPE_LADDER, ModBlocks.INSTANT_ESCAPE_LADDER);
        helper.register(Names.Blocks.IB_WATER, ModBlocks.INSTANT_WATER);
        helper.register(Names.Blocks.IB_LAVA, ModBlocks.INSTANT_LAVA);
        helper.register(Names.Blocks.IB_SUCTION, ModBlocks.INSTANT_SUCTION);
        helper.register(Names.Blocks.IB_HARVEST, ModBlocks.INSTANT_HARVEST);
        helper.register(Names.Blocks.IB_LIGHT, ModBlocks.INSTANT_LIGHT);
    }

    public static void registerItems(IRegistryHelper<Item> helper) {
        helper.register(Names.Blocks.IB_MINING_LADDER, new InstantBlockItem(ModBlocks.INSTANT_MINING_LADDER));
        helper.register(Names.Blocks.IB_GRINDER, new InstantBlockItem(ModBlocks.INSTANT_GRINDER));
        helper.register(Names.Blocks.IB_ESCAPE_LADDER, new InstantBlockItem(ModBlocks.INSTANT_ESCAPE_LADDER));
        helper.register(Names.Blocks.IB_WATER, new InstantBlockItem(ModBlocks.INSTANT_WATER));
        helper.register(Names.Blocks.IB_LAVA, new InstantBlockItem(ModBlocks.INSTANT_LAVA));
        helper.register(Names.Blocks.IB_SUCTION, new InstantBlockItem(ModBlocks.INSTANT_SUCTION));
        helper.register(Names.Blocks.IB_HARVEST, new InstantBlockItem(ModBlocks.INSTANT_HARVEST));
        helper.register(Names.Blocks.IB_LIGHT, new InstantBlockItem(ModBlocks.INSTANT_LIGHT));
    }

    public static void registerTiles(IRegistryHelper<BlockEntityType<?>> helper) {
        Common.TILES.init();
        helper.register(Names.Blocks.IB_HARVEST, ModTiles.HARVEST);
    }
}