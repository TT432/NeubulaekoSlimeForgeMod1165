package com.nmmoc7.neubulaeko.entity;

import com.nmmoc7.neubulaeko.CommonRegisterHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * @author DustW
 */
public class NeubulaekoSlimeEntity extends ThrowableEntity {
    public NeubulaekoSlimeEntity(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public NeubulaekoSlimeEntity(double x, double y, double z, World worldIn) {
        super(CommonRegisterHandler.NEUBULAEKO_SLIME_ENTITY, x, y, z, worldIn);
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return new AxisAlignedBB(
                getPosX() + 0.5,
                getPosY() + 1.5,
                getPosZ() + 0.5,
                getPosX(),
                getPosY(),
                getPosZ()
        );
    }

    protected NeubulaekoSlimeEntity(LivingEntity livingEntityIn, World worldIn) {
        super(CommonRegisterHandler.NEUBULAEKO_SLIME_ENTITY, livingEntityIn, worldIn);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected float getGravityVelocity() {
        return 0;
    }

    @Override
    protected void registerData() {

    }
}
