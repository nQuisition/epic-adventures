package com.nquisition.eadv.entity.monster;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityMegaZombie extends EntityZombie {
	
	private static final int BUFF_DELAY = 80;
	private int delay;
	private int explosionStrength;
	
    public EntityMegaZombie(World p_i1745_1_)
    {
        super(p_i1745_1_);
        delay = 0;
        explosionStrength = 1;
        this.setSize(-1.2F, -3.6F);
        this.setSize(1.2F, 3.6F);
        
        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, false));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.5D);
    }

    @Override
    public boolean isChild()
    {
        return false;
    }
    
    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
    {
        Object p_110161_1_1 = super.onSpawnWithEgg(p_110161_1_);
        
        this.func_146069_a(2.0F);

        return (IEntityLivingData)p_110161_1_1;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer p_70693_1_)
    {
        this.experienceValue = (int)((float)this.experienceValue * 5.0F);

        return super.getExperiencePoints(p_70693_1_);
    }

    @Override
    public void setChild(boolean p_82227_1_)
    {
        
    }

    @Override
    public boolean isVillager()
    {
        return false;
    }

    @Override
    public void setVillager(boolean p_82229_1_)
    {
    	
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	delay++;
    	if(delay >= BUFF_DELAY)
    	{
    		double d4 = 64.0D;

    		EntityLivingBase target = this.getAttackTarget();
            if (target != null && target.getDistanceSqToEntity(this) < d4 * d4 && this.canEntityBeSeen(target))
            {
                double d5 = target.posX - this.posX;
                double d6 = target.boundingBox.minY + (double)(target.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
                double d7 = target.posZ - this.posZ;
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
                entitylargefireball.field_92057_e = this.explosionStrength;
                double d8 = 3.0D;
                Vec3 vec3 = this.getLook(1.0F);
                entitylargefireball.posX = this.posX + vec3.xCoord * d8;
                entitylargefireball.posY = this.posY + (double)(this.height / 2.0F);
                entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
                this.worldObj.spawnEntityInWorld(entitylargefireball);
                this.explosionStrength++;
            }
            
            if(!this.worldObj.isRemote /*&& this.getAttackTarget() == null*/)
        	{
	    		List toBuff = this.worldObj.getEntitiesWithinAABB(EntityZombie.class, AxisAlignedBB.getBoundingBox(this.posX - 5.0D, this.posY - 5.0D, this.posZ - 5.0D, this.posX + 5.0D, this.posY + 5.0D, this.posZ + 5.0D));
	    		for(int i = 0; i < toBuff.size(); i++)
	    		{
	    			EntityZombie zombie = (EntityZombie)toBuff.get(i);
	    			zombie.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
	    			zombie.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_helmet));
	    			zombie.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_chestplate));
	    			zombie.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_leggings));
	    			zombie.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_boots));
	    		}
        	}
    		/*EntityZombie z = new EntityZombie(this.worldObj);
    		double temp_x = this.rand.nextDouble()*3.0D + 2.0D;
    		double temp_z = this.rand.nextDouble()*3.0D + 2.0D;
    		z.setLocationAndAngles(this.posX + temp_x, this.posY, this.posZ + temp_z, 0.0F, 0.0F);
    		this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX + temp_x, this.posY, this.posZ + temp_z));
    		this.worldObj.spawnEntityInWorld(z);*/
    		delay = 0;
    	}
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    protected Item getDropItem()
    {
        return Items.bed;
    }

    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Items.baked_potato, 1);
                break;
            case 1:
                this.dropItem(Items.diamond, 1);
                break;
            case 2:
                this.dropItem(Items.fireworks, 1);
        }
    }
    
    @Override
    public boolean interact(EntityPlayer p_70085_1_)
    {
        return false;
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public boolean isConverting()
    {
        return false;
    }
}
