package Invoice;

import java.util.ArrayList;
import java.util.List;

public class Chef {
   private String förnamn;
   private String efternamn;
   private int lön;
   private List<Medarbetare> anställda = new ArrayList<>();

   public Chef(){}
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

    public List<Medarbetare> getAnställda() {
        return anställda;
    }

    public void setAnställda(List<Medarbetare> anställda) {
        this.anställda = anställda;
    }
    public void addAnställd(Medarbetare m){
       anställda.add(m);
    }

    public void print(){
        System.out.println(förnamn+ " "+ efternamn) ;
        System.out.println(lön);


        if (anställda != null) {
            System.out.println("Anställda under "+förnamn+ " är: ");
            for (Medarbetare m : anställda)
                System.out.println(m.getFörnamn() + " " + m.getEfternamn());
        }
    }
}
