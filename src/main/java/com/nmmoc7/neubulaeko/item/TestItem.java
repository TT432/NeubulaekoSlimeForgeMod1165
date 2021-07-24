package com.nmmoc7.neubulaeko.item;

import com.nmmoc7.neubulaeko.NeubulaekoSlime;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeChildEntity;
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
            NeubulaekoSlimeEntity entity = new NeubulaekoSlimeEntity(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), worldIn);
            entity.setShooter(playerIn);
            entity.shoot(0, 0, 0, 0, 0);
            worldIn.addEntity(entity);

            NeubulaekoSlimeChildEntity entity1 = new NeubulaekoSlimeChildEntity(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), worldIn);
            entity1.setShooter(playerIn);
            entity1.shoot(0, 0, 0, 0, 0);
            worldIn.addEntity(entity1);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
