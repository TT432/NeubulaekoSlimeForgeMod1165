package com.nmmoc7.neubulaeko;

import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.item.TestItem;
import com.nmmoc7.neubulaeko.item.ZZZZFood;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonRegisterHandler {
    public static final EntityType<NeubulaekoSlimeEntity> NEUBULAEKO_SLIME_ENTITY =
            EntityType.Builder.<NeubulaekoSlimeEntity>create(NeubulaekoSlimeEntity::new, EntityClassification.CREATURE)
                    .size(0.25F, 0.25F)
                    .trackingRange(4)
                    .updateInterval(10).build("neubulaeko_slime_entity");

    @SubscribeEvent
    public static void onEntityTypeRegistry(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(
                NEUBULAEKO_SLIME_ENTITY.setRegistryName(new ResourceLocation(NeubulaekoSlime.MOD_ID, "neubulaeko_slime_entity"))
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

    @SubscribeEvent
    public static void addAttribute(EntityAttributeCreationEvent event) {
        event.put(NEUBULAEKO_SLIME_ENTITY, registerAttributes().create());
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2);
    }
}
