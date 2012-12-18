package net.lazlecraft.LazleCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class LazleCore extends JavaPlugin {
	
	
	@Override
	
	public void onEnable() 
	
	{
	    //gen config
	    getConfig().options().copyDefaults(true);
	    this.saveDefaultConfig();
	 
	    int servers = getConfig().getInt("server");
	 
	    if(servers == 1) 
	    {
	        getCommand("lazlecraft").setExecutor(new lcmd(this));
	        getCommand("join").setExecutor(new join(this));
	    } 
	    else if(servers == 2) 
	    {
	        getCommand("lazlecraft").setExecutor(new lcsb(this));
	    } 
	    else if(servers == 3)
	    {
	        getCommand("lazlecraft").setExecutor(new lcfb(this));
	    }
	    else
	    {
	        getCommand("lazlecraft").setExecutor(new lcpvp(this));
	    }
	 
	 
	    PluginDescriptionFile plugin = getDescription();
	    //Let's add a useless line.
	    System.out.println(plugin.getName() + " version " + plugin.getVersion() + " by LaxWasHere enabled.");
	}

    @Override
    public void onDisable() {
        PluginDescriptionFile plugin = getDescription();
        System.out.println(plugin.getName() + " version " + plugin.getVersion() + " by LaxWasHere disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
        	//because he's a naughty console.
            sender.sendMessage("Go Away, Console!");
            return false;
        }
        Player player = (Player) sender;
        if (commandLabel.equalsIgnoreCase("LaxWasHere") || commandLabel.equalsIgnoreCase("lax")) {
        	player.sendMessage(ChatColor.GREEN + "Lax was never here.");
        }
        return false;
    }
}