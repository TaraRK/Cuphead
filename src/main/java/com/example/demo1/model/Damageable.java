package com.example.demo1.model;

import com.example.demo1.view.components.Component;

import java.util.ArrayList;

public interface Damageable {
	void dealDamage(int damage);
	boolean isDead();
	void remove();
	Component getComponent();
}
