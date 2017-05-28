package com.nquisition.eadv.item;

public enum EAIngot
{
	CINDERITE (2, 1),
	AURITE (3, 1);
	
	public static final int num = values().length;
	
	public final int rarity;
	public final int yield;
	
	private EAIngot(int rarity, int yield)
	{
		this.rarity = rarity;
		this.yield = yield;
	}
	
	public static String getName(int n)
	{
		if(n < 0 || n >= num)
			return "";
		return values()[n].toString().toLowerCase();
	}
	
	public static EAIngot fromMeta(int meta)
	{
		if(meta < 0 || meta >= num)
			return values()[0];
		return values()[meta];
	}
}
