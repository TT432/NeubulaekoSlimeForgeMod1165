package com.nmmoc7.neubulaeko.entity;

import com.nmmoc7.neubulaeko.CommonRegisterHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.UUID;

/**
 * @author DustW
 */
public class NeubulaekoSlimeEntity extends MobEntity {
    public static final DataParameter<Byte> FOOD_POINT =
            EntityDataManager.createKey(NeubulaekoSlimeEntity.class, DataSerializers.BYTE);
    public static final DataParameter<Boolean> CHILD =
            EntityDataManager.createKey(NeubulaekoSlimeEntity.class, DataSerializers.BOOLEAN);

    UUID owner;

    public NeubulaekoSlimeEntity(World worldIn) {
        this(CommonRegisterHandler.NEUBULAEKO_SLIME_ENTITY, worldIn);
    }

    public NeubulaekoSlimeEntity(EntityType<NeubulaekoSlimeEntity> neubulaekoSlimeEntityEntityType, World world) {
        super(neubulaekoSlimeEntityEntityType, world);
        this.moveController = new MoveHelperController(this);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        playSound(SoundEvents.ENTITY_SLIME_HURT, 1, 1);
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

                playSound(SoundEvents.ENTITY_SLIME_JUMP_SMALL, 1, 1);

                if (foodPoint >= 100) {
                    getDataManager().set(CHILD, false);
                }
            }
        }

        return super.getEntityInteractionResult(playerIn, hand);
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (!world.isRemote) {
            setMotion(getMotion().add(0, 0.05, 0));

            PlayerEntity owner = world.getPlayerByUuid(this.owner);
            if (owner != null) {
                Vector3d target = owner.getPositionVec();

                if (owner.getHeldItemMainhand().getItem() == CommonRegisterHandler.ZZZZ_FOOD) {
                    target = target.subtract(owner.getLookVec().mul(-1, 0, -1).normalize().scale(2));
                }
                else {
                    target = target.subtract(owner.getLookVec().mul(1, 0, 1).normalize().scale(2));
                }

                getMoveHelper().setMoveTo(target.x, target.y, target.z, 2);

                this.rotationYaw = getTargetYaw(owner);

                if (getPositionVec().distanceTo(target) > 64) {
                    setPosition(target.x, target.y, target.z);
                }
            }
        }
    }

    protected float getTargetYaw(Entity target) {
        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getPosZ() - this.getPosZ();
        return (float)(MathHelper.atan2(d1, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
    }

    public void setOwner(PlayerEntity owner) {
        this.owner = owner.getUniqueID();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("owner")) {
            owner = compound.getUniqueId("owner");
            getDataManager().set(CHILD, compound.getBoolean("child"));
            getDataManager().set(FOOD_POINT, compound.getByte("food"));
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putUniqueId("owner", owner);
        compound.putByte("food", getDataManager().get(FOOD_POINT));
        compound.putBoolean("child", getDataManager().get(CHILD));
        compound.putInt("id", getEntityId());
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

    class MoveHelperController extends MovementController {
        public MoveHelperController(NeubulaekoSlimeEntity nse) {
            super(nse);
        }

        @Override
        public void tick() {
            Vector3d vector3d = new Vector3d(this.posX - NeubulaekoSlimeEntity.this.getPosX(), this.posY - NeubulaekoSlimeEntity.this.getPosY(), this.posZ - NeubulaekoSlimeEntity.this.getPosZ());
            double d0 = vector3d.length();
            if (this.action == MovementController.Action.MOVE_TO) {
                if (NeubulaekoSlimeEntity.this.getPosX() < posX + 0.5 && NeubulaekoSlimeEntity.this.getPosX() > posX - 0.5
                && NeubulaekoSlimeEntity.this.getPosY() < posX + 0.5 && NeubulaekoSlimeEntity.this.getPosY() > posX - 0.5) {
                    action = Action.WAIT;
                }
                else {
                    NeubulaekoSlimeEntity.this.setMotion(NeubulaekoSlimeEntity.this.getMotion().add(vector3d.scale(this.speed * 0.05D / d0)).mul(1, 0, 1));
                }

                if (NeubulaekoSlimeEntity.this.getPosY() < posY + 0.5) {
                    NeubulaekoSlimeEntity.this.setMotion(
                            NeubulaekoSlimeEntity.this.getMotion().add(0, 0.5, 0)
                    );
                }
                else if (NeubulaekoSlimeEntity.this.getPosY() > posY + 1.5){
                    NeubulaekoSlimeEntity.this.setMotion(
                            NeubulaekoSlimeEntity.this.getMotion().subtract(0, 0.5, 0)
                    );
                }
            }
        }
    }
}
