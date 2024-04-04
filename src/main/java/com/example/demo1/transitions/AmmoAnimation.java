package com.example.demo1.transitions;

import com.example.demo1.model.ammo.Ammo;
import javafx.animation.Transition;
import javafx.util.Duration;

public class AmmoAnimation extends Transition {
	private final Ammo ammo;
	public AmmoAnimation(Ammo ammo){
		this.ammo = ammo;
		setCycleDuration(Duration.seconds(1));
		setCycleCount(-1);
	}
	@Override
	protected void interpolate(double v) {
		ammo.move();
		if(ammo.dealDamage())
			stop();
	}
}
