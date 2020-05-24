package com.blogspot.tragacafe.motd;

import org.bukkit.plugin.java.JavaPlugin;

import com.blogspot.tragacafe.motd.command.CommandMotd;
import com.blogspot.tragacafe.motd.file.Motds;
import com.blogspot.tragacafe.motd.listener.PingListener;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		Motds.setup();
		
		getServer().getPluginManager().registerEvents(new PingListener(Motds.getMotds()), this);
		getCommand("motd").setExecutor(new CommandMotd());

	}
	
	@Override
	public void onDisable() {
	}
	
}
