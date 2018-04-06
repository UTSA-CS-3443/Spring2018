package application.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class MainController {

	private VBox vBox;
	private Task task = null;
	private ProgressBar progressBar;
	private Label counterLabel;
	private Label stateLabel;
	private Button startButton;
	private Button taskButton;
	
	public void setUp() {
		
        task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                int max = 50;
                for (int i = 1; i <= max; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, max);
                    updateMessage(String.valueOf(i));

                    Thread.sleep(100);
                }
                return null;
            }
        };

        progressBar = new ProgressBar();
        progressBar.setProgress(0);
        progressBar.progressProperty().bind(task.progressProperty());
        
        counterLabel = new Label();
        counterLabel.textProperty().bind(task.messageProperty());
        
        stateLabel = new Label();
        
        startButton = new Button("Begin Task");
        startButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                new Thread(task).start();
            }
        });
        
        taskButton = new Button("Check Task State");
        taskButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                stateLabel.setText(task.getState().toString());
            }
        });
                      

        vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(5);
        vBox.getChildren().addAll( progressBar, counterLabel, startButton, taskButton, stateLabel);
	}
	
	public VBox getPane() {
		return this.vBox;
	}
}
