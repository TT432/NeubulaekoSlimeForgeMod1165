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
    public boolean equip;

    public NeubulaekoMedal(ItemStack itemStack) {
        curio = itemStack;
    }

    @Override
    public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            equip = true;
            NeubulaekoSlimeMedalItem.remove(curio, livingEntity.world);
        }
    }

    @Override
    public void onEquip(String identifier, int index, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity) {
            equip = false;
            NeubulaekoSlimeMedalItem.add((PlayerEntity) livingEntity, curio, livingEntity.world);
        }
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity) {
        ICurio.super.curioTick(identifier, index, livingEntity);
        curio.inventoryTick(livingEntity.world, livingEntity, 0, false);
    }

    @Override
    public boolean canRightClickEquip() {
        return false;
    }
}
