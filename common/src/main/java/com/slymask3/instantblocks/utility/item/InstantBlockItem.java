package com.slymask3.instantblocks.utility.item;

import com.slymask3.instantblocks.core.Core;
import com.slymask3.instantblocks.core.block.InstantBlock;
import com.slymask3.instantblocks.utility.Common;
import com.slymask3.instantblocks.utility.registry.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class InstantBlockItem extends BlockItem {
	private final Block block;
	
	public InstantBlockItem(Block block) {
		super(block,new Item.Properties().tab(Core.ITEM_GROUP));
		this.block = block;
	}

	public void appendHoverText(ItemStack is, @Nullable Level world, List<Component> list, TooltipFlag flag) {
		if(block == ModBlocks.INSTANT_MINING_LADDER) {
			list.add(Component.translatable("ib.tooltip.mining_ladder", Common.CONFIG.MINING_LADDER_LAYER()));
		} else if(block == ModBlocks.INSTANT_GRINDER) {
			list.add(Component.translatable("ib.tooltip.grinder.1"));
			list.add(Component.translatable("ib.tooltip.grinder.2"));
		} else if(block == ModBlocks.INSTANT_ESCAPE_LADDER) {
			list.add(Component.translatable("ib.tooltip.escape_ladder"));
		} else if(block == ModBlocks.INSTANT_WATER) {
			list.add(Component.translatable("ib.tooltip.water"));
			list.add(Component.translatable("ib.tooltip.water.max", Common.CONFIG.MAX_LIQUID()));
			list.add(Component.translatable("ib.tooltip.liquid.mode", (Common.CONFIG.SIMPLE_LIQUID() ? "Simple" : "Full")));
		} else if(block == ModBlocks.INSTANT_LAVA) {
			list.add(Component.translatable("ib.tooltip.lava"));
			list.add(Component.translatable("ib.tooltip.lava.max", Common.CONFIG.MAX_LIQUID()));
			list.add(Component.translatable("ib.tooltip.liquid.mode", (Common.CONFIG.SIMPLE_LIQUID() ? "Simple" : "Full")));
		} else if(block == ModBlocks.INSTANT_SUCTION) {
			list.add(Component.translatable("ib.tooltip.suction"));
			list.add(Component.translatable("ib.tooltip.suction.max", Common.CONFIG.MAX_FILL()));
		} else if(block == ModBlocks.INSTANT_HARVEST) {
			list.add(Component.translatable("ib.tooltip.harvest"));
			list.add(Component.translatable("ib.tooltip.radius", Common.CONFIG.RADIUS_HARVEST()));
		} else if(block == ModBlocks.INSTANT_LIGHT) {
			list.add(Component.translatable("ib.tooltip.light"));
			list.add(Component.translatable("ib.tooltip.radius", Common.CONFIG.RADIUS_LIGHT()));
		}
		if(block instanceof InstantBlock) {
			list.add(Component.translatable("ib.tooltip.activate"));
		}
	}
}