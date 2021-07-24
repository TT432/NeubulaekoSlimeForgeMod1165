package com.nmmoc7.neubulaeko.item;

import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeChildEntity;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * @author DustW
 */
public class ZZZZFood extends Item {
    public ZZZZFood() {
        super(new Properties().group(ItemGroup.FOOD));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            EntityRayTraceResult result = ProjectileHelper.rayTraceEntities(worldIn, playerIn,
                    playerIn.getPositionVec(),
                    playerIn.getLookVec().scale(2),
                    new AxisAlignedBB(
                            playerIn.getPosX() + 3,
                            playerIn.getPosY() + 3,
                            playerIn.getPosZ() + 3,
                            playerIn.getPosX() - 3,
                            playerIn.getPosY() - 3,
                            playerIn.getPosZ() - 3
                    ), entity -> entity instanceof NeubulaekoSlimeEntity || entity instanceof NeubulaekoSlimeChildEntity);
            if (result != null) {
                // todo 史莱姆食物状态
                playerIn.getHeldItem(handIn).shrink(1);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
