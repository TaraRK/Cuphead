package com.example.demo1.view.components;

import com.example.demo1.model.Egg;
import com.example.demo1.model.ammo.Ammo;
import com.example.demo1.transitions.AmmoAnimation;
import com.example.demo1.transitions.EggAnimation;
import javafx.scene.layout.Pane;

public class EggComponent extends Component {
	private Pane pane;
	private Egg egg;
	public EggComponent(Pane parent, Egg egg){
		super(egg.getGame().getBoss().getComponent().getX() + 30,
				egg.getGame().getBoss().getComponent().getY() + 80,
				egg.getImageWidth(),
				egg.getImageHeight()
		);
		this.pane = parent;
		this.egg = egg;
		setFill(egg.getImage());
		pane.getChildren().add(this);
		pane.getChildren().get(0).requestFocus();
		(new EggAnimation(egg)).play();
		egg.setComponent(this);
	}

	@Override
	public Pane getPane() {
		return pane;
	}
}
