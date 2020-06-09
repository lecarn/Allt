package ovningar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Hund> bettanList = new ArrayList<>();
		List<Hund> monicaList = new ArrayList<>();
		Hund loki = new Hund("loki", "huskatt");
		Hund sammy = new Hund("sammy", "bland ras");
		Matte bettan = new Matte("Bettan", bettanList);
		Matte monica = new Matte("Monica", monicaList);
		// L�gger till 2 hundar och 2 matte(aka husse enligt uppgift)
		monicaList.add(sammy);
		monicaList.add(loki);
		bettanList.add(sammy);
		bettanList.add(loki);
		// L�gger till b�da

		loki.show();
		sammy.show();

		loki.setMatte(bettan);
		loki.show();
		sammy.setMatte(bettan);
		System.out.println(sammy.getName() + sammy.getMatte().getName());

		System.out.println("Matte f�r Loki �r " + loki.getMatte().getName());

		for (int i = 0; i < bettan.getHundList().size(); i++) {
			System.out.println(bettan.getName() + " har hunden: " + bettan.getHundList().get(i).getName());
		}

		for (int i = 0; i < monica.getHundList().size(); i++) {
			System.out.println(monica.getName() + " har hunden " + monica.getHundList().get(i).getName()
					+ " som �r av rasen " + monica.getHundList().get(i).getBreed());
		}

	}

}
