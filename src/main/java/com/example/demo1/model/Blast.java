package com.example.demo1.model;

import com.example.demo1.view.components.BlastComponent;
import com.example.demo1.view.components.EggComponent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import lombok.Getter;
import lombok.Setter;

public class Blast implements Motion {
	public static ImagePattern image = new ImagePattern(new Image(Egg.class.getResource("/com/example/demo1/PNG/game/blast.png").toExternalForm()));
	public static double speed = 6;

	@Getter
	private Game game;
	private double dx;
	private double dy;
	private int followingTurns = 80;
	@Getter @Setter
	private BlastComponent component;
	public Blast(Game game) {
		this.game = game;
	}

	private void followCupHead(){
		if(followingTurns == 0)
			return ;
		followingTurns --;
		double dx = game.getCupHead().getComponent().getX() - game.getBoss().getComponent().getX();
		double dy = game.getCupHead().getComponent().getY() - game.getBoss().getComponent().getY();
		double len = Math.sqrt(dx * dx + dy * dy);
		this.dx = dx / len;
		this.dy = dy / len;
	}

	public int getImageWidth() {
		return 60;
	}

	public int getImageHeight() {
		return 60;
	}

	public ImagePattern getImage() {
		return Blast.image;
	}

	public void remove(){
		component.getPane().getChildren().remove(component);
	}

	@Override
	public void move() {
		followCupHead();
		component.setX(component.getX() + dx * speed);
		component.setY(component.getY() + dy * speed);
	}

	public int getDamage() {
		return 1;
	}
}
