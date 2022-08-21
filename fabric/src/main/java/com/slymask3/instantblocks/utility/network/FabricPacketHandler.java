package com.slymask3.instantblocks.utility.network;

import com.slymask3.instantblocks.utility.network.packet.server.HarvestPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public class FabricPacketHandler {
    public static class Common {
        public static void init() {
            ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(com.slymask3.instantblocks.core.network.PacketHelper.PacketID.HARVEST.toString().toLowerCase()), (server, player, handler, buf, responseSender) -> {
                if(player != null) {
                    HarvestPacket message = HarvestPacket.decode(buf);
                    server.execute(() -> PacketHelper.handleHarvest(message, player));
                }
            });
        }
    }
}