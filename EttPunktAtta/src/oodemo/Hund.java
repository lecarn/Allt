package oodemo;

public class Hund extends Husdjur {
	


	public Hund(String namn, String ras) {
		super(namn, ras);
	}
	
	
	public String taNamn() {
		return namn;
	}
	
	public String taRas() {
		return ras;
	}
}
