
package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.text.TableView.TableRow;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainPanelController  {
	@FXML	private ResourceBundle resources;
	@FXML	private URL location;
	@FXML	private Text timerText;
	@FXML	private Button startButton;
	@FXML	private Button testButton;
	@FXML	private TableColumn<String, TimeTable> timeTable;
	@FXML	private TableColumn<String, TimeTable> dateTable;
	@FXML   private TextArea resultText;
	boolean again = false;
	Timeline timeline;
	long currentTime = 0;
	long endTime = System.currentTimeMillis();
	LocalDateTime check = LocalDateTime.now();
	DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	
	
	
	DateFormat timeFormat = new SimpleDateFormat("mm:ss:SSS ");

	public void start() {



		timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
			currentTime = System.currentTimeMillis() - endTime;

			if (currentTime < 0) {
				timerText.setText(timeFormat.format(0));
			} else {
				timerText.setText(timeFormat.format(currentTime));
			}
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		again = true;

	}

	public void stop() {
		timeline.pause();
		again = false;
	}

	@FXML
	public void onStartButton() {

		
		if (again == false) {
			System.out.println("OnstartButtons");
			start();
		} else if (again == true) {
			stop();
			resultText.appendText("\n"+check.format(dayFormat).toString()+ "                                         "+ timerText.getText() );
		}
	}
    
}
	