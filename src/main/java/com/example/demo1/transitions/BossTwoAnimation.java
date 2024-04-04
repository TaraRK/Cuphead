package com.example.demo1.transitions;

import com.example.demo1.model.boss.Boss;
import com.example.demo1.view.components.BossComponent;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Vector;

public class BossTwoAnimation extends Transition {
	private static Vector<ImagePattern> frames;
	private static int framesCount = 16;
	static {
		frames = new Vector<>();
		for(int i = 1; i <= framesCount; i++)
			frames.add(new ImagePattern(new Image(BossAnimation.class.getResource("/com/example/demo1/PNG/boss/two/" + i + ".png").toExternalForm())));
	}

	private BossComponent component;
	public BossTwoAnimation(BossComponent component){
		this.component = component;
		setCycleDuration(Duration.seconds(1));
		setCycleCount(-1);
	}

	@Override
	protected void interpolate(double v) {
		int index = (int) Math.floor(v * framesCount);
		index = Math.min(framesCount - 1, index);
		component.setFill(frames.get(index));
		component.getBoss().move();
	}
}
