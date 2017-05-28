package com.nquisition.eadv.item;

import static com.nquisition.eadv.EpicAdventures.MODID;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemEAIngot extends Item
{
	public IIcon[] icons;
	
	public ItemEAIngot()
	{
		super();
		
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(MODID + ".ingot");
		icons = new IIcon[EAIngot.num];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
	    for (int i = 0; i < EAIngot.num; i++)
	    {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
	    return this.getUnlocalizedName() + "." + EAIngot.getName(stack.getItemDamage());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		for (int i = 0; i < EAIngot.num; i++)
		{
			this.icons[i] = ir.registerIcon(MODID + ":ingot/ingot_" + EAIngot.getName(i));
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if(meta > EAIngot.num)
			meta = 0;
		
		return this.icons[meta];
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.values()[EAIngot.fromMeta(stack.getItemDamage()).rarity];
	}
}
