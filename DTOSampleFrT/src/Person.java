
public class Person {
private String Namn;
private String Personnr;
public String getNamn() {
	return Namn;
}
public void setNamn(String namn) {
	Namn = namn;
}
public String getPersonnr() {
	return Personnr;
}
public void setPersonnr(String personnr) {
	Personnr = personnr;
}
public Person() {
	}
@Override
public String toString() {
	return "Person [Namn=" + Namn + ", Personnr=" + Personnr + "]";
}



}
