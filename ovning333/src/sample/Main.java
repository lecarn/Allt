package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

import java.beans.XMLEncoder;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class Main extends Application {



    //bList for loading, aList for saving, obList to populate tableview.
    ArrayList<Person> bList= new ArrayList<>();
    ArrayList<Person> aList = new ArrayList<>();
    ObservableList<Person> obList = FXCollections.observableList(aList);


    @Override
    public void start(Stage primaryStage) {


        //Create main gridpane.
        GridPane gridpane = new GridPane();
        primaryStage.setScene(new Scene(gridpane, 500, 500));
        primaryStage.show();


        //Create textfields/labels.
        Label fNameLabel = new Label("First name:");
        GridPane.setConstraints(fNameLabel, 0, 0);
        fNameLabel.setMinWidth(150);

        TextField fNameInput = new TextField();
        fNameInput.setPromptText("Input first name...");
        GridPane.setConstraints(fNameInput, 1, 0);

        Label lNameLabel = new Label("Last name: ");
        GridPane.setConstraints(lNameLabel, 0, 1);

        TextField lNameInput = new TextField();
        lNameInput.setPromptText("Input last name...");
        GridPane.setConstraints(lNameInput, 1, 1);

        Label ageLabel = new Label("Age: ");
        GridPane.setConstraints(ageLabel, 0, 2);

        TextField ageInput = new TextField();
        ageInput.setPromptText("Input age...");
        GridPane.setConstraints(ageInput, 1, 2);


        //Adds tableview.
        TableView<Person> tableView = new TableView<Person>();

        tableView.setItems(obList);
        TableColumn<Person, String> fNameTable = new TableColumn<Person, String>("First Name");
        fNameTable.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn<Person, String> lNameTable = new TableColumn<Person, String>("Last Name");
        lNameTable.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        TableColumn<Person, String> ageTable = new TableColumn<Person, String>("Age");
        ageTable.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));

        fNameTable.setMinWidth(200);
        lNameTable.setMinWidth(200);
        ageTable.setMinWidth(100);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        column1.setPercentWidth(33);
        column2.setPercentWidth(33);
        column3.setPercentWidth(33);
        gridpane.getColumnConstraints().addAll(column1, column2, column3);
        tableView.getColumns().addAll(fNameTable, lNameTable, ageTable);
        tableView.setEditable(true);
//        tableView.set


        // Adds the addbutton and creates a person with the chosen name/age.
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 1, 3);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                obList.add(new Person(fNameInput.getText(), lNameInput.getText(), ageInput.getText()));
                aList.forEach(e-> System.out.println(e.getFirstName()));
                System.out.println(aList.size());
                System.out.println(aList.size());
                tableView.setItems(obList);
                tableView.refresh();
                fNameInput.clear();
                lNameInput.clear();
                ageInput.clear();


            }
        });

        //Button to load from XML
        Button xmlButton = new Button("Load XML");
        GridPane.setConstraints(xmlButton, 0, 3);
        xmlButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {

                try {

                    bList = (ArrayList<Person>) XmlEncoder.read();
                    obList.addAll(bList);
                    tableView.setItems(obList);
                    tableView.refresh();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Ingen fil existerar");
                }
            }
        });

        //Add everthing to gridpane.

        gridpane.add(tableView, 0, 4, 3, 2);
        gridpane.getChildren().addAll(fNameInput, addButton, fNameLabel, lNameInput, lNameLabel, ageLabel, ageInput, xmlButton);

        //Runs write from xmlencoder class and saves to XML when user exits program.
    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.out.println("Du stängde");

           if(obList.size() != 0) {

               XmlEncoder.write(aList);
           }
            Platform.exit();
            System.exit(0);

        }
    });
    }

    public static void main(String[] args) {
        launch(args);
    }
}