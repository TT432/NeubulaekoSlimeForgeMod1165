package com.nmmoc7.neubulaeko.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * @author DustW
 */
public class NeubulaekoSlimeEntity extends ThrowableEntity {
    public NeubulaekoSlimeEntity(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected NeubulaekoSlimeEntity(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    protected NeubulaekoSlimeEntity(EntityType<? extends ThrowableEntity> type, LivingEntity livingEntityIn, World worldIn) {
        super(type, livingEntityIn, worldIn);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerData() {

    }
}
