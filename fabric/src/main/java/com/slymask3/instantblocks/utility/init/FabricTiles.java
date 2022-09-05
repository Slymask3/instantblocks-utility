package com.slymask3.instantblocks.utility.init;

import com.slymask3.instantblocks.core.init.IBasicHelper;
import com.slymask3.instantblocks.utility.block.entity.HarvestBlockEntity;
import com.slymask3.instantblocks.utility.registry.ModBlocks;
import com.slymask3.instantblocks.utility.registry.ModTiles;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class FabricTiles implements IBasicHelper {
    public void init() {
        ModTiles.HARVEST = FabricBlockEntityTypeBuilder.create(HarvestBlockEntity::new, ModBlocks.INSTANT_HARVEST).build(null);
    }
}