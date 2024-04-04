package com.example.demo1.model.boss;

import com.example.demo1.model.Blast;
import com.example.demo1.model.Game;
import com.example.demo1.model.Trash;
import com.example.demo1.view.components.BlastComponent;
import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.TrashComponent;

import java.util.Random;

public class BossThree extends Boss {
	private static int maxHealth = 100;

	private int dx = +1;
	public BossThree(Game game){
		super(game);
		health = maxHealth;
	}

	public void dealDamage(int damage){
		health -= damage;
		game.changeScore(2 * damage);
		if(health <= 0)
			health = 1;
	}

	public boolean isDead(){
		return health <= 0;
	}

	public void fire(){
		Trash trash = new Trash(game);
		new TrashComponent(component.getPane(), trash);
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
		component.setX(component.getX() + dx);
		if(component.getX() <= 0)
			dx = 1;
		if(component.getX() >= component.getPane().getHeight() - component.getHeight())
			dx = -1;
	}

	@Override
	public int getHeight() {
		return 325;
	}

	@Override
	public int getWidth() {
		return 800;
	}
}
