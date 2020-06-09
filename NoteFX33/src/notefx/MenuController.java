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
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	@FXML
	private MenuBar menuBar;

	@FXML
	private TextArea textArea;

	@FXML
	private MenuItem saveFileAs, saveFile, fileNew, fileOpen, exitCmd, copyText, cutText, pasteText;

	private File fileDir = null;
	private File file = null;

	/**
	 * Klass f�r att styra om "open" eller "save as" skall �ppnas
	 * 
	 * @author nilin
	 */
	static class Dialog {
		static boolean open = true;
		static boolean saveas = false;
	}

	/**
	 * Hanterar h�ndelsen n�r skickas "About" i menu item. H�ndelsen
	 * specificeras/kopplas i FXML
	 * 
	 * @param event Event on "About" menu item.
	 */
	@FXML
	private void handleAboutAction(final ActionEvent event) {
		provideAboutFunctionality();
	}

	@FXML
	private void handleNewAction(final ActionEvent event) {
		provideNewFunctionality();
	}

	@FXML
	private void handleCutAction(final ActionEvent event) {
		provideCutFunctionality();
	}

	@FXML
	private void handleExitAction(final ActionEvent event) {

		provideExitFunctionality();
	}

	@FXML
	private void handlePasteAction(final ActionEvent event) {

		providePasteFunctionality();
	}

	@FXML
	private void handleCopyAction(final ActionEvent event) {

		provideCopyFunctionality();
	}

	@FXML
	private void handleUndoAction(final ActionEvent event) {
		provideUndoFunctionality();
	}

	@FXML
	private void handleRedoAction(final ActionEvent event) {
		provideRedoFunctionality();
	}

	@FXML
	private void handleOpenAction(final ActionEvent event) {

		provideOpenFunctionality();
	}

	@FXML
	private void handleSaveAction(final ActionEvent event) {
		provideSaveFunctionality();
	}

	@FXML
	private void handleSaveAsAction(final ActionEvent event) {
		File filename = provideOpenSaveFileDialog(Dialog.saveas);
		if (!filename.getPath().isEmpty()) {
			provideSaveFunctionality();
		}
	}

	/**
	 * Funktion som utf�r det som skall utf�ras n�r About v�ljs eller CTRL-A trycks
	 * p� tangentbordet
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

	private File provideSaveFunctionality() {

		File filenameAndPath = null;
		if (file == null) {
			filenameAndPath = provideOpenSaveFileDialog(Dialog.saveas); // om ny fil �ppna saveas dialog
		} else {
			filenameAndPath = file; // filnamn och path
		}

		if (filenameAndPath != null && !filenameAndPath.getPath().isEmpty()) { // kontrollera att fil valts.
			try {
				FileWriter out = new FileWriter(filenameAndPath);

				String s = textArea.getText();

				out.write(s);
				out.close();
			} catch (IOException e) {
				System.out.println("Lyckades inte spara.");
			}
		}
		return filenameAndPath;
	}

	/**
	 * Visar dialog f�ratt v�lja fil och sedan �ppnar den.
	 */
	private void provideOpenFunctionality() {

		File filenameAndPath = provideOpenSaveFileDialog(Dialog.open);

		if (filenameAndPath != null && !filenameAndPath.getPath().isEmpty()) { // kontrollera att fil valts.
			String newLine = "\n";
			BufferedReader objReader = null;
			try {
				String strCurrentLine;
				objReader = new BufferedReader(new FileReader(filenameAndPath.getPath()));
				textArea.clear();
				while ((strCurrentLine = objReader.readLine()) != null) {
					textArea.appendText(strCurrentLine + newLine);
				}
			} catch (IOException e) {
				System.out.println("fel filv�g");
			}
		}
	}

	/**
	 * Dialog f�r att v�lja vilken fil som skall �ppnas. true visar open dialogen
	 * och false save as dialog
	 * 
	 * @param Boolean controlls what dialog to show
	 * @return String that contains filenamn with full path
	 */
	private File provideOpenSaveFileDialog(Boolean open) {
		FileChooser fileChooser = new FileChooser();

		fileChooser.setInitialDirectory(fileDir);

		// S�tter extension filter,bara *.txt filer
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter);

		if (file == null) {
			fileChooser.setInitialFileName("*.txt");
		} else {
			fileChooser.setInitialFileName(file.getName());
		}

		if (open) {
			fileChooser.setTitle("Open text file");
			file = fileChooser.showOpenDialog(fileOpen.getParentPopup().getScene().getWindow());
		} else {
			fileChooser.setTitle("Save file as...");

			File t = fileChooser.showSaveDialog(saveFileAs.getParentPopup().getScene().getWindow());
			if (t != null) {
				file = t;
			}
		}

		if (file != null) {
			fileDir = file.getParentFile(); // sparar undan aktuell katalog
		}
		return file;
	}

	private void provideNewFunctionality() {
		textArea.clear();
	}

	private void provideCopyFunctionality() {
		textArea.copy();
	}

	private void provideCutFunctionality() {
		textArea.cut();
	}

	private void providePasteFunctionality() {
		textArea.paste();
	}

	private void provideUndoFunctionality() {
		textArea.undo();
	}

	private void provideRedoFunctionality() {
		textArea.redo();
	}

	private void provideExitFunctionality() {

		ButtonType buttonSave = new ButtonType("Save");
		ButtonType buttonYes = new ButtonType("Exit");
		ButtonType buttonSaveExit = new ButtonType("Save and Exit");

		Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to exit", ButtonType.CANCEL, buttonSave,
				buttonSaveExit, buttonYes);
		alert.setTitle("Exit");
		alert.setHeaderText("");

		alert.showAndWait();

		if (alert.getResult() == buttonSave) {
			provideSaveFunctionality();
		} else if (alert.getResult() == buttonYes
				|| (alert.getResult() == buttonSaveExit && provideSaveFunctionality() != null)) {
			Platform.exit();
			System.exit(0);
		}
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		menuBar.setFocusTraversable(true);

		// Handler to exit the application
		// File-menyn
		exitCmd.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
		saveFileAs.setAccelerator(KeyCombination.keyCombination("CTRL+ALT+S"));
		fileNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		fileOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		saveFile.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
	}
}