package com.nquisition.eadv.crafting;

import com.nquisition.eadv.block.EABlocks;
import com.nquisition.eadv.item.EAIngot;
import com.nquisition.eadv.item.EAItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class EASmelting
{
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(EABlocks.ores, 1, 0), new ItemStack(EAItems.ingots, EAIngot.fromMeta(0).yield, 0), 1.0F);
		GameRegistry.addSmelting(new ItemStack(EABlocks.ores, 1, 1), new ItemStack(EAItems.ingots, EAIngot.fromMeta(1).yield, 1), 2.0F);
	}
}
