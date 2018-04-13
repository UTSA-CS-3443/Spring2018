package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MainController implements EventHandler<KeyEvent>{

	@Override
	public void handle(KeyEvent event) {
		
		System.out.println( event.getCode() );
		
		// U, D, L, R
		char key = event.getCode().toString().charAt(0);
		
		// move pacman around via given user input - MODEL
		Main.model.move( key );
		
		//TODO: update the view to show pacman moving - VIEW
		Main.view.update( Main.model.getCurrentRow(), Main.model.getCurrentColumn(), 
				Main.model.getPreviousRow(), Main.model.getPreviousColumn() );
		
		//TODO: end game when pacman ate all pellets - MODEL
		
	}


	
}
