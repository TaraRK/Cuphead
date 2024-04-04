package com.example.demo1.view.components;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public abstract class Component extends Rectangle {

	public Component(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	public abstract Pane getPane();
}
