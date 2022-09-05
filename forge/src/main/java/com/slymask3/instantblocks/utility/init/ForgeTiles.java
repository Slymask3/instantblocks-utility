package com.slymask3.instantblocks.utility.init;

import com.slymask3.instantblocks.core.init.IBasicHelper;
import com.slymask3.instantblocks.utility.block.entity.HarvestBlockEntity;
import com.slymask3.instantblocks.utility.registry.ModBlocks;
import com.slymask3.instantblocks.utility.registry.ModTiles;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ForgeTiles implements IBasicHelper {
    public void init() {
        ModTiles.HARVEST = BlockEntityType.Builder.of(HarvestBlockEntity::new, ModBlocks.INSTANT_HARVEST).build(null);
    }
}