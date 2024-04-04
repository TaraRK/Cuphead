package com.example.demo1.view.components;

import com.example.demo1.model.Blast;
import com.example.demo1.model.Egg;
import com.example.demo1.transitions.BlastAnimation;
import com.example.demo1.transitions.EggAnimation;
import javafx.scene.layout.Pane;

public class BlastComponent extends Component {
	private Pane pane;
	private Blast blast;
	public BlastComponent(Pane parent, Blast blast){
		super(blast.getGame().getBoss().getComponent().getX() + 30,
				blast.getGame().getBoss().getComponent().getY() + 80,
				blast.getImageWidth(),
				blast.getImageHeight()
		);
		this.pane = parent;
		this.blast = blast;
		setFill(blast.getImage());
		pane.getChildren().add(this);
		pane.getChildren().get(0).requestFocus();
		(new BlastAnimation(blast)).play();
		blast.setComponent(this);
	}

	@Override
	public Pane getPane() {
		return pane;
	}
}
