package com.example.demo1.transitions;

import com.example.demo1.model.Blast;
import com.example.demo1.model.Egg;
import com.example.demo1.model.Plane;
import javafx.animation.Transition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class BlastAnimation extends Transition {
	private final Blast blast;
	public BlastAnimation(Blast blast){
		this.blast = blast;
		setCycleDuration(Duration.seconds(1));
		setCycleCount(-1);
	}
	@Override
	protected void interpolate(double v) {
		blast.move();

		Plane plane = blast.getGame().getCupHead();
		if(plane.getComponent().intersects(blast.getComponent().getLayoutBounds())){
			if(plane.getHit())
				plane.getComponent().blink();
			stop();
			blast.remove();
		}
	}
}
