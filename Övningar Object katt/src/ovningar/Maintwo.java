package ovningar;

public class Maintwo {

	public static void main(String[] args) {
		Matte gärtrud = new Matte("Gärtrud");
		Katt jerker = new Katt("Jerker", "Strorfräsare");
		//Skapar matte & katt
		jerker.setMatte(gärtrud);
		gärtrud.setKatt(jerker);
		//Sätter relationerna mellan katt/matte
		
		System.out.println(jerker.getName() + " har matte " + jerker.getMatte().getName());
		System.out.println(jerker.getMatte().getName() + " har katten " +  jerker.getMatte().getKatt().getName());
		//Första sout printar katt + hans matte. 
		//Andra raden printar matte och hennes katt.(krånglade till för skojjskull det med att göra de jobbigt och ta katt-> hämta matte-> hämta katt-> hämta namn)
		

	}

}
