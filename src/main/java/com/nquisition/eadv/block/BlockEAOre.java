package com.nquisition.eadv.block;

import static com.nquisition.eadv.EpicAdventures.MODID;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockEAOre extends Block
{
	public BlockEAOre()
	{
		super(Material.rock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(MODID + ".ore");
		this.setStepSound(soundTypeStone);
		
		this.setHarvestLevel("pickaxe", 2);
		for(int i = 0; i < EAOre.num; i++)
			this.setHarvestLevel("pickaxe", EAOre.values()[i].miningLevel, i);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
	    for (int i = 0; i < EAOre.num; i++)
	    {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{

		return EAOre.fromMeta(world.getBlockMetadata(x, y, z)).light;
	}
	
	@Override
	public int damageDropped(int i)
	{
		return i;
	}

	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return EAOre.fromMeta(metadata).getBlockTexture();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{

		for (int i = 0; i < EAOre.num; i++)
		{
			EAOre.values()[i].setBlockTexture(ir.registerIcon(MODID + ":ore/ore_" + EAOre.getName(i)));
		}
	}
}
