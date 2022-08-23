package com.slymask3.instantblocks.utility.network;

import com.slymask3.instantblocks.utility.network.packet.server.HarvestPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class FabricPacketHandler {
    public static class Common {
        public static void init() {
            ServerPlayNetworking.registerGlobalReceiver(PacketHelper.PACKET_HARVEST, (server, player, handler, buf, responseSender) -> {
                if(player != null) {
                    HarvestPacket message = HarvestPacket.decode(buf);
                    server.execute(() -> PacketHelper.handleHarvest(message, player));
                }
            });
        }
    }
}