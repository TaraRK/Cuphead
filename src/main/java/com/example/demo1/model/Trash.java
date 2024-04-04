package com.example.demo1.model;

import com.example.demo1.view.components.BlastComponent;
import com.example.demo1.view.components.TrashComponent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import lombok.Getter;
import lombok.Setter;

public class Trash implements Motion {
	public static ImagePattern image = new ImagePattern(new Image(Egg.class.getResource("/com/example/demo1/PNG/game/trash.png").toExternalForm()));
	public static double speed = 6;
	public static double g = 0.04f;
	@Getter
	private Game game;
	private double dy;
	private double dx;
	@Getter @Setter
	private TrashComponent component;
	public Trash(Game game) {
		this.game = game;
		this.dx = -0.6;
		this.dy = -2.4;
	}


	public int getImageWidth() {
		return 60;
	}

	public int getImageHeight() {
		return 40;
	}

	public ImagePattern getImage() {
		return Trash.image;
	}

	public void remove(){
		component.getPane().getChildren().remove(component);
	}

	@Override
	public void move() {
		if(component.getY() > 1000)
			return;

		component.setY(component.getY() + dy * speed);
		component.setX(component.getX() + dx * speed);

		dy += g;

	}

	public int getDamage() {
		return 1;
	}
}
