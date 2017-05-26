package com.nquisition.eadv;

import com.nquisition.eadv.entity.EAEntities;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class EAProxyCommon {

    public void preInit(FMLPreInitializationEvent e) {
    	EAEntities.preInit();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}