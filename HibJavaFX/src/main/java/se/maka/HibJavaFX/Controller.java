package se.maka.HibJavaFX;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Controller {
    DbConnection dbConnection = new DbConnection();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label sokKonsertLabel, sokPersonLabel, skapaPersonLabel, skapaKonsertLabel, linkLabel;
    @FXML
    private TextField sokKonsertTextFIeld, sokPersonTextField, skapaPersonAgeTextField, skapaPersonNameTextField,
            skapaKonsertArtistTextField, skapaKonsertDateTextField, linkPersonTextField, linkArtistTextFIeld;
    @FXML
    private Button sokPersonButton, sokKonsertButton, skapaPersonButton, skapaKonsertButton, linkPersonArtistButton;

    @FXML
    void sokKonsertButton(ActionEvent event) {
        dbConnection.getKonsert(Integer.parseInt(sokKonsertTextFIeld.getText()));
        System.out.println("hejhej");
//        dbConnection.getPersoner(Integer.parseInt(sokKonsertTextFIeld.getText()));
    }

    @FXML
    void skapaPersonButtonOnAction(ActionEvent event) {
        dbConnection.addPerson(skapaPersonNameTextField.getText(), Integer.parseInt(skapaPersonAgeTextField.getText()));
    }

    @FXML
    void sokPersonButtonOnAction(ActionEvent event) {
        dbConnection.getPerson(sokPersonTextField.getText());
    }

    @FXML
    void skapaKonsertButtonOnAction(ActionEvent event) {
        dbConnection.addKonsert(skapaKonsertArtistTextField.getText(), skapaKonsertDateTextField.getText());
    }

    @FXML
    void linkPersonArtistButtonOnAction(ActionEvent event) {
        dbConnection.addKonsert_Personer(Integer.parseInt(linkArtistTextFIeld.getText()), Integer.parseInt(linkPersonTextField.getText()));
    }


    @FXML
    void initialize() {
        assert linkArtistTextFIeld != null : "fx:id=\"linkArtistTextFIeld\" was not injected: check your FXML file 'sample.fxml'.";
        assert linkLabel != null : "fx:id=\"linkLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert linkPersonArtistButton != null : "fx:id=\"linkPersonArtistButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert linkPersonTextField != null : "fx:id=\"linkPersonTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaKonsertArtistTextField != null : "fx:id=\"skapaKonsertArtistTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaKonsertButton != null : "fx:id=\"skapaKonsertButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaKonsertDateTextField != null : "fx:id=\"skapaKonsertDateTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaKonsertLabel != null : "fx:id=\"skapaKonsertLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaPersonAgeTextField != null : "fx:id=\"skapaPersonAgeTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaPersonButton != null : "fx:id=\"skapaPersonButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaPersonLabel != null : "fx:id=\"skapaPersonLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert skapaPersonNameTextField != null : "fx:id=\"skapaPersonNameTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert sokKonsertButton != null : "fx:id=\"sokKonsertButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert sokKonsertLabel != null : "fx:id=\"sokKonsertLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert sokKonsertTextFIeld != null : "fx:id=\"sokKonsertTextFIeld\" was not injected: check your FXML file 'sample.fxml'.";
        assert sokPersonButton != null : "fx:id=\"sokPersonButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert sokPersonLabel != null : "fx:id=\"sokPersonLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert sokPersonTextField != null : "fx:id=\"sokPersonTextField\" was not injected: check your FXML file 'sample.fxml'.";


    }
}