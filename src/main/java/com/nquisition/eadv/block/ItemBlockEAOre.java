package com.nquisition.eadv.block;

import static com.nquisition.eadv.EpicAdventures.MODID;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockEAOre extends ItemBlock
{
	public ItemBlockEAOre(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public String getItemStackDisplayName(ItemStack item)
	{
		return getUnlocalizedName(item);
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return "tile." + MODID + ".ore." + EAOre.getName(item.getItemDamage()) + ".name";
	}

	@Override
	public int getMetadata(int i)
	{
		return i;
	}

	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.values()[EAOre.fromMeta(stack.getItemDamage()).rarity];
	}
}
