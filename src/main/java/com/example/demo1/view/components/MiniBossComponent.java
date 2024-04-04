package com.example.demo1.view.components;

import com.example.demo1.model.Game;
import com.example.demo1.model.MiniBoss;
import com.example.demo1.transitions.MiniBossAnimation;
import javafx.scene.layout.Pane;
import lombok.Getter;

public class MiniBossComponent extends Component {
	private Pane parent;
	@Getter
	private MiniBoss miniBoss;
	public MiniBossComponent(int x, int y, Pane parent, Game game){
		super(x, y, 161, 118);
		this.parent = parent;
		this.miniBoss = new MiniBoss(game);
		this.miniBoss.setComponent(this);

		parent.getChildren().add(this);
		(new MiniBossAnimation(this)).play();
	}

	@Override
	public Pane getPane() {
		return parent;
	}
}
