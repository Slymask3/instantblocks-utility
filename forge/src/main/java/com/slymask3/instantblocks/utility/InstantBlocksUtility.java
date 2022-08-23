package com.slymask3.instantblocks.utility;

import com.slymask3.instantblocks.core.InstantBlocksCore;
import com.slymask3.instantblocks.core.platform.Services;
import com.slymask3.instantblocks.utility.config.ClothConfig;
import com.slymask3.instantblocks.utility.config.ForgeConfig;
import com.slymask3.instantblocks.utility.init.ForgeTiles;
import com.slymask3.instantblocks.utility.init.Registration;
import com.slymask3.instantblocks.utility.network.ForgePacketHandler;
import net.minecraft.core.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Common.FORGE_MOD_ID)
public class InstantBlocksUtility {
	public InstantBlocksUtility() {
		Common.TILES = new ForgeTiles();

		if(Services.PLATFORM.isModLoaded("cloth_config")) {
			ClothConfig.register();
			Common.CONFIG = ClothConfig.get();
		} else {
			ForgeConfig.init();
			Common.CONFIG = new ForgeConfig();
		}

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setupCommon);
		modEventBus.addListener(this::setupRegistry);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setupCommon(final FMLCommonSetupEvent event) {
		ForgePacketHandler.register();
		Common.init();
	}

	private void setupRegistry(final RegisterEvent event) {
		if(event.getForgeRegistry() != null) {
			if(event.getForgeRegistry().getRegistryKey().equals(Registry.BLOCK_REGISTRY)) {
				Registration.registerBlocks(new InstantBlocksCore.ForgeRegistryHelper<>(event.getForgeRegistry()));
			} else if(event.getForgeRegistry().getRegistryKey().equals(Registry.ITEM_REGISTRY)) {
				Registration.registerItems(new InstantBlocksCore.ForgeRegistryHelper<>(event.getForgeRegistry()));
			} else if(event.getForgeRegistry().getRegistryKey().equals(Registry.BLOCK_ENTITY_TYPE_REGISTRY)) {
				Registration.registerTiles(new InstantBlocksCore.ForgeRegistryHelper<>(event.getForgeRegistry()));
			}
		}
	}
}