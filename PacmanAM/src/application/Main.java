package application;
	
import application.model.Board;
import application.view.BoardView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/*******************************************************************
 * PACMAN
 * 
 *  This project demonstrates JavaFX for a simple PACMAN game.
 *  The levels are loaded dynamically from flat files.
 *  
 *  ---Currently a work in progress---
 * 
 * UTSA CS 3443 Application Programming
 * @author Amanda Fernandez
 *******************************************************************/
public class Main extends Application {
	
	public static Board model;					// the model of the app
    public static BoardView view;				// the view of the app
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../Main.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();
							
			// Load the Board model 
			model = Board.loadFromFile("level1.txt");
			
			// Load the Board view
			view = new BoardView( model );
			layout.getChildren().add( view );
			Scene scene = new Scene( layout );
			
			// TODO: connect the controller!
			
			// Sets the scene to the stage & shows stage to user
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace(); // TODO: handle this better!
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
