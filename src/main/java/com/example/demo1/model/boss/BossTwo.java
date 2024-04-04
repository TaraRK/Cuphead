package com.example.demo1.model.boss;

import com.example.demo1.model.Blast;
import com.example.demo1.model.Egg;
import com.example.demo1.model.Game;
import com.example.demo1.view.components.BlastComponent;
import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.EggComponent;

import java.util.Random;

public class BossTwo extends Boss{
	private static int maxHealth = 100;

	private int dy = 0;
	private int dx = 0;
	private int remainTurns = 0;
	public BossTwo(Game game){
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
		Blast blast = new Blast(game);
		new BlastComponent(component.getPane(), blast);
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
		if(remainTurns == 0){
			remainTurns = 200;
			dx = (new Random()).nextInt(3) - 1;
			dy = (new Random()).nextInt(3) - 1;
		}
		remainTurns --;

		component.setY(component.getY() + dy);
		if(component.getY() <= 0)
			dy = 1;
		if(component.getY() >= component.getPane().getHeight() - component.getHeight())
			dy = -1;

		component.setX(component.getX() + dx);
		if(component.getX() <= 0)
			dx = 1;
		if(component.getX() >= component.getPane().getHeight() - component.getHeight())
			dx = -1;
	}

	@Override
	public int getHeight() {
		return 195;
	}

	@Override
	public int getWidth() {
		return 125;
	}
}
