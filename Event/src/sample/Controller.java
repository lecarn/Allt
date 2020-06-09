package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button buttonA, buttonB;
    @FXML
    private Label labelA, labelB;

    Counter count = new Counter();
    int countA;
    int countB;

    @FXML
    void aButtonOnAction(ActionEvent event) {
        labelA.setText(String.valueOf(count.countA()));
    }

    @FXML
    void bButtonOnAction(ActionEvent event) {
        labelB.setText(String.valueOf(count.countB()));
    }

    @FXML
    public void keyPress(KeyEvent key){
        if(key.getCode() == KeyCode.H) {
                System.out.println("Hejhej");
                System.out.println("HejHallå");
        }
    }

}
