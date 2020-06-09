package se.maka.TentaDB;

import javax.persistence.*;
import java.util.List;


public class App {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("HibAdress");

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


    getAdresses();

        System.out.println( "Goodbye World!" );



    }


    public static void getAdresses() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // the lowercase c refers to the object
        // :custID is a parameterized query thats value is set below
        String strQuery = "SELECT c FROM Adress c WHERE c.id IS NOT NULL";

        // Issue the query and get a matching Customer
        TypedQuery<Adress> tq = em.createQuery(strQuery, Adress.class);
        List<Adress> adresses;
        try {
            // Get matching customer object and output
            adresses = tq.getResultList();
            adresses.forEach(adress->System.out.println(adress.getStreetName() + " " + adress.getPostalCode()));
        }
        catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
