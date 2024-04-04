package com.example.demo1.model.ammo;

import com.example.demo1.model.Game;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bomb extends Ammo {
	public static ImagePattern image = new ImagePattern(new Image(Bullet.class.getResource("/com/example/demo1/PNG/game/bomb.png").toExternalForm()));
	public static double speed = 6;

	public Bomb(Game game) {
		super(game);
	}

	@Override
	public int getImageWidth() {
		return 53;
	}

	@Override
	public int getImageHeight() {
		return 38;
	}

	@Override
	public ImagePattern getImage() {
		return Bomb.image;
	}

	@Override
	public double getRenderPositionX() {
		return 0.5;
	}

	@Override
	public double getRenderPositionY() {
		return 0.5;
	}

	@Override
	public void move() {
		component.setY(component.getY() + speed);
	}

	@Override
	public int getDamage() {
		return 2;
	}
}
