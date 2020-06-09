package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StopWatch extends Application implements EventHandler<javafx.event.ActionEvent> {

    private VBox vBox;
    private HBox middleButtons;
    private Button startStopButton,saveButton, resetButton, clearButton;
    private Text text, textSplit;
    private TableView<Time> tableView;
    private DateFormat dateFormat;
    private Date date;
    private Timeline timeLine, timeLineSplit;
    private KeyFrame keyFrame, keyFrameSplit;
    private ObservableList<Time> timeObservableList;
    private Log log;
    private Timercalc timercalc;

    private boolean started = false;

    private int ms, msSplit;
    private String resetClock = "00:00:000";

    @Override
    public void start(Stage primaryStage) {

        /* Creating the two clocks (Time and split-Time). Both will count milliseconds */
        keyFrame = new KeyFrame(Duration.millis(1), (ActionEvent) -> {
            ms++;
            text.setText(timercalc.calc(ms));
        });
        timeLine = new Timeline(keyFrame);
        timeLine.setCycleCount(Animation.INDEFINITE);


        keyFrameSplit = new KeyFrame(Duration.millis(1), (ActionEvent) -> {
            msSplit++;
            textSplit.setText(timercalc.calcSplitTime(msSplit));
        });
        timeLineSplit = new Timeline(keyFrameSplit);
        timeLineSplit.setCycleCount(Animation.INDEFINITE);

        /* Creating 3 columns for the observable list (Date, Split Time and Time) */
        TableColumn<Time, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(150);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Time, String> timeColumn = new TableColumn<>("Split Time");
        timeColumn.setMinWidth(75);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<Time, String> timerTimeColumn = new TableColumn<>("Time");
        timerTimeColumn.setMinWidth(75);
        timerTimeColumn.setCellValueFactory(new PropertyValueFactory<>("timerTime"));

        /* Setup for the tableView */
        tableView = new TableView<>();
        tableView.setItems(getTimeObservableList());
        tableView.getColumns().addAll(dateColumn, timeColumn, timerTimeColumn);

        /* Adding simple graphic enhancements for the two clocks */
        textSplit = new Text(resetClock);
        textSplit.setFill(Color.RED);
        textSplit.setFont(Font.font("Verdana", 15));

        text = new Text(resetClock);
        text.setFill(Color.GREEN);
        text.setFont(Font.font("Verdana", 40));

        /* Creating buttons and making them look for a method to handle their events in this class*/
        startStopButton = new Button("Start");
        startStopButton.setOnAction(this);
        saveButton = new Button("Split");
        saveButton.setOnAction(this);
        resetButton = new Button("Reset");
        resetButton.setOnAction(this);
        clearButton = new Button("Clear");
        clearButton.setOnAction(this);

        /* Adds all horizontal buttons to a HBox */
        middleButtons = new HBox(30);
        middleButtons.setAlignment(Pos.CENTER);
        middleButtons.getChildren().addAll(saveButton, startStopButton, resetButton);

        /* Adds all components to a VBox */
        vBox = new VBox(10);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(25,10,25,10));
        vBox.getChildren().addAll(text, textSplit, middleButtons, tableView, clearButton);

        /* Setup for the stage */
        Pane layout = new Pane();
        layout.getChildren().addAll(vBox);;

        Scene scene = new Scene(layout, 332, 590);
        primaryStage.setScene(scene);
        primaryStage.setTitle("StopWatch");
        primaryStage.show();

    }

    public ObservableList<Time> getTimeObservableList() {
        timeObservableList = FXCollections.observableArrayList();
        return timeObservableList;
    }

    /* Method for handling action events */
    @Override
    public void handle(javafx.event.ActionEvent event) {
        timercalc = new Timercalc();
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        log = new Log();

        if(event.getSource() == startStopButton){
            if (started){
                started = false;                    /* Telling the program the clock has stopped */
                startStopButton.setText("Start");   /* Changing buttontext to "Start" */
                timeLine.pause();                   /* Pauses the timeline (clock) */
                timeLineSplit.pause();              /* - */
                log.stop();                         /* Logs the event in console */
            }
            else {
                started = true;                     /* Telling the program the clock has started */
                startStopButton.setText("Stop");    /* Changing buttontext to "Stop" */
                timeLine.play();                    /* Plays the timeline (clock) */
                timeLineSplit.play();               /* - */
                log.start();                        /* Logs the event in console */
            }
        }

        if(event.getSource() == resetButton){
            text.setText(resetClock);               /* Resetting the "clocktext" to 00:00:000 */
            textSplit.setText(resetClock);          /* - */
            ms = 0;                                 /* Resetting the millisecond-counter */
            msSplit = 0;                            /* - */
            log.reset();                            /* Logs the event in console */
        }

        if(event.getSource() == clearButton){
            timeObservableList.clear();             /* Clearing the observable list (history) */
            log.clear();                            /* Logs the event in console */
        }

        if(event.getSource() == saveButton){
            timeObservableList.add(new Time         /* Adding current data (date, Split time, time) to Obslist */
                    (dateFormat.format(date), timercalc.calcSplitTime(msSplit), timercalc.calc(ms)));
            msSplit = 0;                            /* Resetting the split time millisecond-counter */
            log.save();                             /* Logs the event in console */
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
