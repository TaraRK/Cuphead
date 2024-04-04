package com.example.demo1.model.boss;

import com.example.demo1.model.Egg;
import com.example.demo1.model.Game;
import com.example.demo1.transitions.DeathAnimation;
import com.example.demo1.view.components.BossComponent;
import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.EggComponent;
import javafx.scene.media.AudioClip;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class BossOne extends Boss {
	private static int maxHealth = 100;

	private int dy = +1;
	public BossOne(Game game){
		super(game);
		health = maxHealth;
	}

	public void dealDamage(int damage){
		health -= damage;
		game.changeScore(2 * damage);
	}

	public boolean isDead(){
		return health <= 0;
	}

	public void fire(){
		Egg egg = new Egg(game);

		new EggComponent(component.getPane(), egg);
	}


	@Override
	public void remove() {
		game.getDamageable().remove(this);
		death();
	}

	public void death(){
		component.getPane().getChildren().remove(component);
	}


	@Override
	public Component getComponent() {
		return component;
	}

	@Override
	public void move(){
		component.setY(component.getY() + dy);
		if(component.getY() <= 0)
			dy = 1;
		if(component.getY() >= component.getPane().getHeight() - component.getHeight())
			dy = -1;
	}

	@Override
	public int getHeight() {
		return 325;
	}

	@Override
	public int getWidth() {
		return 300;
	}
}
