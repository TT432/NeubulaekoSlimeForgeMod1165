package com.nmmoc7.neubulaeko;

import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonRegisterHandler {
    public static final EntityType<NeubulaekoSlimeEntity> NEUBULAEKO_SLIME_ENTITY =
            EntityType.Builder.create(NeubulaekoSlimeEntity::new, EntityClassification.MISC)
                    .size(0.25F, 0.25F)
                    .trackingRange(4)
                    .updateInterval(10).build("neubulaeko_slime_entity");

    @SubscribeEvent
    public static void onEntityTypeRegistry(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(
                NEUBULAEKO_SLIME_ENTITY.setRegistryName(new ResourceLocation(NeubulaekoSlime.MOD_ID, "neubulaeko_slime_entity"))
        );
    }
}
