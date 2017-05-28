package com.nquisition.eadv.item;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public enum EAMaterial
{
	CINDERITE (3, 1999, 10.0F, 5.0F, 10),
	AURITE(4, 1999, 15.0F, 7.0F, 14);
	
	public static final int num = values().length;
	
	public final int harvestLevel;
	public final int durability;
	public final float minigSpeed;
	public final float damage;
	public final int enchantability;
	public final ToolMaterial material;
	
	private EAMaterial(int harvestLevel, int durability, float miningSpeed, float damage, int enchantability)
	{
		this.harvestLevel = harvestLevel;
		this.durability = durability;
		this.minigSpeed = miningSpeed;
		this.damage = damage;
		this.enchantability = enchantability;
		material = EnumHelper.addToolMaterial(this.toString(), this.harvestLevel, this.durability,
				this.minigSpeed, this.damage, this.enchantability);
	}
	
	public String getName()
	{
		return this.toString().toLowerCase();
	}
	
	public static String getName(int n)
	{
		if(n < 0 || n >= num)
			return "";
		return values()[n].getName();
	}
}
