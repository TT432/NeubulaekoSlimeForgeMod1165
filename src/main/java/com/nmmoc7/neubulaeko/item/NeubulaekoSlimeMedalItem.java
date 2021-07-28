package com.nmmoc7.neubulaeko.item;

import com.nmmoc7.neubulaeko.NeubulaekoSlime;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.support.curios.CuriosCapProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;

/**
 * @author DustW
 */
public class NeubulaekoSlimeMedalItem extends Item {
    public NeubulaekoSlimeMedalItem() {
        super(new Properties().group(ItemGroup.TOOLS).maxStackSize(1));
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        if (NeubulaekoSlime.curiosLoaded) {
            return new CuriosCapProvider(stack);
        }
        return super.initCapabilities(stack, nbt);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            ItemStack itemstack = playerIn.getHeldItem(handIn);
            if (itemstack.getOrCreateTag().getBoolean("open")) {
                remove(itemstack, worldIn);
            }
            else {
                try {
                    add(playerIn, itemstack, worldIn);
                }
                catch (IllegalStateException e) {
                    remove(itemstack, worldIn);
                }
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public static void add(PlayerEntity playerIn, ItemStack itemstack, World worldIn) {
        NeubulaekoSlimeEntity entity = new NeubulaekoSlimeEntity(worldIn);
        entity.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
        entity.setOwner(playerIn);

        if (itemstack.getOrCreateTag().contains("addInfo")) {
            entity.readAdditional(itemstack.getOrCreateTag().getCompound("addInfo"));
            ((CompoundNBT) itemstack.getOrCreateTag().get("addInfo")).putInt("id", entity.getEntityId());
        } else {
            CompoundNBT nbt = new CompoundNBT();
            entity.writeAdditional(nbt);
            itemstack.getOrCreateTag().put("addInfo", nbt);
        }

        worldIn.addEntity(entity);

        itemstack.getOrCreateTag().putBoolean("open", true);
    }

    public static void remove(ItemStack itemstack, World worldIn) {
        if (itemstack.getOrCreateTag().contains("addInfo")) {
            int id = ((CompoundNBT) itemstack.getOrCreateTag().get("addInfo")).getInt("id");

            if (worldIn.getEntityByID(id) instanceof NeubulaekoSlimeEntity) {
                NeubulaekoSlimeEntity slime = (NeubulaekoSlimeEntity) worldIn.getEntityByID(id);
                if (slime != null) {
                    slime.remove();
                    CompoundNBT nbt = new CompoundNBT();
                    slime.writeAdditional(nbt);
                    itemstack.getOrCreateTag().put("addInfo", nbt);
                }
            }
            itemstack.getOrCreateTag().putBoolean("open", false);
        }
    }
}
