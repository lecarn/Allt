package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		GridPane gridpane = new GridPane();
		primaryStage.setScene(new Scene(gridpane, 504, 505));
		primaryStage.show();
		
		Button button = new Button("Hej");
		
		gridpane.setConstraints(button, 0, 2);
		Button buttontwo = new Button("då");
		gridpane.setConstraints(buttontwo, 1,1);
		
		

		gridpane.getChildren().addAll(button, buttontwo);
	

	}

	public static void main(String[] args) {
		launch(args);
	}
}
