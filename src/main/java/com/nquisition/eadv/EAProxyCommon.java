package com.nquisition.eadv;

import com.nquisition.eadv.block.EABlocks;
import com.nquisition.eadv.crafting.EACrafting;
import com.nquisition.eadv.crafting.EASmelting;
import com.nquisition.eadv.entity.EAEntities;
import com.nquisition.eadv.item.EAItems;
import com.nquisition.eadv.worldgen.EAWorldGen;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class EAProxyCommon {

    public void preInit(FMLPreInitializationEvent e) {
    	EAEntities.preInit();
    	EABlocks.preInit();
    	EAItems.preInit();
    }

    public void init(FMLInitializationEvent e) {
    	GameRegistry.registerWorldGenerator(new EAWorldGen(), 10);
    	EASmelting.init();
    	EACrafting.init();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}