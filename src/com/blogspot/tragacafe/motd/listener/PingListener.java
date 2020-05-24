package com.blogspot.tragacafe.motd.listener;

import java.util.List;
import java.util.Random;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

	private static Random random = new Random();
	
	private List<String> motds;
	
	public PingListener(List<String> motds) {
		this.motds = motds;
	}
	
	@EventHandler
	public void onPingEvent(ServerListPingEvent pingEvent) {
		
		if (motds.size() > 0) {
			pingEvent.setMotd(motds.get(random.nextInt(motds.size())));
		}
		
	}
	
}
