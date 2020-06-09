
public class main {
	
	static char[][] spelPlan= new char[10][10];
	
	
	
	public static void main(String[] args) {
		
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				spelPlan[x][y]='.';
			}
			System.out.println();
		}
		
		båt b1= båtFactory.getBåt(båtTyper.Hangarfartyg, 2, 2, true);
		System.out.println("Båt 1 skapades " + b1.toString());
		
		båt b2= båtFactory.getBåt(båtTyper.Slagskepp, 8, 1, false);
		System.out.println("Båt 2 skapades " + b2.toString());

		båt b3= båtFactory.getBåt(båtTyper.Patrullbåt, 9, 7, false);
		System.out.println("Båt 3 skapades " + b2.toString());

		båt b4= båtFactory.getBåt(båtTyper.Småbåt, 1, 1, true);
		System.out.println("Båt 3 skapades " + b2.toString());
				
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				System.out.print(spelPlan[x][y]);
			}
			System.out.println();
		}
	}

}
