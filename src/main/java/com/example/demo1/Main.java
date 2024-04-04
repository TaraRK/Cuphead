package com.example.demo1;

import com.example.demo1.model.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static Scene scene;
    public static Database database = new Database();
    public static MediaPlayer mediaPlayer;
    public static void main(String[] args) {
        launch();
    }
    public static Stage stage;
    @Override

    public void start(Stage stage) throws Exception {
        Parent root = loadFXML("Main");
        Scene scene = new Scene(root);
        Main.scene = scene;
        Media media = new Media(getClass().getResource("/com/example/demo1/MP3/SneakyFeet.mp3").toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setCycleCount(-1);
        mediaPlayer.setVolume(0.9);
        Main.mediaPlayer = mediaPlayer;
        Main.mediaPlayer.play();
        Main.stage = stage;
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    private static Parent loadFXML(String name){
        try {
            URL address = new URL(Main.class.getResource("/com/example/demo1/FXML/" + name + ".fxml").toString());
            return FXMLLoader.load(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void changeMenu( String Name)
    {
        Parent root = loadFXML(Name);
        Media media = new Media(Main.class.getResource("/com/example/demo1/MP3/SneakyFeet.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.setVolume(0.9);
        mediaPlayer.play();
        Main.scene.setRoot(root);

    }
}
