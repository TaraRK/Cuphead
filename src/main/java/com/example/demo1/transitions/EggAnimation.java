package com.example.demo1.transitions;

import com.example.demo1.model.Egg;
import com.example.demo1.model.Plane;
import com.example.demo1.model.ammo.Ammo;
import javafx.animation.Transition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class EggAnimation extends Transition {
	private final Egg egg;
	public EggAnimation(Egg egg){
		this.egg = egg;
		setCycleDuration(Duration.seconds(1));
		setCycleCount(-1);
	}
	@Override
	protected void interpolate(double v) {
		egg.move();

		Rotate rotate = new Rotate();
		rotate.setAngle(360 * v);
		rotate.setPivotX(egg.getComponent().getX() + egg.getComponent().getWidth() / 2);
		rotate.setPivotY(egg.getComponent().getY() + egg.getComponent().getHeight() / 2);

		egg.getComponent().getTransforms().clear();
		egg.getComponent().getTransforms().add(rotate);

		Plane plane = egg.getGame().getCupHead();
		if(plane.getComponent().intersects(egg.getComponent().getLayoutBounds())){
			if(plane.getHit())
				plane.getComponent().blink();
			stop();
			egg.remove();
		}
	}
}
