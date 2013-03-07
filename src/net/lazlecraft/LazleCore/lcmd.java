package net.lazlecraft.LazleCore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

//CE for LazleCraft - LazleGames
public class lcmd implements CommandExecutor {
	
	private LazleCore plugin;
	
	public lcmd(LazleCore plugin)
	{
		this.plugin = plugin;
	}

	 @Override
	    public boolean onCommand(final CommandSender se, Command cmd, String label, String[] args) {
	        if (se instanceof Player) {
	            final Player p = ((Player) se).getPlayer();
	            IconMenu menu = new IconMenu("§aLazleGames" + se.getDisplayName , 27, new IconMenu.OptionClickEventHandler() {
	 
	                @Override
	                public void onOptionClick(IconMenu.OptionClickEvent event) {
	                    String name = ChatColor.stripColor(event.getName());
	                    if (name.equalsIgnoreCase("Website")) {
	                    	p.sendMessage("§6=============================================");
	                    	p.sendMessage("§aVisit us at http://LazleCraft.net");
	                    	p.sendMessage("§6=============================================");
	                    } else if (name.equalsIgnoreCase("Donate")) {
                                p.sendMessage("§7=============================================");
                                p.sendMessage("§aPlease click the link below to donate");
                                p.sendMessage("§6§lClick --> http://Store.LazleCraft.net");
                                p.sendMessage("§7==============================================");
                            } else if (name.equalsIgnoreCase("Staff")) {
                                p.sendMessage("§7==============================================");
                                p.sendMessage("§aOwner - Lazle");
                                p.sendMessage("§aAdmin - LaxWasHere");
                                p.sendMessage("§bMod - xPickleHead15x");
                                p.sendMessage("§bMod - Colby97");
                                p.sendMessage("§bMod - LisaatjeN");
                                p.sendMessage("§7=============================================");
                            } else if (name.equalsIgnoreCase("SG Stats")) {
                                p.sendMessage("§7=============================================");
                            	p.sendMessage("§6Click the link below to checck your Survival Games stats");  
                                p.sendMessage("§blaxwashere.net/sg/?user=" + se.getName());
                                p.sendMessage("§7=============================================");
                            } else if (name.equalsIgnoreCase("Reconnect")) {
                            	p.performCommand("lazlegames");
                            } else if (name.equalsIgnoreCase("Logout")) {
                            	p.kickPlayer("You have been logged out");
                            } else {
                            	p.sendMessage("You have to choose one");
                            
                            	
	                    
                           
	                    }
	                }
	            }, plugin);
	            menu.setOption(2, new ItemStack(Material.EMERALD, 1), "§a§lWebsite", "§6Tells you the LazleCraft website");
	            menu.setOption(3, new ItemStack(Material.GOLD_INGOT, 1), "§6§lDonate", "§aSupport LazleCraft!");
	            menu.setOption(4, new ItemStack(Material.NETHER_STAR, 1), "§a§lStaff", "§dList all the LazleCraft staff");
	            menu.setOption(5, new ItemStack(Material.RAILS, 1), "§a§lSG Stats", "§dGet a link to your SG stats");
	            menu.setOption(25, new ItemStack(Material.TRAP_DOOR, 1), "§b§lReconnect", "§6Log out and Log back in.");
	            menu.setOption(26, new ItemStack(Material.BEDROCK, 1), "§7§lLogout", "§6Logs you out of the server.");
	            menu.open(p);
	            return true;
	        }
	        return false;
	    }
	}