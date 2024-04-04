package com.example.demo1.view.components;

import com.example.demo1.model.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Information extends HBox {
	private static ImagePattern bullet = new ImagePattern(new Image(Information.class.getResource("/com/example/demo1/PNG/guntype/bullet.png").toExternalForm()));
	private static ImagePattern bomb = new ImagePattern(new Image(Information.class.getResource("/com/example/demo1/PNG/guntype/bomb.png").toExternalForm()));

	private final Pane pane;
	private final Game game;
	public Information(Pane pane, Game game){
		super(20);
		this.pane = pane;
		this.game = game;

		this.getChildren().add(new Rectangle(0, 0, 40, 40));

		Label label = new Label();
		label.setAlignment(Pos.BOTTOM_CENTER);
		this.getChildren().add(label);

		label = new Label();
		label.setAlignment(Pos.BOTTOM_CENTER);
		this.getChildren().add(label);

		label = new Label();
		this.getChildren().add(label);

		ProgressBar progressBar = new ProgressBar(1);
		this.getChildren().add(progressBar);
		pane.getChildren().add(this);

		label = new Label();
		this.getChildren().add(label);

		pane.getChildren().get(0).requestFocus();
		updateInformation();
	}

	public void updateInformation(){
		updateGunIcon();
		updatePlaneHealth();
		updateBossHP();
		updateScore();
		updateTimer();
	}

	private void updateTimer(){
		((Label) this.getChildren().get(5)).setText(String.format("%02d:%02d", game.getPassedSeconds() / 60, game.getPassedSeconds() % 60));
	}

	private void updatePlaneHealth() {
		((Label) this.getChildren().get(1)).setText(String.format("Cup Head HP %d / 10", game.getCupHead().getHealth()));
		if(game.getCupHead().getHealth() <= 3)
			this.getChildren().get(1).setStyle("-fx-text-fill: red;");
	}

	private void updateBossHP() {
		((Label) this.getChildren().get(2)).setText("Current Boss Hp : " + game.getBoss().getHealth() + " / 100");
		if(game.getCupHead().getHealth() <= 10)
			this.getChildren().get(2).setStyle("-fx-text-fill: green;");
		((ProgressBar) this.getChildren().get(4)).setProgress(game.getBoss().getHealth() / 100f);
		String Color = "red";
		if(game.getBoss().getHealth() <= 50)
			Color = "orange";
		if(game.getBoss().getHealth() <= 25)
			Color = "green";
		this.getChildren().get(4).setStyle("-fx-accent: " + Color + ";");
	}

	private void updateGunIcon(){
		((Rectangle) this.getChildren().get(0)).setFill(game.getCupHead().isOnBullet() ? bullet : bomb);
	}

	private void updateScore(){
		((Label) this.getChildren().get(3)).setText("Your Score : " + game.getScore());
	}
}
