package net.lazlecraft.LazleCore;

import org.bukkit.Bukkit;
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
	    // BungeeCoord
	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "RubberBand");
	    
	    int servers = getConfig().getInt("server");
	    //Golbal CE
	    getCommand("server").setExecutor(new server(this));
	 
	    if(servers == 1) 
	    {
	        getCommand("lazlecraft").setExecutor(new lcmd(this));
	        getCommand("join").setExecutor(new join(this));
	        System.out.println("Config Detected for LazleGames Server.");
	        System.out.println("Using lcmd CommandExecutor");
	    } 
	    else if(servers == 2) 
	    {
	        getCommand("lazlecraft").setExecutor(new lcsb(this));
	        System.out.println("Config Detected for Skyblock Server.");
	        System.out.println("Using lcsb CommandExecutor");
	    } 
	    else if(servers == 3)
	    {
	        getCommand("lazlecraft").setExecutor(new lcfb(this));
	        System.out.println("Config Detected for Freebuild Server.");
	        System.out.println("Using lcfb CommandExecutor");
	    }
	    else if(servers == 4)
	    {
	        getCommand("lazlecraft").setExecutor(new lcpvp(this));
	        System.out.println("Config Detected for PVP Server.");
	        System.out.println("Using lcpvp CommandExecutor");
	    }
	    else
	    {
	    	System.out.println("No servers defined in the config");
	    	System.out.println("Disabling plugin.");
	    	Bukkit.getPluginManager().disablePlugin(this);
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