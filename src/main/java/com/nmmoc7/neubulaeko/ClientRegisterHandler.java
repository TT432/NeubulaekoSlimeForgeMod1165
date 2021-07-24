package com.nmmoc7.neubulaeko;

import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeChildEntity;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.renderer.NeubulaekoSlimeChildRenderer;
import com.nmmoc7.neubulaeko.renderer.NeubulaekoSlimeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegisterHandler {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        Minecraft mc = Minecraft.getInstance();
        EntityRendererManager manager = mc.getRenderManager();
        manager.register(CommonRegisterHandler.NEUBULAEKO_SLIME_ENTITY, new NeubulaekoSlimeRenderer(manager));
        manager.register(CommonRegisterHandler.NEUBULAEKO_SLIME_CHILD_ENTITY, new NeubulaekoSlimeChildRenderer(manager));
    }
}
