package net.lazlecraft.LazleCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LazleCore extends JavaPlugin implements Listener {
	
	public String prefix = "[LazleCore]";
	@Override
	
	public void onEnable() 
	
	{
	    //gen config
	    getConfig().options().copyDefaults(true);
	    this.saveDefaultConfig();
	    
	    // Register listeners
	    getServer().getPluginManager().registerEvents(this, this);
	    // Custom Recipes
	    
	    // Register BungeeCoord Channel
	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "RubberBand");
	    
	    int servers = getConfig().getInt("servers");
	    //Golbal CE
	    getCommand("servers").setExecutor(new server(this));
	 
	    if(servers == 1) 
	    {
	        getCommand("lazlecraft").setExecutor(new lcmd(this));
	        System.out.println(prefix + " Config Detected for LazleGames Server.");
	        System.out.println(prefix + " Using lcmd CommandExecutor");
	    } 
	    else if(servers == 2) 
	    {
	        getCommand("lazlecraft").setExecutor(new lcsb(this));
	        System.out.println(prefix + " Config Detected for Skyblock Server.");
	        System.out.println(prefix + " Using lcsb CommandExecutor");
	    } 
	    else if(servers == 3)
	    {
	        getCommand("lazlecraft").setExecutor(new lcfb(this));
	        System.out.println(prefix + " Config Detected for Freebuild Server.");
	        System.out.println(prefix + " Using lcfb CommandExecutor");
	    }
	    else if(servers == 4)
	    {
	        getCommand("lazlecraft").setExecutor(new lcpvp(this));
	        System.out.println(prefix + " Config Detected for PVP Server.");
	        System.out.println(prefix + " Using lcpvp CommandExecutor");
	    }
	    else
	    {
	    	System.out.println(prefix + " No servers defined in the config!");
	    	//Disabled atm System.out.println("Disabling plugin.");
	    	//Bukkit.getPluginManager().disablePlugin(this);
	    }
	 
	 
	}

    @Override
    public void onDisable() {
        System.out.println(prefix + "/lazlecraft commands is now disabled");
    }
    @EventHandler
    public void onPlayerjoin(PlayerJoinEvent event) {
    	Player p = event.getPlayer();
    	Bukkit.getServer().dispatchCommand(p.getServer().getConsoleSender(), "spawn " + p.getName());
    	//debug
    	System.out.println("Sent " + p.getName() + " to spawn.");
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