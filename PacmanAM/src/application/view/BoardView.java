package application.view;

import application.model.Board;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane{

	private Board model;
	private int imgSize;
	
	public BoardView( Board model ) {
		this.model = model;
		this.imgSize = 80;
		
		// add GUI components
		this.setUpView();
	}
	
	private void setUpView() {
		for( int r=0; r<model.getRows(); r++ ) {
			for( int c=0; c<model.getCols(); c++ ) {
				// board[r][c] 
				char letter = model.getBoardLocation(r,c);
				ImageView img = chooseImage( letter );
				this.add( img, c, r );
			}
		}
	}
	
	
	public ImageView chooseImage(char letter) {
		switch( letter ) {
			case 'c' : return getPacmanImage();
			case 'p' : return getPelletImage();
			case 'w' : return getWallImage();
			case 'e' : return getEndImage();
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
	
	public ImageView getWallImage() {
		ImageView img = new ImageView("File:pacman_sprites/wall.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getEndImage() {
		ImageView img = new ImageView("File:pacman_sprites/end.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
}
