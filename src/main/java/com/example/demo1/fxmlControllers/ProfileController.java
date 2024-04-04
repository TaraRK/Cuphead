package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import com.example.demo1.model.Database;
import com.example.demo1.model.User;
import com.example.demo1.view.GameScene;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProfileController {

    private User user;
    @FXML
    private Label username;
    @FXML
    private ImageView avatar;
    @FXML
    private Label score;
    public ProfileController( )
    {
        this.user = Database.getPlayer();
    }

    public String username ()
    {
        return user.getUsername();
    }

    public void setText( )
    {
        username.setText(user.getUsername());
        score.setText( String.valueOf(user.getScore()));
        Image image = new Image( ProfileController.class.getResource("/com/example/demo1/FXML/cuphead" + user.getNumber() + ".jpg").toExternalForm());
        avatar.setImage(image);
    }


    public void back(MouseEvent mouseEvent)
    {
        Main.changeMenu("loginPage");
    }

    public void deleteAccount( MouseEvent mouseEvent)
    {
        Main.changeMenu("DeleteAccount");


    }

    public void edit( )
    {
        Main.changeMenu("EditInfo");

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
