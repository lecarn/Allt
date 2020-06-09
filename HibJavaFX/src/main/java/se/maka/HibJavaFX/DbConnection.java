package se.maka.HibJavaFX;

import javax.persistence.*;
import java.util.List;

public class DbConnection {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY_PERSONER = Persistence
            .createEntityManagerFactory("HibPersoner");
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY_KONSERT = Persistence
            .createEntityManagerFactory("HibKonsert");
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY_KONSERT_PERSONER = Persistence
            .createEntityManagerFactory("HibKonsert_Personer");

    DbConnection(){}



    public Personer getPerson(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY_PERSONER.createEntityManager();

        // the lowercase c refers to the object
        // :custID is a parameterized query thats value is set below
        String query = "SELECT c FROM Personer c WHERE c.name = :name";

        // Issue the query and get a matching Customer
        TypedQuery<Personer> tq = em.createQuery(query, Personer.class);
        tq.setParameter("name", name);

        Personer pers = null;
        try {
            // Get matching customer object and output
            pers = tq.getSingleResult();
            System.out.println(pers.getName() + " " + pers.getAge());
            return pers;
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public void addPerson(String name, int age) {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY_PERSONER.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer
            Personer pers = new Personer();
            pers.setName(name);
            pers.setAge(age);

            // Save the customer object
            em.persist(pers);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public void getKonsert(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY_KONSERT.createEntityManager();
//        Session session = Hibernateutil.getSessionFactory().openSession();
//        TypedQuery<Konsert> tq = session.createQuery(query, Konsert.class)

        // the lowercase c refers to the object
        // :custID is a parameterized query thats value is set below
        String query = "SELECT c FROM Konsert c WHERE c.id = :idKonsert";

        // Issue the query and get a matching Customer
        TypedQuery<Konsert> tq = em.createQuery(query, Konsert.class);


        tq.setParameter("idKonsert", id);

        Konsert konsert = null;
        try {
            // Get matching customer object and output
            konsert = tq.getSingleResult();
            System.out.println(konsert.getArtist() + " " + konsert.getDate());

            konsert.printPersoners();

        }
        catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public void addKonsert(String artist, String date) {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY_KONSERT.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer
            Konsert konsert = new Konsert();
            konsert.setArtist(artist);
            konsert.setDate(date);

            // Save the customer object
            em.persist(konsert);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public void addKonsert_Personer(int idK, int idP) {

        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY_KONSERT.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer
            Konsert_Personer kp = new Konsert_Personer();
            kp.setId(idK);
            kp.setIdPersoner(idP);

            // Save the customer object
            em.persist(kp);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

}
