package com.example.demo1.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class BackgroundController {
	public Region content;
	public void initialize() {
		DoubleProperty xPosition = new SimpleDoubleProperty(0);
		xPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(content, xPosition.get()));
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(xPosition, 0)),
				new KeyFrame(Duration.seconds(200), new KeyValue(xPosition, -15000))
		);
		timeline.play();
	}
	void setBackgroundPositions(Region region, double xPosition) {
		String style = "-fx-background-position: " +
				"left " + xPosition/6 + "px bottom," +
				"left " + xPosition/3 + "px bottom," +
				"left " + xPosition + "px top;";
		region.setStyle(style);
	}
}
