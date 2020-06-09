package application;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
	private int ms = 0;
	private int s = 0;
	private int m = 0;

	
	Time(){}
	
	public void count() {
		ms++;
		if(ms == 1000) {
			s++;
			ms = 0;
		}
		if(s == 60) {
			m++;
			s = 0;
		}
		
	}
	public String getMs() {
		String sMS = Integer.toString(ms);
		return sMS;
	}
	public String getM() {
		String sM = Integer.toString(m);
		return sM;
	}
	public String getS() {
		String sS = Integer.toString(s);
		return sS;
	}
}

