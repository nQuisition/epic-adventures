package com.nquisition.eadv.item;

import static com.nquisition.eadv.EpicAdventures.MODID;

import com.nquisition.eadv.block.BlockEAOre;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEAPickaxe extends ItemPickaxe
{
	private EAMaterial mat;
	
	public ItemEAPickaxe(EAMaterial mat)
	{
		super(mat.material);
		this.mat = mat;
		this.setUnlocalizedName("pickaxe_" + mat.getName());
        this.setTextureName(MODID + ":tool/pickaxe_" + mat.getName());
	}
	
	public ItemEAPickaxe(String matName, ToolMaterial mat)
	{
		super(mat);
		this.mat = null;
		this.setUnlocalizedName(matName + "_pickaxe");
        this.setTextureName(MODID + ":tool/pickaxe_" + matName);
	}
	
	//TODO use onItemRightClick with raytracing instead?
	//TODO move melting stone to superclass
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(mat == null)
			return false;
		
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		if(mat == EAMaterial.CINDERITE)
		{
			if(block == Blocks.stone || block == Blocks.cobblestone || block == Blocks.stonebrick)
				world.setBlock(x, y, z, Blocks.flowing_lava);
			else if(block == Blocks.iron_ore)
				world.setBlock(x, y, z, Blocks.iron_block);
			else if(block == Blocks.gold_ore)
				world.setBlock(x, y, z, Blocks.gold_block);
			else if(block == Blocks.coal_ore)
			{
				world.createExplosion(null, x, y, z, 3.0F, true);
			}
			else
				return false;
		}
		else if(mat == EAMaterial.AURITE)
		{
			if(block == Blocks.diamond_ore)
				world.setBlock(x, y, z, Blocks.diamond_block);
			else if(block == Blocks.redstone_ore)
				world.setBlock(x, y, z, Blocks.redstone_block);
			else if(block == Blocks.lapis_ore)
				world.setBlock(x, y, z, Blocks.lapis_block);
			else
				return false;
		}
		else
			return false;
		
		world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
		stack.damageItem(100, player);
		
		return true;
	}
	
}
