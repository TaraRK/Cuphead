package com.example.demo1.fxmlControllers;

import com.example.demo1.Main;
import com.example.demo1.model.Database;
import com.example.demo1.model.User;

public class DeleteAccountController {

    public void no()
    {
        Main.changeMenu("Profile");
    }

    public void yes()
    {
        User user = Database.getPlayer();
        Main.database.removeUser(user);
        Main.database.setPlayer(null);
        Main.changeMenu("Main");
    }

}
