package application;

public class TimeTable {

	private String date = null;
	private String time = null;
	
	public TimeTable() {}
	
	public TimeTable(String date, String time) {	
	this.date = date;
	this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
