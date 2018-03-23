package application.view;

import application.model.Board;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane{

	private Board model;
	private int imgSize;
	
	public BoardView( Board model ) {
		this.model = model;
	}
	
	// TODO: create the other getter methods 
	
	public ImageView chooseImage(char letter) {
		switch( letter ) {
			case 'c' : return getPacmanImage();
			default: return getDefaultImage();
		}
	}
	
	
	public ImageView getPacmanImage() {
		ImageView img = new ImageView("File:pacman_sprites/pacman.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getPelletImage() {
		ImageView img = new ImageView("File:pacman_sprites/pellet.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getDefaultImage() {
		ImageView img = new ImageView("File:pacman_sprites/default.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
}
