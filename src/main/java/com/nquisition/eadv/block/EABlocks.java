package com.nquisition.eadv.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public final class EABlocks
{
	public static Block ores;
	
	public static final void preInit()
	{
		GameRegistry.registerBlock(ores = new BlockEAOre(), ItemBlockEAOre.class, "Ore");
	}
}
