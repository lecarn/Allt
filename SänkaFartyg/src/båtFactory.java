
public class båtFactory {
	
	public static båt getBåt(båtTyper b,int x,int y,boolean isHorizontal ) {
		båt tempBåt=null;
		switch (b) {
		case Hangarfartyg:
			return new Hangarfartyg().createShip(x, y, isHorizontal);
		case Slagskepp:
			return new Slagskepp().createShip(x,y,isHorizontal);
		case Patrullbåt:
			return new Patrullbåt().createShip(x,y,isHorizontal);
		case Småbåt:
			return new Småbåt().createShip(x,y,isHorizontal);
		}
		
		return tempBåt;
	}
}

