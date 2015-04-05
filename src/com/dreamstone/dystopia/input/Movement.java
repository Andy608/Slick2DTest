package com.dreamstone.dystopia.input;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import com.dreamstone.dystopia.player.Player;

public class Movement {

	public static void movePlayer(GameContainer container, int delta, Player currentPlayer) {
		boolean isPressed = false;
		Input input = container.getInput();
		
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
			currentPlayer.setCurrentState(Player.north);
			currentPlayer.getCurrentState().update(delta);
			currentPlayer.updatePosition(0, (float)-(delta * 0.2f));
			isPressed = true;
		}
		else if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S)) {
			currentPlayer.setCurrentState(Player.south);
			currentPlayer.getCurrentState().update(delta);
			currentPlayer.updatePosition(0, (float)(delta * 0.2f));
			isPressed = true;
		}
		
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			currentPlayer.setCurrentState(Player.east);
			currentPlayer.getCurrentState().update(delta);
			currentPlayer.updatePosition((float)(delta * 0.2f), 0);
			isPressed = true;
		}
		else if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			currentPlayer.setCurrentState(Player.west);
			currentPlayer.getCurrentState().update(delta);
			currentPlayer.updatePosition((float)-(delta * 0.2f), 0);
			isPressed = true;
		}
		currentPlayer.setIsIdle(!isPressed);
	}
}
