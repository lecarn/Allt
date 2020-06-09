import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Person jonathanHarr = new Person(1, "Jonathan Harr");
    jonathanHarr.isNowMarried();
    System.out.println("Is Jonathan Married? " + jonathanHarr.isMarried());
    jonathanHarr.isNowDivorced();
    System.out.println("Is Jonathan Married? " + jonathanHarr.isMarried());

    // Här skapar vi en lista för alla som ska jobba på McDonalds
    List<Person> mcDonaldsPersonList = new ArrayList<>();
    // Här lägger vi till mig Jonathan på mcDonalds listan.
    mcDonaldsPersonList.add(jonathanHarr);

    // Här skapar vi företaget McDonalds och slänger in listan med dess anställda.
    Company mcDonalds = new Company("McDonalds", mcDonaldsPersonList);
    jonathanHarr.setCompany(mcDonalds);

    System.out.println("Where does Jonathan work? " + jonathanHarr.getCompany().getCompanyName());

    Person erikAhlin = new Person(2,"Erik Ahlin");
    Person johanAstrom = new Person(3, "Johan Astrom");

    // Här skapar vi en NY lista för alla personer som ska jobba på Xlent
    List<Person> xlentsPersonList = new ArrayList<>();
    // Här skapar vi företaget Xlent, där listan av anställda (Johan och Erik) slängs in.
    Company xLent = new Company("Xlent", xlentsPersonList);

    System.out.println("Let's loop through McDonalds person list.");
    // Här loopar vi igenom listan med anställda på McDonalds, vilket kommer visa sig vara 1. (Jonathan)
    // Observera att vi använder objektet ArrayList, som finns i objektet Company.
    // Ett väldigt vanligt sätt att nyttja objektorienteringen
    for (int i = 0; i < mcDonalds.getPersonList().size(); i++) {
      System.out.println(mcDonalds.getCompanyName() + " has worker: " + mcDonalds.getPersonList().get(i).getFullName());
    }

    System.out.println("Let's loop through Xlent");
    // Här loopar vi igenom listan med anställda hos Xlent.
    for (int i = 0; i < xLent.getPersonList().size(); i ++) {
      System.out.println(xLent.getCompanyName() + " has worker: " + xLent.getPersonList().get(i).getFullName());
    }

    System.out.println("Let's loop through McDonalds one last time.");
    // Ett annat sätt att loopa igenom listan är med en Enhanced For Loop, som fungerar
    // med ArrayList objektet.
    for (Person p : mcDonalds.getPersonList()) {
      System.out.println("McDonalds in the enhanced for loop: " + p.getFullName());
      
      System.out.println("Detta �r min skittest."+ mcDonalds.getPersonList().get(0).getId());
      
    }
  }
}
