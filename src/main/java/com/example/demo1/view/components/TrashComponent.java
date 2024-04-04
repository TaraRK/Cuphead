package com.example.demo1.view.components;

import com.example.demo1.model.Trash;
import com.example.demo1.transitions.TrashAnimation;
import javafx.scene.layout.Pane;

public class TrashComponent extends Component {
	private Pane pane;
	private Trash trash;
	public TrashComponent(Pane parent, Trash trash){
		super(trash.getGame().getBoss().getComponent().getX() + 530,
				trash.getGame().getBoss().getComponent().getY() + 120,
				trash.getImageWidth(),
				trash.getImageHeight()
		);
		this.pane = parent;
		this.trash = trash;
		setFill(trash.getImage());
		pane.getChildren().add(this);
		pane.getChildren().get(0).requestFocus();
		(new TrashAnimation(trash)).play();
		trash.setComponent(this);
	}

	@Override
	public Pane getPane() {
		return pane;
	}
}
