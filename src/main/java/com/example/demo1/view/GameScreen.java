package com.example.demo1.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScreen extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		GameScene gameScene = new GameScene();
		Scene scene = gameScene.getScene();
		stage.setScene(scene);
		scene.getRoot().getChildrenUnmodifiable().get(0).requestFocus();
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
