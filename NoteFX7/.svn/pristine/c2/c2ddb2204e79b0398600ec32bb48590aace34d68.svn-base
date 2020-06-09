package notefx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	@FXML
	private MenuBar menuBar;

	@FXML
	private TextArea textArea;

	@FXML
	private MenuItem fileOpen;

	private File fileDir = null;

	/**
	 * Hanterar händelsen när skickas "About" i menu item. Händelsen
	 * specificeras/kopplas i FXML
	 * 
	 * @param event Event on "About" menu item.
	 */
	@FXML
	private void handleAboutAction(final ActionEvent event) {
		provideAboutFunctionality();
	}

	@FXML
	private void handleExitAction(final ActionEvent event) {

		provideExitFunctionality();
	}

	@FXML
	private void handleOpenAction(final ActionEvent event) {

		provideOpenFunctionality();
	}

	@FXML
	private void handleSaveAction(final ActionEvent event) {

		provideSaveFunctionality();
	}

	/**
	 * Hantera alla input händelser. I detta fall hanteras speciellt tangentbords
	 * tryckningar i detta fall CTRL-A händelse.
	 * 
	 * @param event Input event.
	 */
	@FXML
	private void handleKeyInput(final InputEvent event) {
		if (event instanceof KeyEvent) {
			final KeyEvent keyEvent = (KeyEvent) event;
			// exempel på hur man hanterar CTRL-A
			if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) {
				provideAboutFunctionality();
			}
			if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.E) {
				provideExitFunctionality();
			}
			if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.O) {
				provideOpenFunctionality();
			}
			// Här skall kod för tex CTRL-S (spara skrivas) enligt ovan mönster....
		}
	}

	/**
	 * Funktion som utför det som skall utföras när About väljs eller CTRL-A trycks
	 * på tangentbordet
	 */
	private void provideAboutFunctionality() {
		Alert alert = new Alert(AlertType.INFORMATION);

		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/notepad.png"));

		String javaVersion = System.getProperty("java.version");
		String javafxVersion = System.getProperty("javafx.version");

		alert.setTitle("NoteFX");
		alert.setHeaderText("About NoteFX");
		alert.setContentText("JavaFX " + javafxVersion + "Application\nRunning on Java " + javaVersion + ".");
		alert.show();
	}

	private void provideSaveFunctionality() {

		try (FileWriter out = new FileWriter("notes.txt")) {
			textArea.selectAll();
			String s = textArea.getSelectedText();

			out.write(s);
			out.close();
		}

		catch (IOException e) {
			System.out.println("Lyckades inte spara.");
		}

	}

	/**
	 * Visar dialog föratt välja fil och sedan öppnar den. 
	 */
	private void provideOpenFunctionality() {

		String filenamneAndPath = provideOpenFileDialog();

		if (!filenamneAndPath.isEmpty()) { // kontrollera att fil valts.
			String newLine = "\n";
			BufferedReader objReader = null;
			try {
				String strCurrentLine;
				objReader = new BufferedReader(new FileReader(filenamneAndPath));
				textArea.clear();
				while ((strCurrentLine = objReader.readLine()) != null) {
					textArea.appendText(strCurrentLine + newLine);
				}
			} catch (IOException e) {
				System.out.println("fel filväg");
			}
		}
	}

	/**
	 * Dialog för att välja vilken fil som skall öppnas.
	 * 
	 * @return String that contains filenamn with full path
	 */
	private String provideOpenFileDialog() {
		FileChooser fileChooser = new FileChooser();

		fileChooser.setInitialDirectory(fileDir);

		// Sätter extension filter,bara *.txt filer
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter);

		fileChooser.setTitle("Open text file");
		File file = fileChooser.showOpenDialog(fileOpen.getParentPopup().getScene().getWindow());

		String filenamneAndPath = "";
		if (file != null) {   
			filenamneAndPath = file.getPath();
			fileDir = file.getParentFile();  // sparar undan aktuell katalog
		}
		return filenamneAndPath;
	}

	private void provideExitFunctionality() {
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		menuBar.setFocusTraversable(true);

	}
}