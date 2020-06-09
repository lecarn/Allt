package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Evil StopTimer");
        primaryStage.setScene(new Scene(root, 250, 300));
        primaryStage.show();

        Controller controler = new Controller();
        controler.actionMain(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
