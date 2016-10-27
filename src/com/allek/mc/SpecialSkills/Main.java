package com.allek.mc.SpecialSkills;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	private PluginManager pm;
	static int DAMAGE_PERCENTAGE;
	static String CHESTPLATE_LORE;
	static String DODGE_MESSAGE;
	
	@Override
	public void onEnable()
	{
		pm = this.getServer().getPluginManager();
		pm.registerEvents(new HitListener(), this);
		this.getCommand("specialskills").setExecutor(new LeatherArmorCommand());
		
		this.saveDefaultConfig();
		FileConfiguration config = getConfig();
		DAMAGE_PERCENTAGE = config.getInt("DODGE_PERCENTAGE");
		CHESTPLATE_LORE = config.getString("CHESTPLATE_LORE");
		DODGE_MESSAGE = config.getString("DODGE_MESSAGE");
	}
	
	
}
