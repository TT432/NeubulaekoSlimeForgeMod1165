package com.nmmoc7.neubulaeko.support.curios;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosCapability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author DustW
 */
public class CuriosCapProvider implements ICapabilityProvider {
    private final LazyOptional<NeubulaekoMedal> neubulaekoMedalCap;

    public CuriosCapProvider(ItemStack itemStack) {
        neubulaekoMedalCap = LazyOptional.of(() -> new NeubulaekoMedal(itemStack));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CuriosCapability.ITEM ? neubulaekoMedalCap.cast() : LazyOptional.empty();
    }
}
