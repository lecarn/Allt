import java.util.List;

public class DTOPersonBilar {
	private Person person;
	private List<Bil> bilar;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Bil> getBilar() {
		return bilar;
	}
	public void setBilar(List<Bil> bilar) {
		this.bilar = bilar;
	}
	public DTOPersonBilar() {
	}
	
	
}
