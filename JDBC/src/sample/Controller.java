package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {


    DataBas dataBas = new DataBas();
    DataBas dataBasActor = new DataBas();
    String actors;


    @FXML
    private TextField descriptionTextField, lengthTextField, ratingTextField, releaseYearTextField, rentalRateTextField,
            replacementCostTextField, specialFeaturesTextField, titleTextField;
    @FXML
    private TextArea actorsTextArea;
    @FXML
    private Label descriptionLabel, lengthLabel, ratingLabel, releaseYearLabel, rentalRateLabel, replacementCostLabel, specialFeaturesLabel;
    @FXML
    private URL location;
    @FXML
    private Button nextButton, firstButton, previousButton, saveButton, lastButton;




    public Controller() throws SQLException {
    }


    @FXML
    void nextButtonOnAction(ActionEvent event) throws SQLException {
        dataBas.nextFilm();
        setLabels();

    }




    @FXML
    void previousButtonOnAction(ActionEvent event) throws SQLException {
        dataBas.previousFilm();
        setLabels();

    }

    @FXML
    void saveButtonOnAction(ActionEvent event) throws SQLException {
        System.out.println(titleTextField.getText()+ descriptionTextField.getText()+ releaseYearTextField.getText()+ rentalRateTextField.getText()+
                lengthTextField.getText()+ replacementCostTextField.getText()+ ratingTextField.getText()+ specialFeaturesTextField.getText());
        dataBas.saveFilm(titleTextField.getText(), descriptionTextField.getText(), releaseYearTextField.getText(), rentalRateTextField.getText(),
                lengthTextField.getText(), replacementCostTextField.getText(), ratingTextField.getText(), specialFeaturesTextField.getText());

    }

    @FXML
    void lastButtonOnAction(ActionEvent event) throws SQLException {
        dataBas.lastFilm();
        setLabels();

    }

    @FXML
    void firstButtonOnAction(ActionEvent event) throws SQLException {
        dataBas.firstFilm();
        setLabels();

    }

    void setLabels() throws SQLException {
        titleTextField.setText(dataBas.getTitle());
        descriptionTextField.setText(dataBas.getDescription());
        releaseYearTextField.setText(dataBas.getReleaseYear());
        rentalRateTextField.setText(dataBas.getRentalRate());
        lengthTextField.setText(dataBas.getLength());
        replacementCostTextField.setText(dataBas.getReplacementCost());
        ratingTextField.setText(dataBas.getRating());
        specialFeaturesTextField.setText(dataBas.getSpecialFeatures());
        dataBasActor.setId(dataBas.getId());
        actors = dataBasActor.getActor();
        System.out.println(actors);
        System.out.println("------------------------------------------------");
        actorsTextArea.setText(actors);

    }

    @FXML
    void initialize() {
        assert actorsTextArea != null : "fx:id=\"actorsTextArea\" was not injected: check your FXML file 'sample.fxml'.";
        assert descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert descriptionTextField != null : "fx:id=\"descriptionTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert firstButton != null : "fx:id=\"firstButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert lastButton != null : "fx:id=\"lastButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert lengthLabel != null : "fx:id=\"lengthLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert lengthTextField != null : "fx:id=\"lengthTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert nextButton != null : "fx:id=\"nextButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert previousButton != null : "fx:id=\"previousButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert ratingLabel != null : "fx:id=\"ratingLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert ratingTextField != null : "fx:id=\"ratingTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert releaseYearLabel != null : "fx:id=\"releaseYearLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert releaseYearTextField != null : "fx:id=\"releaseYearTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert rentalRateLabel != null : "fx:id=\"rentalRateLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert rentalRateTextField != null : "fx:id=\"rentalRateTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert replacementCostLabel != null : "fx:id=\"replacementCostLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert replacementCostTextField != null : "fx:id=\"replacementCostTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert specialFeaturesLabel != null : "fx:id=\"specialFeaturesLabel\" was not injected: check your FXML file 'sample.fxml'.";
        assert specialFeaturesTextField != null : "fx:id=\"specialFeaturesTextField\" was not injected: check your FXML file 'sample.fxml'.";
        assert titleTextField != null : "fx:id=\"titleTextField\" was not injected: check your FXML file 'sample.fxml'.";



    }


}
