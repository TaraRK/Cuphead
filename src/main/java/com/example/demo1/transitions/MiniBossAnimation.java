package com.example.demo1.transitions;

import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.MiniBossComponent;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Vector;

public class MiniBossAnimation extends Transition {
	private static Vector<ImagePattern> frames;
	private static int framesCount = 16;
	private MiniBossComponent component;
	static {
		frames = new Vector<>();
		for(int i = 1; i <= framesCount; i++)
			frames.add(new ImagePattern(new Image(PlaneAnimation.class.getResource("/com/example/demo1/PNG/bird/bird_" + i + ".png").toExternalForm())));
	}
	public MiniBossAnimation(MiniBossComponent component){
		this.component = component;
		setCycleDuration(Duration.seconds(4));
		setCycleCount(-1);
	}

	@Override
	protected void interpolate(double v) {
		int index = (int) Math.floor(v * framesCount);
		index = Math.min(framesCount - 1, index);
		component.setFill(frames.get(index));
		component.getMiniBoss().move();
	}
}
