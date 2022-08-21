package com.slymask3.instantblocks.utility.init;

import com.slymask3.instantblocks.utility.Common;
import net.minecraft.resources.ResourceLocation;

public interface IRegistryHelper<T> {
    void register(ResourceLocation name, T entry);
    default void register(String name, T entry) {
        register(new ResourceLocation(Common.FABRIC_MOD_ID, name), entry);
    }
}