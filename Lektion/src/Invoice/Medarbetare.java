package Invoice;

public class Medarbetare {
    String förnamn;
    String efternamn;
    int lön;

    Medarbetare(){}
    public String getFörnamn() {
        return förnamn;
    }

    public void setFörnamn(String förnamn) {
        this.förnamn = förnamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public int getLön() {
        return lön;
    }

    public void setLön(int lön) {
        this.lön = lön;
    }
    public void print(){
        System.out.println(förnamn+ " "+ efternamn);
        System.out.println(lön);
    }
}
