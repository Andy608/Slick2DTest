package com.dreamstone.dystopia.player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.dreamstone.dystopia.load.ImageLoader;

public class Player {

	//In the future this will be Enum and private
	public static Animation north, south, east, west, current;
	private Image idleState;
	private boolean isIdle;
	private Vector2f playerPosition;
	
	private static final int ANIMATION_DURATION = 200;
	private String playerName;
	
	public Player(String name) {
		playerName = name;
		initAnimations();
		playerPosition = new Vector2f();
	}
	
	private void initAnimations() {
		north = new Animation(ImageLoader.playerWalkNorth, ANIMATION_DURATION, false);
		south = new Animation(ImageLoader.playerWalkSouth, ANIMATION_DURATION, false);
		east = new Animation(ImageLoader.playerWalkEast, ANIMATION_DURATION / 2, false);
		west = new Animation(ImageLoader.playerWalkWest, ANIMATION_DURATION / 2, false);
		setCurrentState(south);
	}
	
	public void setCurrentState(Animation a) {
		current = a;
		if (a.equals(north)) idleState = ImageLoader.playerIdle[0];
		else if (a.equals(south)) idleState = ImageLoader.playerIdle[1];
		else if (a.equals(east))  idleState = ImageLoader.playerIdle[2];
		else idleState = ImageLoader.playerIdle[3];
	}
	
	public Image getIdleImage() {
		return idleState;
	}
	
	public Animation getCurrentState() {
		return current;
	}
	
	public boolean isIdle() {
		return isIdle;
	}
	
	public void setIsIdle(boolean idle) {
		isIdle = idle;
	}
	
	public Vector2f updatePosition(float addedX, float addedY) {
		Vector2f another = new Vector2f(addedX, addedY);
		return playerPosition.add(another);
	}
	
	public Vector2f getPosition() {
		return playerPosition;
	}
	
	public String getName() {
		return playerName;
	}
}
