package com.nmmoc7.neubulaeko.item;

import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * @author DustW
 */
public class TestItem extends Item {
    public TestItem() {
        super(new Properties().group(ItemGroup.TOOLS).maxStackSize(1));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            NeubulaekoSlimeEntity entity = new NeubulaekoSlimeEntity(worldIn);
            entity.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
            entity.setOwner(playerIn);
            worldIn.addEntity(entity);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
