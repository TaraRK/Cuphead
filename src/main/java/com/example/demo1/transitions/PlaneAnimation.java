package com.example.demo1.transitions;

import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.PlaneComponent;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Vector;

public class PlaneAnimation extends Transition {
	private static Vector<ImagePattern> frames;
	private static int framesCount = 41;
	static {
		frames = new Vector<>();
		for(int i = 1; i <= framesCount; i++)
			frames.add(new ImagePattern(new Image(PlaneAnimation.class.getResource("/com/example/demo1/PNG/plane/" + i + ".png").toExternalForm())));
	}
	private PlaneComponent component;
	public PlaneAnimation(PlaneComponent component){
		this.component = component;
		setCycleDuration(Duration.seconds(4));
		setCycleCount(-1);
	}

	@Override
	protected void interpolate(double v) {
		int index = (int) Math.floor(v * framesCount);
		index = Math.min(framesCount - 1, index);
		component.setFill(frames.get(index));
		component.getPlane().move();
		component.getPlane().killMiniBosses();
	}
}
