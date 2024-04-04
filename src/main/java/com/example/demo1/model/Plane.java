package com.example.demo1.model;

import com.example.demo1.controller.KeyEventHandler;
import com.example.demo1.model.ammo.Ammo;
import com.example.demo1.model.ammo.Bomb;
import com.example.demo1.model.ammo.Bullet;
import com.example.demo1.model.boss.Boss;
import com.example.demo1.view.components.AmmoComponent;
import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.MiniBossComponent;
import com.example.demo1.view.components.PlaneComponent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Plane implements Motion {
	public static final double speed = 4;
	public static final int FiringCoolDown = 200;

	private int health = 10;
	private boolean invincible = false;
	private boolean coolDown = false;
	private GunStatus gunStatus;
	private PlaneComponent component;
	private Game game;
	public Plane(Game game){
		gunStatus = GunStatus.BULLET;
		this.game = game;
	}

	public boolean getHit(){
		if(invincible) return false;
		health --;
		invincible = true;
		return true;
	}

	public boolean isDead(){
		return health <= 0;
	}

	private void keepIn(){
		component.setX(Math.max(0, Math.min(component.getX(), component.getPane().getWidth() - component.getWidth())));
		component.setY(Math.max(35, Math.min(component.getY(), component.getPane().getHeight() - component.getHeight())));
	}

	public void movePlane(int dx, int dy){
		component.setX(component.getX() + dx * Plane.speed);
		component.setY(component.getY() + dy * Plane.speed);
	}

	public void switchGunType() {
		if(gunStatus == GunStatus.BOMB)
			gunStatus = GunStatus.BULLET;
		else
			gunStatus = GunStatus.BOMB;
	}

	public boolean isOnBullet(){
		return gunStatus == GunStatus.BULLET;
	}

	public void fire(){
		if(coolDown) return ;

		coolDown = true;

		Timeline coolDownHandler = new Timeline(
				new KeyFrame(Duration.millis(Plane.FiringCoolDown), actionEvent -> coolDown = false)
		);
		coolDownHandler.setCycleCount(1);
		coolDownHandler.play();

		Ammo ammo;
		if(isOnBullet())
			ammo = new Bullet(game);
		else
			ammo = new Bomb(game);
		new AmmoComponent(component.getPane(), ammo);
	}

	@Override
	public void move() {
		movePlane(KeyEventHandler.getStatus("D", "Right") - KeyEventHandler.getStatus("A", "Left"),
				KeyEventHandler.getStatus("S", "Down") - KeyEventHandler.getStatus("W", "Up"));
		keepIn();
	}

	public void killMiniBosses() {
		for (Damageable damageable : game.getDamageable()) {
			if(damageable instanceof Boss){
				if(component.intersects(damageable.getComponent().getLayoutBounds()))
					if(getHit())
						component.blink();
				continue;
			}
			MiniBoss miniBoss = (MiniBoss) damageable;
			if(component.intersects(miniBoss.getComponent().getLayoutBounds())){
				miniBoss.dealDamage(miniBoss.getHealth());
				if(getHit())
					component.blink();
				if(miniBoss.isDead()){
					miniBoss.remove();
					break;
				}
			}
		}
	}
}
enum GunStatus {
	BULLET, BOMB;
}
