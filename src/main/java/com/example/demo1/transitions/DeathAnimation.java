package com.example.demo1.transitions;

import com.example.demo1.model.MiniBoss;
import com.example.demo1.view.components.MiniBossComponent;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Vector;

public class DeathAnimation extends Transition {

	private static Vector<ImagePattern> frames;
	private static int framesCount = 11;
	private MiniBossComponent component;
	static {
		frames = new Vector<>();
		for(int i = 1; i <= framesCount; i++)
			frames.add(new ImagePattern(new Image(PlaneAnimation.class.getResource("/com/example/demo1/PNG/bird/death/" + i + ".png").toExternalForm())));
	}
	public DeathAnimation(MiniBossComponent component){
		this.component = component;
		setCycleDuration(Duration.millis(500));
		setCycleCount(1);
	}

	@Override
	protected void interpolate(double v) {
		int index = (int) Math.floor(v * framesCount);
		index = Math.min(framesCount - 1, index);
		component.setFill(frames.get(index));
		component.getMiniBoss().move();
	}
}
