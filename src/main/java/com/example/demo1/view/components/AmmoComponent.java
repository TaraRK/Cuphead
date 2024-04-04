package com.example.demo1.view.components;

import com.example.demo1.model.Game;
import com.example.demo1.model.Plane;
import com.example.demo1.model.ammo.Ammo;
import com.example.demo1.transitions.AmmoAnimation;
import javafx.scene.layout.Pane;
import lombok.Getter;

@Getter
public class AmmoComponent extends Component {
	private Pane pane;
	private Ammo ammo;
	public AmmoComponent(Pane parent, Ammo ammo){
		super(ammo.getGame().getCupHead().getComponent().getX() + ammo.getRenderPositionX() * ammo.getGame().getCupHead().getComponent().getWidth(),
				ammo.getGame().getCupHead().getComponent().getY() + ammo.getRenderPositionY() * ammo.getGame().getCupHead().getComponent().getHeight(),
				ammo.getImageWidth(),
				ammo.getImageHeight()
		);
		this.pane = parent;
		this.ammo = ammo;
		setFill(ammo.getImage());
		pane.getChildren().add(this);
		pane.getChildren().get(0).requestFocus();
		(new AmmoAnimation(ammo)).play();
		ammo.setComponent(this);
	}

	@Override
	public Pane getPane() {
		return pane;
	}
}
