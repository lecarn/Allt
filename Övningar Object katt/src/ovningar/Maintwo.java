package ovningar;

public class Maintwo {

	public static void main(String[] args) {
		Matte g�rtrud = new Matte("G�rtrud");
		Katt jerker = new Katt("Jerker", "Strorfr�sare");
		//Skapar matte & katt
		jerker.setMatte(g�rtrud);
		g�rtrud.setKatt(jerker);
		//S�tter relationerna mellan katt/matte
		
		System.out.println(jerker.getName() + " har matte " + jerker.getMatte().getName());
		System.out.println(jerker.getMatte().getName() + " har katten " +  jerker.getMatte().getKatt().getName());
		//F�rsta sout printar katt + hans matte. 
		//Andra raden printar matte och hennes katt.(kr�nglade till f�r skojjskull det med att g�ra de jobbigt och ta katt-> h�mta matte-> h�mta katt-> h�mta namn)
		

	}

}
