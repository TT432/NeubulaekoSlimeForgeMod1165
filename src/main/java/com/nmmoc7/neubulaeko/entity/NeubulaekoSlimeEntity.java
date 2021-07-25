package com.nmmoc7.neubulaeko.entity;

import com.nmmoc7.neubulaeko.CommonRegisterHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

/**
 * @author DustW
 */
public class NeubulaekoSlimeEntity extends MobEntity {
    public static final DataParameter<Byte> FOOD_POINT =
            EntityDataManager.createKey(NeubulaekoSlimeEntity.class, DataSerializers.BYTE);
    public static final DataParameter<Boolean> CHILD =
            EntityDataManager.createKey(NeubulaekoSlimeEntity.class, DataSerializers.BOOLEAN);

    public NeubulaekoSlimeEntity(World worldIn) {
        this(CommonRegisterHandler.NEUBULAEKO_SLIME_ENTITY, worldIn);
    }

    public NeubulaekoSlimeEntity(EntityType<NeubulaekoSlimeEntity> neubulaekoSlimeEntityEntityType, World world) {
        super(neubulaekoSlimeEntityEntityType, world);
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return getDataManager().get(CHILD) ? super.getBoundingBox() : new AxisAlignedBB(
                getPosX() + 0.3,
                getPosY(),
                getPosZ() + 0.3,
                getPosX() - 0.3,
                getPosY() - 1,
                getPosZ() - 0.3
        );
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    @Override
    protected ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
        if (!world.isRemote) {
            ItemStack itemstack = playerIn.getHeldItem(hand);
            if (itemstack.getItem() == CommonRegisterHandler.ZZZZ_FOOD) {
                itemstack.shrink(1);
                byte foodPoint = getDataManager().get(FOOD_POINT);
                getDataManager().set(FOOD_POINT, (byte) (foodPoint + 1));

                if (foodPoint >= 100) {
                    getDataManager().set(CHILD, false);
                }
            }
        }

        return super.getEntityInteractionResult(playerIn, hand);
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.removed;
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
    public boolean isChild() {
        return getDataManager().get(CHILD);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FOOD_POINT, (byte) 0);
        this.dataManager.register(CHILD, true);
    }
}
