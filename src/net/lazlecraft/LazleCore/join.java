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
	            IconMenu menu = new IconMenu("§aJoin a game", 27, new IconMenu.OptionClickEventHandler() {
	 
	                @Override
	                public void onOptionClick(IconMenu.OptionClickEvent event) {
	                    String name = ChatColor.stripColor(event.getName());
	                    if (name.equalsIgnoreCase("Survival Games")) {
	                    	((Player) se).performCommand("sg join");
	                    } else if (name.equalsIgnoreCase("TF2")) {
	                    ((Player) se).performCommand("tf2 join");
	                } else if (name.equalsIgnoreCase("Spleef")) {
	                	((Player) se).performCommand("spl join");
	                }
	                }
	            }, plugin);
	            menu.setOption(3, new ItemStack(Material.EMERALD, 1), "§a§lSurvival Games", "§6Join the Survival Games!");
	            menu.setOption(4, new ItemStack(Material.GOLD_INGOT, 1), "§a§lTF2", "§6Join Team Fortress 2!");
	            menu.setOption(5, new ItemStack(Material.NETHER_STAR, 1), "§a§lSpleef", "§6Join Spleef!");
	            menu.open(p);
	            return true;
	        }
	        return false;
	    }
	}