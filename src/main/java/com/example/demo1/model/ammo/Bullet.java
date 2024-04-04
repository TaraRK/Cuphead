package com.example.demo1.model.ammo;

import com.example.demo1.model.Game;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;

public class Bullet extends Ammo {
	public static ImagePattern image = new ImagePattern(new Image(Bullet.class.getResource("/com/example/demo1/PNG/game/bullet.png").toExternalForm()));
	public static double speed = 6;

	public Bullet(Game game) {
		super(game);
		AudioClip audioClip = new AudioClip(getClass().getResource("/com/example/demo1/MP3/Bullet.mp3").toString());
		audioClip.play();
	}

	@Override
	public int getImageWidth() {
		return 32;
	}

	@Override
	public int getImageHeight() {
		return 9;
	}

	@Override
	public ImagePattern getImage() {
		return Bullet.image;
	}

	@Override
	public double getRenderPositionX() {
		return 1;
	}

	@Override
	public double getRenderPositionY() {
		return 0.5;
	}

	@Override
	public void move() {
		component.setX(component.getX() + speed);
	}

	@Override
	public int getDamage() {
		return 1;
	}
}
