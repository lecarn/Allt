package ovningar;

import java.util.List;

public class Matte	{
	String name = "";
	List<Hund> hundList;

	Matte (){}

	Matte(String incName, List<Hund> hundList){
		this.name = incName;
		this.hundList = hundList;
	}

	public List<Hund> getHundList(){
		return hundList;
	}
	
	
	public void setName(String incName) {
		this.name = incName;
	}
	public String getName() {
		return name;
	}
	
}
