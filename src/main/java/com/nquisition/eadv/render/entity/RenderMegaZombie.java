package com.nquisition.eadv.render.entity;

import org.lwjgl.opengl.GL11;

import com.nquisition.eadv.entity.monster.EntityMegaZombie;

import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderMegaZombie extends RenderZombie {
	
	private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
	
	public RenderMegaZombie()
    {
        this.shadowSize *= 2.0F;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityMegaZombie p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(2.0F, 2.0F, 2.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMegaZombie p_110775_1_)
    {
        return zombieTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityZombie p_110775_1_)
    {
        return this.getEntityTexture((EntityMegaZombie)p_110775_1_);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityMegaZombie)p_77041_1_, p_77041_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityMegaZombie)p_110775_1_);
    }
}
