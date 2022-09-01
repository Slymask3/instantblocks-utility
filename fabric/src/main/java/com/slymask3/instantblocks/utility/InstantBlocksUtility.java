package com.slymask3.instantblocks.utility;

import com.slymask3.instantblocks.core.InstantBlocksCore;
import com.slymask3.instantblocks.core.platform.Services;
import com.slymask3.instantblocks.utility.config.ClothConfig;
import com.slymask3.instantblocks.utility.handler.LootHandler;
import com.slymask3.instantblocks.utility.init.FabricTiles;
import com.slymask3.instantblocks.utility.init.Registration;
import com.slymask3.instantblocks.utility.network.FabricPacketHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public class InstantBlocksUtility implements ModInitializer {
    @Override
    public void onInitialize() {
        Common.LOG.info("loading mod: {}", Common.FABRIC_MOD_ID);

        Common.init();
        Common.TILES = new FabricTiles();

        if(Services.PLATFORM.isModLoaded("cloth-config")) {
            ClothConfig.register();
            Common.CONFIG = ClothConfig.get();
        }

        Registration.registerBlocks(new InstantBlocksCore.FabricRegistryHelper<>(Registry.BLOCK));
        Registration.registerItems(new InstantBlocksCore.FabricRegistryHelper<>(Registry.ITEM));
        Registration.registerTiles(new InstantBlocksCore.FabricRegistryHelper<>(Registry.BLOCK_ENTITY_TYPE));

        LootHandler.register();
        FabricPacketHandler.Common.init();
    }
}