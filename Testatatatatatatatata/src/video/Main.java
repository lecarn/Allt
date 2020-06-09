package video;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {

		Timer myTimer = new Timer();
		myTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("hello world");
			}
		}, 1);

	}

}
