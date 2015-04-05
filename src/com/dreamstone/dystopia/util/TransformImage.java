package com.dreamstone.dystopia.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TransformImage {

	public static Image[] splitAnimationStrip(Image animationStrip, int frames) throws IllegalArgumentException, SlickException {
		
		if (animationStrip.getWidth() % frames != 0) {
			Logger.getLogger(TransformImage.class.getName()).log(Level.SEVERE, "Animation Strip is not correct Width! :(");
			throw new IllegalArgumentException();
		}
		
		Image[] animation = new Image[frames];
		int width = animationStrip.getWidth() / frames;
		
		for (int i = 0; i < animation.length; i++) {
			animation[i] = new Image(width, animationStrip.getHeight());
			animation[i] = animationStrip.getSubImage(width * i, 0, width, animationStrip.getHeight());
		}
		return animation;
	}
}
