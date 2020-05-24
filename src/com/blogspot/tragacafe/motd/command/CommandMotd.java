package com.blogspot.tragacafe.motd.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.blogspot.tragacafe.motd.file.Motds;

public class CommandMotd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
	
		List<String> argsList = Arrays.asList(args);
		
		if (argsList.isEmpty()) {
			sender.sendMessage("You must inform the operation /motd [set/load]");
			return true;
		}
			
		if (argsList.get(0).equals("set")) {
			
			List<String> motdArgs = argsList.subList(1, argsList.size());
			
			if (motdArgs.isEmpty()) {
				sender.sendMessage("You must inform the new motd /motd set [motd]");
				return true;
			}
			
			Motds.setMotd(String.join(" ", motdArgs));
			return true;
			
		}
		
		if (argsList.get(0).equals("load")) {
			
			Motds.loadMotds();
			return true;
			
		}
		
		sender.sendMessage("Syntax error. Use /motd [set/load]");
		return true;
		
	}

}
