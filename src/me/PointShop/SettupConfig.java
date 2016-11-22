package me.PointShop;

import org.bukkit.plugin.java.JavaPlugin;

public class SettupConfig {
	
	public void onEnable() {
		  saveDefaultConfig();
	}
	
	public void veriables() {
		
	}
	
	public void setConfig() {
		this.getConfig().set("name", ShopName());
		this.getConfig().set("item-1", i1());
		this.getConfig().set("item-2", i2());
		this.getConfig().set("item-3", i3());
		this.getConfig().set("item-4", i4());
		this.getConfig().set("item-5", i5());
		this.getConfig().set("item-6", i6());
		this.getConfig().set("item-7", i7());
		this.getConfig().set("item-8", i8());
		this.getConfig().set("item-9", i9());
		this.getConfig().set("item-10", i10());
		
		this.getConfig().set("item-11", i11());
		this.getConfig().set("item-12", i12());
		this.getConfig().set("item-13", i13());
		this.getConfig().set("item-14", i14());
		this.getConfig().set("item-15", i15());
		this.getConfig().set("item-16", i16());
		this.getConfig().set("item-17", i17());
		this.getConfig().set("item-18", i18());
		this.getConfig().set("item-19", i19());
		this.getConfig().set("item-20", i20());
	}

	private Object i1() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onDisable() {
		  saveDefaultConfig();
	}
	
	


}
