package server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientsJavaFX extends Application {
    SocketTest client = new SocketTest();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Start of visuals
        GridPane gridpane = new GridPane();
        primaryStage.setScene(new Scene(gridpane, 300, 500));
        primaryStage.show();


        Label topLabel = new Label("Queue Ticket");
        GridPane.setConstraints(topLabel, 0, 0);
        topLabel.setMinWidth(300);
        topLabel.setMinHeight(60);
        topLabel.setStyle("-fx-font: 30 arial");
        topLabel.setAlignment(Pos.CENTER);

        Button lappButton = new Button("Ta Lapp");
        GridPane.setConstraints(lappButton, 0, 1);
        lappButton.setMinWidth(300);
        lappButton.setMinHeight(50);

        Label queueLabel = new Label("Queue");
        GridPane.setConstraints(queueLabel, 0, 2);
        queueLabel.setStyle("-fx-font: 20 arial; -fx-padding: 50 85 0 100");
        queueLabel.setAlignment(Pos.CENTER);

        Label queueText = new Label("0");
        GridPane.setConstraints(queueText, 0, 3);
        queueText.setText("0");
        queueText.setAlignment(Pos.CENTER);
        queueText.setStyle("-fx-font: 50 arial; -fx-padding: 0 85 0 100");

        Label servedLabel = new Label("Being Served");
        GridPane.setConstraints(servedLabel, 0, 4);
        servedLabel.setStyle("-fx-font: 20 arial; -fx-padding: 50 85 0 70");
        servedLabel.setAlignment(Pos.CENTER);

        Label servedText = new Label("0");
        GridPane.setConstraints(servedText, 0, 5);
        servedText.setText("0");
        servedText.setAlignment(Pos.CENTER);
        servedText.setStyle("-fx-font: 50 arial; -fx-padding: 0 85 0 100");



        gridpane.getChildren().addAll(topLabel, lappButton, queueText, servedText, queueLabel, servedLabel);

        //End of visuals


        // Takes a queue ticket.
        lappButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    System.out.println("asd");




                    queueText.setText(client.getQueue("1"));
                    servedText.setText(client.getServed("2"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        //Serving new person when space is pressed.
        lappButton.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("SPACE Pressed");

                    queueText.setText(client.getQueue("2"));
                    servedText.setText(client.getServed("3"));

                    event.consume();
                }
            }
        });


    }
}


