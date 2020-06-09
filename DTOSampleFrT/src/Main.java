import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		Person p=new Person();
		p.setNamn("Fredrik");
		p.setPersonnr("710716");

		Bil b1 = new Bil();
		b1.setBilModel("Volvo XC70");
		b1.setRegNr("ABC 123");
		
		Bil b2 = new Bil();
		b2.setBilModel("Saab 9-5");
		b2.setRegNr("ABC 321");
		
		DTOPersonBilar dto=new DTOPersonBilar();
		dto.setPerson(p);
		List<Bil> bilar = new ArrayList<Bil>();
		bilar.add(b1);
		bilar.add(b2);
		
		dto.setBilar(bilar);
		
		Gson gson= new Gson();
		String json= gson.toJson(dto);
		
		System.out.println(json);
		
		DTOPersonBilar dto2;
		dto2=gson.fromJson(json, DTOPersonBilar.class);
		
		System.out.println(dto2.getPerson().toString());
		
		for (Bil b:dto2.getBilar()) {
			System.out.println(b.toString());
		}
		
	}

}
