package com.nquisition.eadv;

import com.nquisition.eadv.entity.monster.EntityMegaZombie;
import com.nquisition.eadv.render.entity.RenderMegaZombie;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class EAProxyClient extends EAProxyCommon {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		RenderingRegistry.registerEntityRenderingHandler(EntityMegaZombie.class, new RenderMegaZombie());
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}
