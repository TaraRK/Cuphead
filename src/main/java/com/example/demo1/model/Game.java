package com.example.demo1.model;

import com.example.demo1.model.boss.Boss;
import com.example.demo1.model.boss.BossOne;
import com.example.demo1.model.boss.BossThree;
import com.example.demo1.model.boss.BossTwo;
import com.example.demo1.view.components.BossComponent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Game {
	@Setter
	private Pane parent;
	private Plane cupHead;
	private ArrayList<Damageable> damageable;
	private Boss boss;
	private int score = 50;
	private int passedSeconds;

	public Game(){
		cupHead = new Plane(this);
		damageable = new ArrayList<>();
		boss = new BossOne(this);

		passedSeconds = 0;
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
			passedSeconds ++;
			if(passedSeconds % 20 == 0)
				score --;
		}));
		timeline.setCycleCount(-1);
		timeline.play();
	}

	public void changeScore(int delta){
		score += delta;
	}

	public void nextBoss(){
		changeScore(+ 100);
		if(boss instanceof BossTwo){
			boss.remove();
			boss = new BossThree(this);
			BossComponent bossComponent = new BossComponent(parent, boss);
			parent.getChildren().add(bossComponent);
		}
		if(boss instanceof BossOne){
			boss.remove();
			boss = new BossTwo(this);
			BossComponent bossComponent = new BossComponent(parent, boss);
			parent.getChildren().add(bossComponent);
		}
	}
}
