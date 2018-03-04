package application.controller;

import java.io.File;
import java.io.IOException;

import application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class MainController implements EventHandler {

	@FXML
	Button chooseLocation;
	
	@Override
	public void handle(Event event) {		
		DirectoryChooser dirChooser = new DirectoryChooser();
		File dir = dirChooser.showDialog(null);
		
		if( dir!=null )
			System.out.println( dir.getAbsolutePath() );
		else
			System.out.println("user chose to cancel operation");
		
		// redirect user to next scene
		try {
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainController.class.getResource("../../Library.fxml") );
			
			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			// Set the scene to stage and show the stage to the user
			Main.stage.setScene(scene);
		}catch( IOException e ) {
			e.printStackTrace();
		}
	}

}
