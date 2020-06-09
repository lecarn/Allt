package Invoice;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Chef chefen = new Chef();
        chefen.setFörnamn("Bob");
        chefen.setEfternamn("Builder");
        chefen.setLön(50000);
        chefen.print();

        Löneperson chefenLP = Adapter.konverteraChefTillLöneperson(chefen);
        chefenLP.print();

        Medarbetare slaven = new Medarbetare();
        slaven.setFörnamn("Slave");
        slaven.setEfternamn("No name");
        slaven.setLön(0);
        slaven.print();
        chefen.addAnställd(slaven);

        Löneperson slavenLP = Adapter.konverteraMedarbetareTillLöneperson(slaven);
        slavenLP.print();
        chefen.print();

    }
}
