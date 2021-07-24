package com.nmmoc7.neubulaeko;

import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeChildEntity;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.item.TestItem;
import com.nmmoc7.neubulaeko.item.ZZZZFood;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
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
            EntityType.Builder.<NeubulaekoSlimeEntity>create(NeubulaekoSlimeEntity::new, EntityClassification.MISC)
                    .size(0.25F, 0.25F)
                    .trackingRange(4)
                    .updateInterval(10).build("neubulaeko_slime_entity");

    public static final EntityType<NeubulaekoSlimeChildEntity> NEUBULAEKO_SLIME_CHILD_ENTITY =
            EntityType.Builder.<NeubulaekoSlimeChildEntity>create(NeubulaekoSlimeChildEntity::new, EntityClassification.MISC)
                    .size(0.25F, 0.25F)
                    .trackingRange(4)
                    .updateInterval(10).build("neubulaeko_slime_child_entity");

    @SubscribeEvent
    public static void onEntityTypeRegistry(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(
                NEUBULAEKO_SLIME_ENTITY.setRegistryName(new ResourceLocation(NeubulaekoSlime.MOD_ID, "neubulaeko_slime_entity")),
                NEUBULAEKO_SLIME_CHILD_ENTITY.setRegistryName(new ResourceLocation(NeubulaekoSlime.MOD_ID, "neubulaeko_slime_child_entity"))
        );
    }

    public static final TestItem TEST_ITEM = new TestItem();
    public static final ZZZZFood ZZZZ_FOOD = new ZZZZFood();

    @SubscribeEvent
    public static void onItemRegistry(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                TEST_ITEM.setRegistryName(new ResourceLocation(NeubulaekoSlime.MOD_ID, "test_item")),
                ZZZZ_FOOD.setRegistryName(new ResourceLocation(NeubulaekoSlime.MOD_ID, "zzzz_food"))
        );
    }
}
