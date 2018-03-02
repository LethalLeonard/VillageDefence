package com.lethalleonard.villagedefence.Items;

import com.lethalleonard.villagedefence.Reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TimeWand extends Item
{
    public TimeWand()
    {
        super();
        this.setCreativeTab(CreativeTabs.MISC);
        this.setUnlocalizedName("timewand");
        this.setRegistryName("timewand");
    }

    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        return super.setUnlocalizedName(Reference.MODID + ":" + unlocalizedName);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        playerIn.sendMessage(new TextComponentString("Time: " + worldIn.getWorldTime()));

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
