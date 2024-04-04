package com.example.demo1.controller;

import com.example.demo1.model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameController {
	private Game game;
	public GameController(Game game){
		this.game = game;

		Timeline timeline = new Timeline(new KeyFrame(
				Duration.millis(100),
				actionEvent -> handleActions()
		));
		timeline.setCycleCount(-1);
		timeline.play();
	}

	private void handleActions(){
		if(KeyEventHandler.getStatus("Space") == 1){
			game.getCupHead().fire();
		}
	}
}
