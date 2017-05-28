package com.nquisition.eadv.block;

import net.minecraft.util.IIcon;

public enum EAOre
{
	CINDERITE (8, 2, 5, 8, 5, 30, 10, 3),
	AURITE (15, 3, 1, 1, 5, 20, 100, 3);
	
	public static final int num = values().length;
	
	public final int light;
	public final int rarity;
	public final int veinMin, veinMax;
	public final int minY, maxY;
	public final int frequency;
	public final int miningLevel;
	private IIcon blockTexture;
	
	private EAOre(int light, int rarity, int veinMin, int veinMax, int minY, int maxY, int freq, int mLevel)
	{
		this.light = light;
		this.rarity = rarity;
		this.veinMin = veinMin;
		this.veinMax = veinMax;
		this.minY = minY;
		this.maxY = maxY;
		this.miningLevel = mLevel;
		this.frequency = freq;
		setBlockTexture(null);
	}
	
	public static String getName(int n)
	{
		if(n < 0 || n >= num)
			return "";
		return values()[n].toString().toLowerCase();
	}
	
	public static EAOre fromMeta(int meta)
	{
		if(meta < 0 || meta >= num)
			return values()[0];
		return values()[meta];
	}

	public IIcon getBlockTexture()
	{
		return blockTexture;
	}

	public void setBlockTexture(IIcon blockTexture)
	{
		this.blockTexture = blockTexture;
	}
}
