package com.slymask3.instantblocks.utility.network;

import com.slymask3.instantblocks.core.network.packet.AbstractPacket;
import com.slymask3.instantblocks.utility.network.packet.server.HarvestPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ForgePacketHandler {
    public static void register() {
        int index = 300;
        com.slymask3.instantblocks.core.network.ForgePacketHandler.INSTANCE.registerMessage(++index, HarvestPacket.class, (HarvestPacket message, FriendlyByteBuf buffer) -> message.write(message,buffer), HarvestPacket::decode, Handler::server);
    }

    public static class Handler {
        public static void server(AbstractPacket message, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                Player player = context.get().getSender();
                if(player != null) {
                    if(message.getClass().equals(HarvestPacket.class)) {
                        PacketHelper.handleHarvest((HarvestPacket)message, player);
                    }
                }
            });
            context.get().setPacketHandled(true);
        }
    }
}