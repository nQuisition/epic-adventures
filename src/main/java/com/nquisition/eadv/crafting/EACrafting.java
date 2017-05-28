package com.nquisition.eadv.crafting;

import com.nquisition.eadv.item.EAIngot;
import com.nquisition.eadv.item.EAItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EACrafting
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(EAItems.cinderitePickaxe), new Object[] {"###", " S ", " S ", '#', new ItemStack(EAItems.ingots, 1, EAIngot.CINDERITE.ordinal()), 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(EAItems.auritePickaxe), new Object[] {"###", " S ", " S ", '#', new ItemStack(EAItems.ingots, 1, EAIngot.AURITE.ordinal()), 'S', Items.stick});
	}
}
