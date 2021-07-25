package com.nmmoc7.neubulaeko;

import net.minecraft.item.ItemModelsProperties;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OnClientSetup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(OnClientSetup::registerProperties);
    }

    static void registerProperties() {
        ItemModelsProperties.registerProperty(CommonRegisterHandler.NEUBULAEKO_SLIME_MEDAL_ITEM, new ResourceLocation("child"),
                (itemStack, world, entity) -> {
                    if (itemStack.getOrCreateTag().contains("addInfo")) {
                        if (((CompoundNBT) itemStack.getOrCreateTag().get("addInfo")).getInt("food") >= 100) {
                            return 1;
                        }
                    }

                    return 0;
                });
    }
}