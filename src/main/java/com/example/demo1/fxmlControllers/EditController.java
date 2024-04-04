package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import com.example.demo1.model.Database;
import com.example.demo1.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditController
{
    private User user;

    @FXML
    private Button save;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField number;

    @FXML
    private Label warning;

    public EditController()
    {
        this.user = Database.getPlayer();

    }

    public void save()
    {
        if ( username.getText() != null && password.getText()!= null && !username.getText().equals("") && !password.getText().equals("")
            && Integer.parseInt(number.getText()) > 0 && Integer.parseInt(number.getText()) < 7 )
        {
            if ( Main.database.userWithSameUsernameExists(username.getText()))
            {
                warning.setVisible(true);
            }
            else
            {
                user.setUsername(username.getText());
                user.setPassword(password.getText());
                user.setNumber(Integer.parseInt(number.getText()));
                Main.changeMenu("Profile");
            }
        }
    }

    public void back ()
    {
        Main.changeMenu("Profile");
    }
    public void deleteAccount()
    {
        Main.changeMenu("DeleteAccount");
    }
}
