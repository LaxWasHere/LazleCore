package net.lazlecraft.LazleCore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class lcfb implements CommandExecutor {

	private LazleCore plugin;
	
	public lcfb(LazleCore plugin)
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
	                    if (name.equalsIgnoreCase("Website")) {
	                    	se.sendMessage("§aVisit us at http://LazleCraft.net");
	                    } else if (name.equalsIgnoreCase("Donate")) {
                                se.sendMessage("§7=============================================");
                                se.sendMessage("§aPlease click the link below to donate");
                                se.sendMessage("§6§lClick --> http://Store.LazleCraft.net");
                                se.sendMessage("§7=============================================");
                            } else if (name.equalsIgnoreCase("Staff")) {
                                se.sendMessage("§7=============================================");
                                se.sendMessage("§6Owner - Lazle");
                                se.sendMessage("§6Admin - LaxWasHere");
                                se.sendMessage("§bMod - LisaatjeN");
                                se.sendMessage("§7=============================================");
                           
	                    }
	                }
	            }, plugin);
	            menu.setOption(1, new ItemStack(Material.EMERALD, 1), "§a§lWebsite", "§6Tells you the LazleCraft website");
	            menu.setOption(2, new ItemStack(Material.GOLD_INGOT, 1), "§6§lDonate", "§aSupport LazleCraft!");
	            menu.setOption(3, new ItemStack(Material.NETHER_STAR, 1), "§b§lStaff", "§dList all the LazleCraft staff");
	            menu.open(p);
	            return true;
	        }
	        return false;
	    }
	}