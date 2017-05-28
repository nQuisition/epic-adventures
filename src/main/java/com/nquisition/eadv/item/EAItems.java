package com.nquisition.eadv.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class EAItems
{
	public static Item ingots;
	public static Item cinderitePickaxe;
	public static Item auritePickaxe;
	
	public static final void preInit()
	{
		GameRegistry.registerItem(ingots = new ItemEAIngot(), "Ingot");
		
		GameRegistry.registerItem(cinderitePickaxe = new ItemEAPickaxe(EAMaterial.CINDERITE), "cinderite_pickaxe");
		GameRegistry.registerItem(auritePickaxe = new ItemEAPickaxe(EAMaterial.AURITE), "aurite_pickaxe");
	}
}
