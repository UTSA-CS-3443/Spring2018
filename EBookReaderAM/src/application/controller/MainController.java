package application.controller;

import java.io.File;
import java.io.IOException;

import application.Main;
import application.model.Library;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class MainController implements EventHandler {

	@FXML
	Button chooseLocation;														// the "choose directory" button on the UI

	@FXML
	ListView listView;
	
	public static Library libraryModel;											// the model (data!) for this application
	
	// Create a GUI listing of the books to show the user (will be populated by the model)
	public static final ObservableList books = FXCollections.observableArrayList();
	
	@Override
	public void handle(Event event) {		
		// Launch directory chooser to request user to select their library
		//   (library is a folder on their computer containing ebook files)
		DirectoryChooser dirChooser = new DirectoryChooser();
		File dir = dirChooser.showDialog(null);
		
		if( dir!=null ) {
			System.out.println( dir.getAbsolutePath() );
			
			// Update the model with the user-chosen directory
			libraryModel = new Library( dir.getAbsolutePath() );
			
			// Redirect user to next scene, to display the listing of books in their library...
			try {
				// Load the FXML document (we created with SceneBuilder)
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( MainController.class.getResource("../../Library.fxml") );
				
				// Load the layout from the FXML and add it to the scene
				AnchorPane layout = (AnchorPane) loader.load();	
				
				// Add data to the new scene
				books.addAll( libraryModel.getBooks() );								// copy the data over from our model
				ListView listView = new ListView( books );							// set up a GUI component to hold the list
				listView.setPrefSize(400, 600);										// resize the GUI component
				listView.setCellFactory( ComboBoxListCell.forListView(books) );		// put each book in a separate cell (list item)
				layout.getChildren().add( listView );								// put this GUI component onto the scene
				
				// Set the scene to stage and show the stage to the user
				Scene scene = new Scene( layout );
				Main.stage.setScene(scene);
				
			}catch( IOException e ) {
				e.printStackTrace();
			}
			
		// Handle the situation when the user clicks "cancel" button instead of choosing a directory..	
		}else
			System.out.println("user chose to cancel operation");						
	}

}
