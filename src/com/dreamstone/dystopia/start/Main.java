package com.dreamstone.dystopia.start;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.dreamstone.dystopia.input.Movement;
import com.dreamstone.dystopia.load.ImageLoader;
import com.dreamstone.dystopia.player.Player;


public class Main extends BasicGame {
	
	private Player player;
	
	public Main(String gamename) {
		super(gamename);
	}

	public static void main(String[] args) {
		try {
			AppGameContainer game = new AppGameContainer(new Main("Slick2D Test Game!"));
			game.setMaximumLogicUpdateInterval(60);			
			game.setDisplayMode(640, 480, false);
			game.setAlwaysRender(true);
			game.setVSync(false);
			game.setShowFPS(true);
			game.start();
		}
		catch (SlickException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		ImageLoader.loadImages();
		player = new Player("Derpsie");
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Movement.movePlayer(container, delta, player);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setBackground(new Color(0xAAAAFF));
		
		if (!player.isIdle()) {
			player.getCurrentState().getCurrentFrame().setFilter(Image.FILTER_NEAREST);
			player.getCurrentState().getCurrentFrame().draw(player.getPosition().x, player.getPosition().y, 4f);
		}
		else {
			player.getIdleImage().setFilter(Image.FILTER_NEAREST);
			player.getIdleImage().draw(player.getPosition().x, player.getPosition().y, 4f);
		}
		g.drawString(player.getName(), player.getPosition().x, player.getPosition().y + 20);
		
//		g.drawString("HELLO WORLD!!", (gc.getWidth() - 100) / 2, gc.getHeight() / 2);
	}
}