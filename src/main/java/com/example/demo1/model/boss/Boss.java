package com.example.demo1.model.boss;

import com.example.demo1.model.Damageable;
import com.example.demo1.model.Egg;
import com.example.demo1.model.Game;
import com.example.demo1.model.Motion;
import com.example.demo1.model.ammo.Ammo;
import com.example.demo1.model.ammo.Bomb;
import com.example.demo1.model.ammo.Bullet;
import com.example.demo1.view.components.AmmoComponent;
import com.example.demo1.view.components.BossComponent;
import com.example.demo1.view.components.Component;
import com.example.demo1.view.components.EggComponent;
import lombok.Getter;
import lombok.Setter;

public abstract class Boss implements Damageable, Motion {
	@Getter
	protected int health;
	protected Game game;
	@Setter
	protected BossComponent component;

	public Boss(Game game){
		this.game = game;
		game.getDamageable().add(this);
	}

	public void dealDamage(int damage){
		health -= damage;
	}

	public boolean isDead(){
		return health <= 0;
	}

	public abstract void fire();


	@Override
	public abstract void remove();

	@Override
	public abstract Component getComponent();
	@Override
	public abstract void move();

	public abstract int getHeight();
	public abstract int getWidth();
}
