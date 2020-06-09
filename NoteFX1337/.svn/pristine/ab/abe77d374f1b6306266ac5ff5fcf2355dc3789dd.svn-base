package notefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("notefxmenu.fxml"));

		Scene scene = new Scene(root);
		// ändrar icon
		primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/notepad.png")));

		primaryStage.setTitle("NoteFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
	}
}
