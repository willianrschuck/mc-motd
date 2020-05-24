package com.blogspot.tragacafe.motd.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.bukkit.Bukkit;

public class Motds {

	private static File motdFile;
	private static List<String> motds;
	
	public static void setup() {
	
		motdFile = new File(Bukkit.getServer().getPluginManager().getPlugin("Motd").getDataFolder(), "motds.txt");
		motds = new ArrayList<String>();
		
		if (!motdFile.exists()) {
			try {
				motdFile.getParentFile().mkdir();
				motdFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		loadMotds();	
		
	}
	
	public static void loadMotds() {
		
		motds.clear();
		try {
			
			Scanner motdScanner = new Scanner(motdFile);
			
			while (motdScanner.hasNextLine()) {
				motds.add(motdScanner.nextLine().replace('&', '\u00A7').replace("\\n", "\n"));
			}
			
			motdScanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot read the motd file.");
		}
		
	}
	
	public static void setMotd(String motd) {
		
		motds.clear();
		motds.add(motd.replace('&', '\u00A7').replace("\\n", "\n"));
		
	}
	
	public static List<String> getMotds() {
		return Collections.unmodifiableList(motds);
	}
	
}
