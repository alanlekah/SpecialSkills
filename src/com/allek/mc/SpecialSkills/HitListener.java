package com.allek.mc.SpecialSkills;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HitListener implements Listener
{

	@EventHandler
	public void playerHitEvent(EntityDamageByEntityEvent e)
	{
		boolean dodgeContained = false;
		
		Entity damagedEntity = e.getEntity();
		if (!(damagedEntity instanceof Player))
			return;
		Player damagedPlayer = (Player) damagedEntity;
		
		ItemStack chestPlate = damagedPlayer.getInventory().getChestplate();
		if (chestPlate == null)
			return;
		if (!chestPlate.hasItemMeta())
			return;
		
		ItemMeta im = chestPlate.getItemMeta();
		for (String s : im.getLore())
		{
			if (s.contains(ChatColor.translateAlternateColorCodes('&', Main.CHESTPLATE_LORE)))
				dodgeContained = true;
		}
		
		if (!dodgeContained) { return; }
		
		int randVal = new Random().nextInt(10);
		
		// TO DEBUG PERCENTAGES:
		//damagedPlayer.sendMessage("Value: " + randVal + ", Percent: " + Main.DAMAGE_PERCENTAGE/10 + ", Damage: " + (Main.DAMAGE_PERCENTAGE/10 > randVal));
		
		if (Main.DAMAGE_PERCENTAGE/10 > randVal)
		{
			damagedPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.DODGE_MESSAGE));
			e.setCancelled(true);
		}
		
	}
}
