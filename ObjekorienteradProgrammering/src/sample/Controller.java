package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Controller extends Thread {
    //////////////////////////These vars and objects had to be outside the methods for availability
    int start = 0;
    TextArea Results = new TextArea();
    //private TextField Tiden = new TextField();
    LocalTime DateC = LocalTime.now();
    LocalTime timerNow = LocalTime.of(00, 00, 00, 00);
    DateTimeFormatter timerFormat = DateTimeFormatter.ofPattern("mm:ss:SSS");
    DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /////BEginning MAIN method
    public void actionMain(Stage mainstage) throws Exception {
        Tid tid = new Tid();

        ////////////////Body creation
        TextField Tiden =new TextField();
        BorderPane border = new BorderPane();
        Button stop = new Button(" Start/Stop ");
        Button reset = new Button(" Reset ");
        VBox vbox = new VBox(Tiden);
        VBox vbox2 = new VBox(Results);
        HBox hbox = new HBox(stop, reset);
        Tiden.setText(timerNow.toString());

        /////////////////////////// Styling
        vbox2.setMinHeight(300);
        mainstage.setResizable(false);
        Tiden.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Tiden.setEditable(false);
        Results.setEditable(false);
        Tiden.setStyle("-fx-background-color: transparent");
        Results.setStyle("-fx-background-color: transparent");
        Results.setText("Date                                       Saved Time");
        border.setTop(vbox);
        border.setCenter(hbox);
        border.setBottom(vbox2);
        /////////////////////// End Styling

        //////////////////Buttton Actions
        stop.setOnAction(actionEvent -> {
            try {
                start++;
                if (start % 2 == 1) {
                    tid.setAgain(true);
                    tid.timer(Tiden);
                } else {
                    tid.setAgain(false);
                    LocalDateTime check = LocalDateTime.now();
                    Results.appendText("\n" + check.format(dayFormat).toString() + "          :        " + tid.getTimer());
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
            ;
        });
        reset.setOnAction(actionEvent -> {
            try {
                Results.setText("Date                                       Saved Time");
                timerNow = LocalTime.of(00, 00, 00, 00);
                Tiden.setText(timerFormat.format(timerNow));
                tid.setTimer(timerNow);

            } catch (Exception o) {
                o.printStackTrace();
            }
            ;
        });

///////////////////////End Button

        /////Setting scene and Style

        Scene scene = new Scene(border, 250, 300);
        scene.getStylesheets().add("Style.css");
        mainstage.setScene(scene);
        mainstage.show();


    }


}

