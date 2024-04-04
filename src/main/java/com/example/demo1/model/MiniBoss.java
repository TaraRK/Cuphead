package com.example.demo1.model;

import com.example.demo1.transitions.DeathAnimation;
import com.example.demo1.view.components.MiniBossComponent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import lombok.Getter;
import lombok.Setter;

@Getter
public class MiniBoss implements Damageable, Motion {
	private static final int groupSize = 5;
	private static final int speed = 4;
	private int health;
	private Game game;
	@Setter
	private MiniBossComponent component;
	public MiniBoss(Game game){
		health = 2;
		this.game = game;
		game.getDamageable().add(this);
	}

	public static void generateGroup(int y, Pane parent, Game game){
		for(int i = 0; i < groupSize; i++)
			new MiniBossComponent((int) (parent.getWidth() + i * 190), y, parent, game);
	}

	@Override
	public void dealDamage(int damage){
		health -= damage;
	}

	public boolean isDead(){
		return health <= 0;
	}

	@Override
	public void remove() {
		game.getDamageable().remove(this);
		death();
	}

	public void death(){
		game.changeScore(+10);
		DeathAnimation animation = new DeathAnimation(component);
		animation.setOnFinished(actionEvent -> {
			component.getPane().getChildren().remove(component);
		});
		AudioClip audioClip = new AudioClip(getClass().getResource("/com/example/demo1/MP3/squeak.wav").toString());
		audioClip.play();
		animation.play();
	}


	@Override
	public void move() {
		component.setX(component.getX() - speed);
	}
}
