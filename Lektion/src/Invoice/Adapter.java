package Invoice;

public class Adapter {

    public static Löneperson konverteraChefTillLöneperson(Chef c){
        Löneperson lp = new Löneperson();
        lp.setNamn(c.getFörnamn()+ " " + c.getEfternamn());
        lp.setLön(c.getLön());
        return lp;
    }
    public static Löneperson konverteraMedarbetareTillLöneperson(Medarbetare m){
        Löneperson lp = new Löneperson();
        lp.setNamn(m.getFörnamn()+ " "+ m.getEfternamn());
        lp.setLön(m.getLön());
        return lp;
    }
}
