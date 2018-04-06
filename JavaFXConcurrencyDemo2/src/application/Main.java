package application;
	
import application.controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		MainController m = new MainController();
		m.setUp();
		
        StackPane root = new StackPane();
        root.getChildren().add( m.getPane() );

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Basic JavaFX Threads");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
