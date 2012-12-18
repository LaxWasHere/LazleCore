package net.lazlecraft.LazleCore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class server implements CommandExecutor {
	
	private LazleCore plugin;
	
	public server(LazleCore plugin)
	{
		this.plugin = plugin;
	}
	 @Override
	    public boolean onCommand(final CommandSender se, Command cmd, String label, String[] args) {
	        if (se instanceof Player) {
	            Player p = ((Player) se).getPlayer();
	            IconMenu menu = new IconMenu("§a§lChoose a server.", 9, new IconMenu.OptionClickEventHandler() {
	                @Override
	                public void onOptionClick(IconMenu.OptionClickEvent event) {
	                    String name = ChatColor.stripColor(event.getName());
	                    if (name.equalsIgnoreCase("Hub")) {
	                    	//redir hub
	                    } else if (name.equalsIgnoreCase("LazleGames")) {
	                    	//redir lgames
                      } else if (name.equalsIgnoreCase("Skyblock")) {
                          //redir Skyblock
                      } else if (name.equalsIgnoreCase("Freebuild")) {
                    	  // redir freebuild
                      } else if (name.equalsIgnoreCase("PVP")){
                    	  //redir pvp
                     
	                    }
	                }
	            }, plugin);
	            menu.setOption(2, new ItemStack(Material.NETHER_STAR, 1), "§a§lHub", "§6Sends you the the Hub server.");
	            menu.setOption(3, new ItemStack(Material.CARROT_STICK, 1), "§6§lLazleGames", "§aSends you to the LazleGames server.");
	            menu.setOption(4, new ItemStack(Material.CHEST, 1), "§b§lSkyblock", "§dSend you to the SkyBlock server.");
	            menu.setOption(5, new ItemStack(Material.BEACON, 1), "§b§lFreebuild", "§dSend you to the Freebuild server.");
	            menu.setOption(6, new ItemStack(Material.DIAMOND_SWORD, 1), "§b§lPVP", "§dSends you to the pvp server.");
	            menu.open(p);
	            return true;
	        }
	        return false;
	    }
	}