package com.slymask3.instantblocks.utility.handler;

import com.slymask3.instantblocks.core.platform.Services;
import com.slymask3.instantblocks.utility.config.ClothConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if(Services.PLATFORM.isModLoaded("cloth-config")) {
            return parent -> AutoConfig.getConfigScreen(ClothConfig.class, parent).get();
        }
        return screen -> null;
    }
}