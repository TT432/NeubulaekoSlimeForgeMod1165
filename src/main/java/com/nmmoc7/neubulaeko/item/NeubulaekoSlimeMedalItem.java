package com.nmmoc7.neubulaeko.item;

import com.nmmoc7.neubulaeko.NeubulaekoSlime;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.support.curios.CuriosCapProvider;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * @author DustW
 */
public class NeubulaekoSlimeMedalItem extends Item {
    public NeubulaekoSlimeMedalItem() {
        super(new Properties().group(ItemGroup.TOOLS).maxStackSize(1));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(" "));
        tooltip.add(new StringTextComponent("手持土球会到你面前来"));
        tooltip.add(new StringTextComponent("右键还可以喂食"));
        tooltip.add(new StringTextComponent(" "));
        tooltip.add(new StringTextComponent("喂食进度: " + new StringTextComponent(getFoodState(stack) + " / 100").getString()));
        tooltip.add(new StringTextComponent(" "));
        tooltip.add(new StringTextComponent("主人: " + getOwnerName(stack, worldIn)));
        tooltip.add(new StringTextComponent("史莱姆UUID: " + getSlimeUUID(stack)));
        tooltip.add(new StringTextComponent(" "));
        tooltip.add(new StringTextComponent("模型来源： thousvillages"));
        tooltip.add(new StringTextComponent("贴图来源： Neubulaeko, MalayP"));
        tooltip.add(new StringTextComponent(" "));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public static int getFoodState(ItemStack stack) {
        return hasInfo(stack) ? Math.min(getInfo(stack).getInt("food"), 100) : 0;
    }

    public static boolean isOpen(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean("open");
    }

    public static boolean hasInfo(ItemStack stack) {
        return stack.getOrCreateTag().contains("addInfo");
    }

    public static CompoundNBT getInfo(ItemStack stack) {
        if (stack.getOrCreateTag().contains("addInfo")) {
            return stack.getOrCreateTag().getCompound("addInfo");
        }

        return new CompoundNBT();
    }

    public static UUID getOwner(ItemStack itemStack) {
        if (getInfo(itemStack).contains("owner")) {
            return getInfo(itemStack).getUniqueId("owner");
        }

        return null;
    }

    public static String getOwnerName(ItemStack itemStack, World world) {
        if (getOwner(itemStack) != null) {
            PlayerEntity player = world.getPlayerByUuid(getOwner(itemStack));

            if (player != null) {
                return player.getDisplayName().getString();
            }
            else {
                return "不在线";
            }
        }
        else {
            return "无";
        }
    }

    public static String getSlimeUUID(ItemStack stack) {
        return getInfo(stack).contains("id") ? getInfo(stack).getUniqueId("id").toString() : "未分配";
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
            if (isOpen(itemstack)) {
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
            playerIn.getCooldownTracker().setCooldown(playerIn.getHeldItem(handIn).getItem(), 20);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public static void add(PlayerEntity playerIn, ItemStack itemstack, World worldIn) {
        if (!worldIn.isRemote) {
            NeubulaekoSlimeEntity entity = new NeubulaekoSlimeEntity(worldIn);
            entity.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
            entity.setOwner(playerIn);

            if (hasInfo(itemstack)) {
                entity.readAdditional(getInfo(itemstack));
            } else {
                CompoundNBT nbt = new CompoundNBT();
                entity.writeAdditional(nbt);
                itemstack.getOrCreateTag().put("addInfo", nbt);
            }

            worldIn.addEntity(entity);

            itemstack.getOrCreateTag().putBoolean("open", true);
        }
    }

    public static void remove(ItemStack itemstack, World worldIn) {
        if (!worldIn.isRemote && itemstack.getOrCreateTag().contains("addInfo")) {
            UUID id = getInfo(itemstack).getUniqueId("id");
            Entity entity = ((ServerWorld) worldIn).getEntityByUuid(id);

            if (entity instanceof NeubulaekoSlimeEntity) {
                NeubulaekoSlimeEntity slime = (NeubulaekoSlimeEntity) entity;

                slime.remove();
                CompoundNBT nbt = new CompoundNBT();
                slime.writeAdditional(nbt);
                itemstack.getOrCreateTag().put("addInfo", nbt);
            }
            itemstack.getOrCreateTag().putBoolean("open", false);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (worldIn.getGameTime() % (20) == 0) {
            if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
                ServerWorld server = (ServerWorld) worldIn;

                if (hasInfo(stack)) {
                    UUID id = getInfo(stack).getUniqueId("id");
                    Entity entity = server.getEntityByUuid(id);

                    if (entity != null && isOpen(stack)) {
                        if (entity instanceof NeubulaekoSlimeEntity) {
                            ((NeubulaekoSlimeEntity) entity).writeAdditional(getInfo(stack));
                        }
                    }
                }
            }
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
