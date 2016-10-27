package com.allek.mc.SpecialSkills;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LeatherArmorCommand implements CommandExecutor
{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3)
	{
		if (sender instanceof Player && (sender.hasPermission("specialskills.gift") || sender.isOp()))
		{
			((Player)sender).getInventory().addItem(getLoredChestplate());
		}
		else if (!(sender instanceof Player))
		{
			sender.sendMessage(ChatColor.DARK_RED + "Command is not available from console!");
		}
		else
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission for this command!");
		return true;
	}

	public ItemStack getLoredChestplate()
	{
		ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta meta = armor.getItemMeta();
		List<String> lores = new ArrayList<String>();
		lores.add(ChatColor.translateAlternateColorCodes('&', Main.CHESTPLATE_LORE));
		meta.setLore(lores);
		armor.setItemMeta(meta);
		return armor;
	}
}
