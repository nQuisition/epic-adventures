package com.nquisition.eadv.entity;

import com.nquisition.eadv.entity.monster.EntityMegaZombie;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public final class EAEntities {
	
	public static void preInit() {
		//Mobs
		EntityRegistry.registerGlobalEntityID(EntityMegaZombie.class, "MegaZombie", EntityRegistry.findGlobalUniqueEntityId(), 0x7AE8FF, 0x47FFE2);
	
		//Spawn
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++)
	    {
			if (BiomeGenBase.getBiomeGenArray()[i] != null)
	        {
				EntityRegistry.addSpawn(EntityMegaZombie.class, 130, 1, 3, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
	        }
	    }
	}
}
