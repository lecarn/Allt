package ovningar;

import java.util.List;

public class Matte	{
	String name = "";
	Katt katt;


	Matte (){}

	Matte (String incName){
		this.name = incName;
	}
	
	
	public void setName(String incName) {
		this.name = incName;
	}
	public String getName() {
		return name;
	}
	
	public void setKatt(Katt incKatt) {
		this.katt = incKatt;
	}
	
	public Katt getKatt() {
		return katt;
	}

}
