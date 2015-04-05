package com.dreamstone.dystopia.file;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSystem {

	private static final String GAME_NAME = "Slick2D_Test";
	private static final String OS = System.getProperty("os.name").toLowerCase();
	private static final String s = System.getProperty("file.separator");
	private static File gameFolder;
	
	public static boolean createGameDirectory() throws FileNotFoundException {
		if (OS.contains("win")) {
			String env = System.getenv("APPDATA");
			gameFolder = getFolder(env, GAME_NAME);
		}
		else if (OS.contains("mac")) {
			String support = System.getProperty("user.home") + s + "Library" + s + "Application Support";
			gameFolder = getFolder(support, GAME_NAME);
		}
		else if (OS.contains("nux")) {
			String config = System.getProperty("user.home");
			gameFolder = getFolder(config, "." + GAME_NAME);
		}
		else {
			String dir = System.getProperty("user.dir");
			gameFolder = getFolder(dir, GAME_NAME);
		}
		return gameFolder.exists();
	}
	
	public static File getFolder(String parent, String folderName) throws FileNotFoundException {
		return getFolder(new File(parent), folderName);
	}
	
	public static File getFolder(File parent, String folderName) throws FileNotFoundException {
		File folder = new File(parent.getAbsolutePath(), folderName);
		if (!folder.exists() && !folder.mkdirs()) {
			boolean dirsMade = createGameDirectory();
			if (!dirsMade) throw new FileNotFoundException("Game directories cannot be made: send this report to DystopiaBugs@dreamstone.com");
		}
		return folder;
	}
	
	public static File getGameFolder() {
		return gameFolder;
	}
}
