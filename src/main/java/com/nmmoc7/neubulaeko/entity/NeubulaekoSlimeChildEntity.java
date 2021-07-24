package com.nmmoc7.neubulaeko.entity;

import com.nmmoc7.neubulaeko.CommonRegisterHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * @author DustW
 */
public class NeubulaekoSlimeChildEntity extends ThrowableEntity {
    public NeubulaekoSlimeChildEntity(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public NeubulaekoSlimeChildEntity(double x, double y, double z, World worldIn) {
        super(CommonRegisterHandler.NEUBULAEKO_SLIME_CHILD_ENTITY, x, y, z, worldIn);
    }

    public NeubulaekoSlimeChildEntity(LivingEntity livingEntityIn, World worldIn) {
        super(CommonRegisterHandler.NEUBULAEKO_SLIME_CHILD_ENTITY, livingEntityIn, worldIn);
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
