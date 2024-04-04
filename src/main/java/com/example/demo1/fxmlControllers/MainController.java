package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import com.example.demo1.model.Database;
import com.example.demo1.view.GameScene;
import com.example.demo1.view.GameScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    private Database database = Main.database;


    public void moveToLogin()
    {
        Main.changeMenu("loginPage");
    }

    public void moveToSignUp()
    {
        Main.changeMenu("SignupPage");
    }
    public void moveToScoreboard()
    {
        Main.changeMenu("Scoreboard");
    }

    public void Play() throws Exception {
    //    GameScreen gameScreen = new GameScreen();
    //    Stage stage = new Stage();
    //    gameScreen.start(stage);
        GameScene gameScene = new GameScene();
        Scene scene = gameScene.getScene();
    //    Main.scene = scene;
        Main.stage.setScene(scene);
        Main.mediaPlayer.setCycleCount(0);
        Main.mediaPlayer.setVolume(0);
        Main.stage.show();

    }


}
