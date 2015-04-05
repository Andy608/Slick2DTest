package com.dreamstone.dystopia.load;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.dreamstone.dystopia.file.DirectoryHelper;
import com.dreamstone.dystopia.util.TransformImage;

public class ImageLoader {

	public static Image[] playerIdle;
	public static Image playerWalkNorth[];
	public static Image playerWalkSouth[];
	public static Image playerWalkEast[];
	public static Image playerWalkWest[];
	
	public static void loadImages() throws IllegalArgumentException, SlickException {

		playerIdle = TransformImage.splitAnimationStrip(new Image(DirectoryHelper.CHARACTER_PATH + "player_idle.png"), 4);
		playerWalkNorth = TransformImage.splitAnimationStrip(new Image(DirectoryHelper.CHARACTER_PATH + "player_walk_north.png"), 4);
		playerWalkSouth = TransformImage.splitAnimationStrip(new Image(DirectoryHelper.CHARACTER_PATH + "player_walk_south.png"), 4);
		playerWalkEast = TransformImage.splitAnimationStrip(new Image(DirectoryHelper.CHARACTER_PATH + "player_walk_east.png"), 8);
		playerWalkWest = TransformImage.splitAnimationStrip(new Image(DirectoryHelper.CHARACTER_PATH + "player_walk_west.png"), 8);
	}
}
