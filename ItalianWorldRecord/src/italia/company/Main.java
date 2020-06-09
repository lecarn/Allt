package italia.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    // -- JavaFX Components
    private VBox vBox = new VBox();
    private Button buttonSetWorldRecord = new Button("Let's help Milleaccendini set the world record!");
    private TextField cocaColaField = new TextField();
    private TextField nutellaField = new TextField();
    private TextField durexField = new TextField();
    private TextField mentosField = new TextField();
    private TextField italiaField = new TextField();
    private List<TextField> listOfIngredients = new ArrayList<>();

    private Cauldron cauldron = new Cauldron();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initVerticalBoxSettings();
        Scene firstScene = new Scene(vBox);
        stage.setScene(firstScene);
        cauldron.addIngredientsToCauldron();
        buttonSetWorldRecord.setOnAction(e -> {
            try {
                if(cauldron.isReadyForWorldRecord()) {
                    init(stage);
                } else {
                    throw new RuntimeException("Error, not all ingredients are filled correctly, read corresponding guide to complete the challenge!");
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        stage.show();
    }

    private void initVerticalBoxSettings() {
        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.getChildren().addAll(cocaColaField, nutellaField, mentosField, durexField);
        vBox.getChildren().add(italiaField);
        vBox.getChildren().add(buttonSetWorldRecord);

        for (Node node : vBox.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;
                textField.setPrefHeight(80);
                textField.setPrefWidth(560);
                textField.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
            }
        }
        buttonSetWorldRecord.setPrefHeight(80);
        buttonSetWorldRecord.setPrefWidth(560);
    }

    private void addIngredientsToGUI(TextField incommingTextField, int nodePosition) {
        if (nodePosition != 4) {
            incommingTextField.setText(cauldron.getIngredientList().get(nodePosition).getIngredientName() + " added!");
        } else {
            incommingTextField.setText("ITAALIAAAA!!");
        }
    }

    private void init(Stage stage) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Node node : vBox.getChildren()) {
                    try {
                        Thread.sleep(1000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (node instanceof TextField) {
                                    addIngredientsToGUI((TextField) node, vBox.getChildren().indexOf(node));
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        new Milleaccendini(stage);
                    }
                });
            }
        }).start();
    }

}
