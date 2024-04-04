package com.example.demo1.view;

import com.example.demo1.controller.GameController;
import com.example.demo1.model.boss.Boss;
import com.example.demo1.model.Game;
import com.example.demo1.model.MiniBoss;
import com.example.demo1.model.Plane;
import com.example.demo1.view.components.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.util.Random;

public class GameScene {
	private Game game;
	private GameController gameController;
	private Information information;
	private MediaPlayer mediaPlayer;
	private Pane parent;

	public GameScene(){
		game = new Game();
		gameController = new GameController(game);
	}

	private void initMedia(){
		Media media = new Media(getClass().getResource("/com/example/demo1/MP3/Trap.mp3").toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(-1);
		mediaPlayer.setVolume(0.9);
		mediaPlayer.play();
	}

	private void initTimeLines(){
		Timeline miniBossGenerator = new Timeline(new KeyFrame(Duration.seconds(8),
				actionEvent -> MiniBoss.generateGroup(200 + (new Random()).nextInt((int) (parent.getHeight() - 400)), parent, game))
		);
		miniBossGenerator.setCycleCount(-1);
		miniBossGenerator.play();

		Timeline updater = new Timeline(new KeyFrame(Duration.millis(100),
				actionEvent -> information.updateInformation())
		);
		updater.setCycleCount(-1);
		updater.play();

		Timeline bossAttack = new Timeline(new KeyFrame(Duration.seconds(1),
				actionEvent -> {
					if(game.getBoss() != null)
						game.getBoss().fire();
				})
		);
		bossAttack.setCycleCount(-1);
		bossAttack.play();
	}

	private void init(){
		initMedia();
		initTimeLines();
		information = new Information(parent, game);
	}

	public Scene getScene() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/GameScreen.fxml"));
		parent = fxmlLoader.load();

		game.setParent(parent);
		Plane plane = game.getCupHead();

		PlaneComponent component = new PlaneComponent(parent, plane);
		parent.getChildren().add(component);

		Boss boss = game.getBoss();
		BossComponent bossComponent = new BossComponent(parent, boss);
		parent.getChildren().add(bossComponent);

		parent.getChildren().get(0).requestFocus();
		init();
		return new Scene(parent);
	}
}
