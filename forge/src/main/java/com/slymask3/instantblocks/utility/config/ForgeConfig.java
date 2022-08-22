package com.slymask3.instantblocks.utility.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class ForgeConfig implements IConfig {
	public static class Common {
		public static BooleanValue TP_GRINDER;
		public static IntValue RADIUS_HARVEST;
		public static IntValue RADIUS_LIGHT;
		public static IntValue LIGHT_MAX;
		public static IntValue MINING_LADDER_LAYER;

		public static IntValue MAX_LIQUID;
		public static IntValue MAX_FILL;
		public static BooleanValue SIMPLE_LIQUID;
		public static BooleanValue ENABLE_MINING_LADDER;
		public static BooleanValue ENABLE_GRINDER;
		public static BooleanValue ENABLE_ESCAPE_LADDER;
		public static BooleanValue ENABLE_WATER;
		public static BooleanValue ENABLE_LAVA;
		public static BooleanValue ENABLE_SUCTION;
		public static BooleanValue ENABLE_HARVEST;
		public static BooleanValue ENABLE_LIGHT;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("General settings").push("general");

			TP_GRINDER = builder
					.comment("Teleport the player to the collection room of the Instant Grinder.\nDefault: true")
					.define("TP_GRINDER", Defaults.TP_GRINDER);

			RADIUS_HARVEST = builder
					.comment("Radius to harvest blocks around Instant Harvest.\nDefault: 25")
					.defineInRange("RADIUS_HARVEST", Defaults.RADIUS_HARVEST,1,1000);

			RADIUS_LIGHT = builder
					.comment("Radius to light up dark areas around Instant Light.\nDefault: 25")
					.defineInRange("RADIUS_LIGHT", Defaults.RADIUS_LIGHT,1,1000);

			LIGHT_MAX = builder
					.comment("Maximum light level for placing a torch.\nDefault: 7")
					.defineInRange("LIGHT_MAX", Defaults.RADIUS_LIGHT,0,15);

			MINING_LADDER_LAYER = builder
					.comment("Mining layer for the Instant Mining Ladder.\nDefault: -59")
					.defineInRange("MINING_LADDER_LAYER", Defaults.MINING_LADDER_LAYER,-59,320);

			builder.pop();

			builder.comment("Toggling instant blocks").push("toggle");

			ENABLE_MINING_LADDER = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_MINING_LADDER", Defaults.ENABLE_MINING_LADDER);

			ENABLE_GRINDER = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_GRINDER", Defaults.ENABLE_GRINDER);

			ENABLE_ESCAPE_LADDER = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_ESCAPE_LADDER", Defaults.ENABLE_ESCAPE_LADDER);

			ENABLE_WATER = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_WATER", Defaults.ENABLE_WATER);

			ENABLE_LAVA = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_LAVA", Defaults.ENABLE_LAVA);

			ENABLE_SUCTION = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_SUCTION", Defaults.ENABLE_SUCTION);

			ENABLE_HARVEST = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_HARVEST", Defaults.ENABLE_HARVEST);

			ENABLE_LIGHT = builder
					.comment("Default: false")
					.worldRestart()
					.define("ENABLE_LIGHT", Defaults.ENABLE_LIGHT);

			builder.pop();

			builder.comment("Instant liquid blocks settings").push("liquid");

			MAX_LIQUID = builder
					.comment("Maximum amount of liquid blocks to generate.\nDefault: 1000")
					.defineInRange("MAX_LIQUID", Defaults.MAX_LIQUID,1,100000);

			MAX_FILL = builder
					.comment("Maximum amount of liquid blocks to fill in.\nDefault: 1000")
					.defineInRange("MAX_FILL", Defaults.MAX_FILL,1,100000);

			SIMPLE_LIQUID = builder
					.comment("Only generate liquid blocks on the block's layer, not below it.\nDefault: false")
					.define("SIMPLE_LIQUID", Defaults.SIMPLE_LIQUID);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static void init() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ForgeConfig.commonSpec);
	}

	public boolean TP_GRINDER() { return Common.TP_GRINDER.get(); }
	public int RADIUS_HARVEST() { return Common.RADIUS_HARVEST.get(); }
	public int RADIUS_LIGHT() { return Common.RADIUS_LIGHT.get(); }
	public int LIGHT_MAX() { return Common.LIGHT_MAX.get(); }
	public int MINING_LADDER_LAYER() { return Common.MINING_LADDER_LAYER.get(); }
	public int MAX_LIQUID() { return Common.MAX_LIQUID.get(); }
	public int MAX_FILL() { return Common.MAX_FILL.get(); }
	public boolean SIMPLE_LIQUID() { return Common.SIMPLE_LIQUID.get(); }
	public boolean ENABLE_MINING_LADDER() { return Common.ENABLE_MINING_LADDER.get(); }
	public boolean ENABLE_GRINDER() { return Common.ENABLE_GRINDER.get(); }
	public boolean ENABLE_ESCAPE_LADDER() { return Common.ENABLE_ESCAPE_LADDER.get(); }
	public boolean ENABLE_WATER() { return Common.ENABLE_WATER.get(); }
	public boolean ENABLE_LAVA() { return Common.ENABLE_LAVA.get(); }
	public boolean ENABLE_SUCTION() { return Common.ENABLE_SUCTION.get(); }
	public boolean ENABLE_HARVEST() { return Common.ENABLE_HARVEST.get(); }
	public boolean ENABLE_LIGHT() { return Common.ENABLE_LIGHT.get(); }
}