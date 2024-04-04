package com.example.demo1.transitions;

import com.example.demo1.model.Blast;
import com.example.demo1.model.Plane;
import com.example.demo1.model.Trash;
import javafx.animation.Transition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TrashAnimation extends Transition {
	private final Trash trash;
	public TrashAnimation(Trash trash){
		this.trash = trash;
		setCycleDuration(Duration.seconds(1));
		setCycleCount(-1);
	}
	@Override
	protected void interpolate(double v) {
		trash.move();

		Rotate rotate = new Rotate();
		rotate.setAngle(360 * v);
		rotate.setPivotX(trash.getComponent().getX() + trash.getComponent().getWidth() / 2);
		rotate.setPivotY(trash.getComponent().getY() + trash.getComponent().getHeight() / 2);

		trash.getComponent().getTransforms().clear();
		trash.getComponent().getTransforms().add(rotate);

		Plane plane = trash.getGame().getCupHead();
		if(plane.getComponent().intersects(trash.getComponent().getLayoutBounds())){
			if(plane.getHit())
				plane.getComponent().blink();
			stop();
			trash.remove();
		}
	}
}
