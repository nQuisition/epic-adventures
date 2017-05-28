package com.nquisition.eadv.worldgen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class EAWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId)
		{
		case -1:
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			break;
		}
	}
	
	private void generateOverworld(World w, Random rand, int cx, int cz)
	{
		int chance = 20;
		if(rand.nextInt(chance*chance) % chance != 0)
			return;
		
		int x = cx*16 + rand.nextInt(10);
		int z = cz*16 + rand.nextInt(10);
		BiomeGenBase biome = w.getBiomeGenForCoords(x, z);
		if(biome == BiomeGenBase.river || biome == BiomeGenBase.ocean || biome == BiomeGenBase.deepOcean ||
			biome == BiomeGenBase.frozenRiver || biome == BiomeGenBase.frozenOcean || biome == BiomeGenBase.beach)
			return;
		int y = getTop(w,x,z);
		generateStructure(w, rand, x, y, z, rand.nextInt(4));
	}
	
	private int getTop(World w, int x, int z)
	{
		int max = w.getHeight();
		for(int y = max; y > 0; y--)
			if(w.getBlock(x, y, z) != Blocks.air)
				return y;
		return 0;
	}
	
	private void generateStructure(World w, Random rand, int x, int y, int z, int orientation)
	{
		Block wall = Blocks.stonebrick;
		Block floor = Blocks.redstone_block;
		Block ceiling = Blocks.planks;

		int height = 10;
		
		for(int i = -2; i < 3; i++)
			for(int j = -2; j < 3; j++)
				w.setBlock(x-i, y, z-j, floor, 0, 2);
		
		for(int k = 1; k <= height; k++)
		{
			w.setBlock(x-2, y+k, z-2, wall, 0, 2);
			w.setBlock(x-1, y+k, z-2, wall, 0, 2);
			if(k>2)
				w.setBlock(x, y+k, z-2, wall, 0, 2);
			w.setBlock(x+1, y+k, z-2, wall, 0, 2);
			w.setBlock(x+2, y+k, z-2, wall, 0, 2);
			w.setBlock(x-2, y+k, z+2, wall, 0, 2);
			w.setBlock(x-1, y+k, z+2, wall, 0, 2);
			w.setBlock(x, y+k, z+2, wall, 0, 2);
			w.setBlock(x+1, y+k, z+2, wall, 0, 2);
			w.setBlock(x+2, y+k, z+2, wall, 0, 2);
			w.setBlock(x-2, y+k, z-1, wall, 0, 2);
			w.setBlock(x-2, y+k, z, wall, 0, 2);
			w.setBlock(x-2, y+k, z+1, wall, 0, 2);
			w.setBlock(x+2, y+k, z-1, wall, 0, 2);
			w.setBlock(x+2, y+k, z, wall, 0, 2);
			w.setBlock(x+2, y+k, z+1, wall, 0, 2);
			for(int i = -1; i < 2; i++)
				for(int j = -1; j < 2; j++)
					w.setBlock(x-i, y + k, z-j, Blocks.air, 0, 2);
		}
		int plank = rand.nextInt(6);
		for(int i = -1; i < 2; i++)
			for(int j = -1; j < 2; j++)
				w.setBlock(x-i, y + height, z-j, ceiling, plank, 2);
	}
}
