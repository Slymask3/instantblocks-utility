package com.slymask3.instantblocks.utility.network;

import com.slymask3.instantblocks.core.block.InstantBlock;
import com.slymask3.instantblocks.core.network.packet.InstantPacket;
import com.slymask3.instantblocks.core.util.Helper;
import com.slymask3.instantblocks.utility.block.entity.HarvestBlockEntity;
import com.slymask3.instantblocks.utility.network.packet.server.HarvestPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PacketHelper {
    public enum PacketID {
        HARVEST
    }

    private static void activate(InstantPacket message, Level world, Player player) {
        if(message.activate) {
            InstantBlock block = (InstantBlock) Helper.getBlock(world,message.pos);
            block.activate(world,message.pos,player);
        }
    }

    public static void handleHarvest(HarvestPacket message, Player player) {
        Level world = player.getLevel();
        HarvestBlockEntity blockEntity = (HarvestBlockEntity)world.getBlockEntity(message.pos);
        if(blockEntity != null) {
            blockEntity.update(message._logOak, message._logSpruce, message._logBirch, message._logJungle, message._logAcacia, message._logDark, message._wheat, message._carrot, message._potato, message._cactus, message._pumpkin, message._melon, message._sugarcane, message._cocoa, message._mushroom, message._netherwart, message._replant);
            activate(message, world, player);
        }
    }
}