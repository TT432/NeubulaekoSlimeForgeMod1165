package com.nmmoc7.neubulaeko.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/**
 * @author DustW
 */
public class ZZZZFood extends Item {
    public ZZZZFood() {
        super(new Properties().group(ItemGroup.FOOD).food(
                new Food.Builder()
                    .effect(() -> new EffectInstance(Effects.NAUSEA, 10 * 20, 0), 1)
                    .hunger(5)
                    .build()
        ));
    }
}
