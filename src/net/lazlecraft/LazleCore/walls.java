package net.lazlecraft.LazleCore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

//walls GUI
public class walls implements CommandExecutor {
	
	private LazleCore plugin;
	
	public walls(LazleCore plugin)
	{
		this.plugin = plugin;
	}
	 @Override
	    public boolean onCommand(final CommandSender se, Command cmd, String label, String[] args) {
	        if (se instanceof Player) {
	            final Player p = ((Player) se).getPlayer();
	            IconMenu menu = new IconMenu("§a§lChoose a walls server.", 9, new IconMenu.OptionClickEventHandler() {
	                @Override
	                public void onOptionClick(IconMenu.OptionClickEvent event) {
	                    String name = ChatColor.stripColor(event.getName());
	                    //use player.performCommand to utilized LazleCloud
	                    if (name.equalsIgnoreCase("Server 1")) {
	                    	p.performCommand("walls1");
	                    } else if (name.equalsIgnoreCase("Server 2")) {
	                    	p.performCommand("walls2");
                      } else if (name.equalsIgnoreCase("Server 3")) {
                          p.performCommand("walls3");
                      } else if (name.equalsIgnoreCase("Server 4")) {
                    	  p.performCommand("walls4");
                     
	                    }
	                }
	            }, plugin);
	            menu.setOption(2, new ItemStack(Material.WOOD_SWORD, 1), "§a§lServer 1", "§65 players per team");
	            menu.setOption(3, new ItemStack(Material.GOLD_SWORD, 2), "§a§lServer 2", "§64 players per team");
	            menu.setOption(4, new ItemStack(Material.IRON_SWORD, 3), "§a§lServer 3", "§63 players per team");
	            menu.setOption(5, new ItemStack(Material.DIAMOND_SWORD, 4), "§a§lServer 4", "§62 players per team");
	            menu.open(p);
	            return true;
	        }
	        return false;
	    }
	}