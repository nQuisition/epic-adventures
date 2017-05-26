package com.nquisition.eadv;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EpicAdventures.MODID, name = EpicAdventures.MODNAME, version = EpicAdventures.VERSION)
public class EpicAdventures {
	public static final String MODID = "epicadventures";
    public static final String MODNAME = "Epic Adventures";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide="com.nquisition.eadv.EAProxyClient", serverSide="com.nquisition.eadv.EAProxyServer")
    public static EAProxyCommon proxy;
    
    @Instance
    public static EpicAdventures instance = new EpicAdventures();
        
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
}
