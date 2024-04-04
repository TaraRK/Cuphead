module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires lombok;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;


    requires javafx.web;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.demo1.view to javafx.fxml;
    opens com.example.demo1.transitions to javafx.fxml;
    exports com.example.demo1.view;
    exports com.example.demo1.controller;
    exports com.example.demo1.fxmlControllers;
    opens com.example.demo1.fxmlControllers to javafx.fxml;
}