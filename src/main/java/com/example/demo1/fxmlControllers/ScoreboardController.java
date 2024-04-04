package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ScoreboardController {
    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Label Third;
    public void back(MouseEvent mouseEvent)
    {
        Main.changeMenu("Main");
    }

    public void text()
    {
        first.setText(Main.database.getUsers().get(0).getUsername());
        second.setText(Main.database.getUsers().get(1).getUsername());
        Third.setText(Main.database.getUsers().get(2).getUsername());



    }

}
