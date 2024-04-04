package com.example.demo1.view.components;

import com.example.demo1.model.boss.Boss;
import com.example.demo1.model.boss.BossOne;
import com.example.demo1.model.boss.BossThree;
import com.example.demo1.model.boss.BossTwo;
import com.example.demo1.transitions.BossAnimation;
import com.example.demo1.transitions.BossThreeAnimation;
import com.example.demo1.transitions.BossTwoAnimation;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import lombok.Getter;

public class BossComponent extends Component {
	private Pane parent;
	@Getter
	private Boss boss;
	public BossComponent(Pane parent, Boss boss){
		super(boss instanceof BossThree ? 0 : 850,
				boss instanceof BossThree ? parent.getPrefHeight() - boss.getHeight() : (parent.getPrefHeight() - boss.getHeight()) / 2,
				boss.getWidth(), boss.getHeight());
		this.parent = parent;
		this.boss = boss;
		boss.setComponent(this);
		if(boss instanceof BossOne)
			(new BossAnimation(this)).play();
		if(boss instanceof BossTwo)
			(new BossTwoAnimation(this)).play();
		if(boss instanceof BossThree)
			(new BossThreeAnimation(this)).play();
	}

	@Override
	public Pane getPane() {
		return parent;
	}
}
