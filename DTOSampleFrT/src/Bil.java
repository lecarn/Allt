
public class Bil {
private String bilModel;
private String regNr;
public String getBilModel() {
	return bilModel;
}
public void setBilModel(String bilModel) {
	this.bilModel = bilModel;
}
public String getRegNr() {
	return regNr;
}
public void setRegNr(String regNr) {
	this.regNr = regNr;
}
public Bil() {
}
@Override
public String toString() {
	return "Bil [bilModel=" + bilModel + ", regNr=" + regNr + "]";
}



}
