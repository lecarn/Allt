package notefx;


import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//pekar p� att notefxmenu.fxml ska anv�ndas som fxml fil
		Parent root = FXMLLoader.load(getClass().getResource("notefxmenu.fxml"));

		Scene scene = new Scene(root);
		// S�tter ikon f�r programmet.
		primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/notepad.png")));

		// Skapar primarystage/"huvudrutan"
		primaryStage.setTitle("NoteFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//S�tter custom ruta d� man klickar krysset.
		primaryStage.setOnCloseRequest ( evt -> {
			evt.consume();
			close();
		});


		
	}


	public static void main(String[] args) {
		launch(args);
		
	}
	/**
	 * Metod f�r dialogruta d� man kryssar.
	 * St�nger vid exit men ej vid cancel.
	 */
	public void close() {
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		exitAlert.setTitle("Exit?");
		exitAlert.setHeaderText("Do you want to exit?");

		Optional<ButtonType> result = exitAlert.showAndWait();
		if (result.get() == ButtonType.OK){
		    Platform.exit();
		    System.exit(0);
		} 
	}
}
