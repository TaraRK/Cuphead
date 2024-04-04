package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import com.example.demo1.model.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SignupPageController {
    private static Database database = Main.database;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label passwordWarning;
    @FXML
    private Button SignUpButton;
    @FXML
    private Label usernameWarning;
    @FXML
    private ImageView back;
    public void signUp()
    {
        database.addUser(username.getText(), password.getText());
        Main.changeMenu("loginPage");
        // sign up successful
    }

    public void assess(KeyEvent keyEvent)
    {
        if (database.userWithSameUsernameExists(username.getText()))
        {
            username.setStyle("-fx-border-color: #C10B51FF;");
            usernameWarning.setVisible(true);
            SignUpButton.setDisable(true);
        }
        else
        {
            username.setStyle("-fx-border-width: 0");
            usernameWarning.setVisible(false);
            SignUpButton.setDisable(false);
        }
        int length = password.getLength();
        if ( length < 7)
        {
            password.setStyle("-fx-border-color: #C10B51FF;");
            passwordWarning.setVisible(true);
            SignUpButton.setDisable(true);
        }
        else
        {
            password.setStyle("-fx-border-width: 0");
            SignUpButton.setDisable(false);
            passwordWarning.setVisible(false);
        }

    }

    public void back(MouseEvent mouseEvent)
    {
        Main.changeMenu("Main");
    }

}
