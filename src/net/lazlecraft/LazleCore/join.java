package net.lazlecraft.LazleCore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class join implements CommandExecutor {
	
	private LazleCore plugin;
	
	public join(LazleCore plugin)
	{
		this.plugin = plugin;
	}
	 @Override
	    public boolean onCommand(final CommandSender se, Command cmd, String label, String[] args) {
	        if (se instanceof Player) {
	            Player p = ((Player) se).getPlayer();
	            IconMenu menu = new IconMenu("Menu", 27, new IconMenu.OptionClickEventHandler() {
	 
	                @Override
	                public void onOptionClick(IconMenu.OptionClickEvent event) {
	                    String name = ChatColor.stripColor(event.getName());
	                    if (name.equalsIgnoreCase("Survival Games")) {
	                    	((Player) se).performCommand("sg join");
	                    }
	                }
	            }, plugin);
	            menu.setOption(1, new ItemStack(Material.EMERALD, 1), "�a�lSurvival Games", "�aJoin the Survival Games!");
	            menu.setOption(2, new ItemStack(Material.GOLD_INGOT, 1), "�6�lTF2", "�aJoin Team Fortress 2!");
	            menu.setOption(3, new ItemStack(Material.NETHER_STAR, 1), "�6�lSpleef", "�aJoin Spleef!");
	            menu.open(p);
	            return true;
	        }
	        return false;
	    }
	}