package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import com.example.demo1.model.Database;
import com.example.demo1.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginPageController {

    private static Database database = Main.database;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label warning;
    public void login(MouseEvent mouseEvent)
    {
        String u = username.getText();
        String p = password.getText();
        User user = database.getUser(u, p);
        if ( user != null )
        {
            database.setPlayer(user);
            Main.changeMenu("Profile");
            return;
            //login successfully
        }
        warning.setVisible(true);

    }
    public void back(MouseEvent mouseEvent)
    {
        Main.changeMenu("Main");
    }
}
