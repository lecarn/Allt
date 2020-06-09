package thorntail.thorntailtest.rest;

public class Slagskepp implements iBåtar {

	@Override
	public båt createShip(int x, int y, boolean isHorizontal) {
	final båt tempBåt;
	final boolean success;
	if (isHorizontal) {
		System.out.println("X  -  Y");
		for (int i = x; i < x+4; i++) {
			System.out.println(i + " - " + y );
			
			if (Skapa.spelPlan[i][y] == 'X') {
				break;
			}
		}
		success=true;
	}			
	else {
		System.out.println("X  -  Y");
		for (int i = y; i < y+4; i++) {
			System.out.println(x + " - " + i );
			
			if (Skapa.spelPlan[x][i] == 'X') {
				break;
			}
		}
		success=true;
	}
	if (success) {
		if (isHorizontal) {
			for (int i = x; i < x+4; i++) {
				Skapa.spelPlan[i][y]='X';
			}
		}
		else
		{
			for (int i = y; i < y+4; i++) {
				Skapa.spelPlan[x][i]='X';
			}
		}
	}
	tempBåt = new båt();
	tempBåt.setBåtTyp(båtTyper.Slagskepp);
	tempBåt.setX(x);
	tempBåt.setY(y);
	tempBåt.setHorizontal(isHorizontal);
	return tempBåt;
	}
}
