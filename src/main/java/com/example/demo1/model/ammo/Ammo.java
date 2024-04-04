package com.example.demo1.model.ammo;

import com.example.demo1.model.Damageable;
import com.example.demo1.model.Game;
import com.example.demo1.model.Motion;
import com.example.demo1.model.Plane;
import com.example.demo1.model.boss.Boss;
import com.example.demo1.transitions.DeathAnimation;
import com.example.demo1.transitions.DustAnimation;
import com.example.demo1.view.components.AmmoComponent;
import com.example.demo1.view.components.Component;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Ammo implements Motion {
	protected Game game;
	@Setter
	protected AmmoComponent component;

	public Ammo(Game game) {
		this.game = game;
		this.game.changeScore(-this.getDamage());
	}

	abstract public int getImageWidth();

	abstract public double getRenderPositionX();

	abstract public double getRenderPositionY();

	abstract public int getImageHeight();

	abstract public ImagePattern getImage();

	public abstract int getDamage();


	public void remove() {
		DustAnimation animation = new DustAnimation(component);
		animation.setOnFinished(actionEvent -> component.getPane().getChildren().remove(this.component));
		if (this instanceof Bomb){
			AudioClip audioClip = new AudioClip(getClass().getResource("/com/example/demo1/MP3/Bomb.mp3").toString());
			audioClip.play();
		}
		animation.play();
	}

	public boolean dealDamage() {
		for (Damageable damageable : game.getDamageable()) {
			assert component != null;
			assert damageable.getComponent() != null;
			if (component.intersects(damageable.getComponent().getLayoutBounds())) {
				damageable.dealDamage(getDamage());
				remove();
				if (damageable.isDead()) {
					if(damageable instanceof Boss)
						game.nextBoss();
					else
						damageable.remove();
				}
				return true;
			}
		}
		return false;
	}
}
