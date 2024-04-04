package com.example.demo1.model;

import com.example.demo1.model.ammo.Ammo;
import com.example.demo1.view.components.EggComponent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.transform.Rotate;
import lombok.Getter;
import lombok.Setter;

public class Egg implements Motion {
	public static ImagePattern image = new ImagePattern(new Image(Egg.class.getResource("/com/example/demo1/PNG/game/egg.png").toExternalForm()));
	public static double speed = 6;

	@Getter
	private Game game;
	@Getter @Setter
	private EggComponent component;
	public Egg(Game game) {
		this.game = game;
	}


	public int getImageWidth() {
		return 60;
	}

	public int getImageHeight() {
		return 50;
	}

	public ImagePattern getImage() {
		return Egg.image;
	}

	public void remove(){
		component.getPane().getChildren().remove(component);
	}

	@Override
	public void move() {
		component.setX(component.getX() - speed);
	}

	public int getDamage() {
		return 1;
	}
}
