package com.slymask3.instantblocks.utility;

import com.slymask3.instantblocks.core.builder.Builder;
import com.slymask3.instantblocks.core.network.IPacketHandler;
import com.slymask3.instantblocks.core.network.packet.AbstractPacket;
import com.slymask3.instantblocks.core.platform.Services;
import com.slymask3.instantblocks.core.util.Helper;
import com.slymask3.instantblocks.utility.config.ClothConfig;
import com.slymask3.instantblocks.utility.handler.LootHandler;
import com.slymask3.instantblocks.utility.init.FabricTiles;
import com.slymask3.instantblocks.utility.init.IRegistryHelper;
import com.slymask3.instantblocks.utility.init.Registration;
import com.slymask3.instantblocks.utility.network.FabricPacketHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class InstantBlocks implements ModInitializer {
    @Override
    public void onInitialize() {
        Common.NETWORK = new PacketHandler();
        Common.TILES = new FabricTiles();

        if(Services.PLATFORM.isModLoaded("cloth-config")) {
            ClothConfig.register();
            Common.CONFIG = ClothConfig.get();
        }

        Registration.registerBlocks(new FabricRegistryHelper<>(Registry.BLOCK));
        Registration.registerItems(new FabricRegistryHelper<>(Registry.ITEM));
        Registration.registerTiles(new FabricRegistryHelper<>(Registry.BLOCK_ENTITY_TYPE));

        ServerTickEvents.END_SERVER_TICK.register((tick) -> Builder.globalTick());
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, entity) -> !Builder.inProgress(world,pos));

        LootHandler.register();
        FabricPacketHandler.Common.init();
        Common.init();
    }

    public static class FabricRegistryHelper<T> implements IRegistryHelper<T> {
        final Registry<T> registry;
        public FabricRegistryHelper(Registry<T> registry) {
            this.registry = registry;
        }
        public void register(ResourceLocation name, T entry) {
            Registry.register(this.registry, name, entry);
        }
    }

    public static class PacketHandler implements IPacketHandler {
        public void sendToServer(AbstractPacket message) {
            ClientPlayNetworking.send(message.getKey(), message.getBuffer());
        }
        public void sendToClient(Player player, AbstractPacket message) {
            if(Helper.isServer(player.getLevel())) {
                ServerPlayNetworking.send((ServerPlayer)player, message.getKey(), message.getBuffer());
            }
        }
        public void sendToAllAround(Level world, BlockPos pos, AbstractPacket message) {
            for(ServerPlayer player : PlayerLookup.tracking((ServerLevel)world, pos)) {
                ServerPlayNetworking.send(player, message.getKey(), message.getBuffer());
            }
        }
    }
}