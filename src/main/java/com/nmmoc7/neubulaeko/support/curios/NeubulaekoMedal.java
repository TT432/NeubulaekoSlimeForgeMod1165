package com.nmmoc7.neubulaeko.support.curios;

import com.nmmoc7.neubulaeko.item.NeubulaekoSlimeMedalItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurio;

/**
 * @author DustW
 */
public class NeubulaekoMedal implements ICurio {
    ItemStack curio;

    public NeubulaekoMedal(ItemStack itemStack) {
        curio = itemStack;
    }

    @Override
    public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            NeubulaekoSlimeMedalItem.remove(curio, livingEntity.world);
        }
    }

    @Override
    public void onEquip(String identifier, int index, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            NeubulaekoSlimeMedalItem.add((PlayerEntity) livingEntity, curio, livingEntity.world);
        }
    }

    @Override
    public boolean canRightClickEquip() {
        return false;
    }
}
