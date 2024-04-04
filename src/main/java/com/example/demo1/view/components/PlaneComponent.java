package com.example.demo1.view.components;

import com.example.demo1.controller.KeyEventHandler;
import com.example.demo1.model.Plane;
import com.example.demo1.transitions.PlaneAnimation;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import lombok.Getter;

@Getter
public class PlaneComponent extends Component {
	public void blink() {
		FadeTransition transition = new FadeTransition(Duration.millis(333), this);
		transition.setFromValue(0.1);
		transition.setToValue(1.0);
		transition.setCycleCount(5);
		transition.setAutoReverse(true);
		transition.setOnFinished(actionEvent -> {
			plane.setInvincible(false);
		});
		transition.play();
	}

	private Pane pane;
	private Plane plane;
	public PlaneComponent(Pane parent, Plane plane){
		super(0, (parent.getPrefHeight() - 98) / 2, 114, 98);
		setFill(new ImagePattern(new Image(getClass().getResource("/com/example/demo1/PNG/plane/1.png").toExternalForm())));
		this.pane = parent;
		this.plane = plane;

		setOnKeyPressed(keyEvent -> {
			String keyName = keyEvent.getCode().getName();
			KeyEventHandler.pressKey(keyName);
		});
		setOnKeyReleased(keyEvent -> {
			String keyName = keyEvent.getCode().getName();
			KeyEventHandler.releaseKey(keyName);
			if(keyName.equals("Tab")) {
				plane.switchGunType();
			}
		});
		(new PlaneAnimation(this)).play();
		plane.setComponent(this);
	}
}
