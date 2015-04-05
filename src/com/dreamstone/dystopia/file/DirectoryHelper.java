package com.dreamstone.dystopia.file;

public class DirectoryHelper {

	private static final String SEPARATOR = System.getProperty("file.separator");
	
	public static final String RESOURCES_PATH = "resources" + SEPARATOR;
	public static final String IMAGES_PATH = RESOURCES_PATH + "images" + SEPARATOR;
	public static final String CHARACTER_PATH = IMAGES_PATH + "character" + SEPARATOR;
}
