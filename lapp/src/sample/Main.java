package sample;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {



        try (Socket socket = new Socket("localhost", 8000)) {


            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));




        //Create main gridpane. The visual.
        GridPane gridpane = new GridPane();
        primaryStage.setScene(new Scene(gridpane, 300, 500));
        primaryStage.show();


        Label topLabel = new Label("NummerLapp");
        GridPane.setConstraints(topLabel, 0, 0);
        topLabel.setMinWidth(300);
        topLabel.setMinHeight(60);
        topLabel.setStyle("-fx-font: 30 arial");
        topLabel.setAlignment(Pos.CENTER);

        Button lappButton = new Button("Ta Lapp");
        GridPane.setConstraints(lappButton, 0, 1);
        lappButton.setMinWidth(300);
        lappButton.setMinHeight(50);

        Label queueText = new Label("0");
        GridPane.setConstraints(queueText, 0, 2);
        queueText.setText("0");
        queueText.setAlignment(Pos.CENTER);
        queueText.setStyle("-fx-font: 150 arial; -fx-padding: 50 100 0 100");


        gridpane.getChildren().addAll(topLabel, lappButton, queueText);
        //End of visual.






                    String messege = "hej";
                    lappButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            try {

                                System.out.println("Skriv");
                                String queueString = reader.readLine();

                                queueText.setText(queueString);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    }catch(Exception e) {
                        e.printStackTrace();
                    }

                }








    public static void main(String[] args) {
        launch(args);
    }
}
