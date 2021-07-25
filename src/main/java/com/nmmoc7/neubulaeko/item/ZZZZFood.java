package com.nmmoc7.neubulaeko.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

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

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.zzzz_food"));
    }
}
