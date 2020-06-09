package com.newthinktank.JEETut3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.*;
import java.util.List;


public class TestSystem {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JEETut3");

    public static void main(String[] args) {
        addCustomer(1, "Sue", "Smith");
        addCustomer(2, "Sam", "Smith");
        addCustomer(3, "Sid", "Smith");
        addCustomer(4, "Sally", "Smith");
        getCustomer(1);
        getCustomers();
        changeFname(1, "Seu");
        deleteCustomer(3);


        ENTITY_MANAGER_FACTORY.close();
    }

    public static void addCustomer(int id, String fname, String lName) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Customer cust = new Customer();
            cust.setId(id);
            cust.setfName(fname);
            cust.setlName(lName);
            em.persist(cust);
            et.commit();
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    public static void getCustomer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Customer c WHERE c.id = :idcustomer";

        TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
        tq.setParameter("idcustomer", id);
        Customer cust = null;
        try {
            cust = tq.getSingleResult();
            System.out.println(cust.getfName() + " " + cust.getlName());
        } catch (NoResultException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public static void getCustomers(){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strquery = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
        TypedQuery<Customer> tq = em.createQuery(strquery, Customer.class);
        List<Customer> custs;
        try {
            custs = tq.getResultList();
            custs.forEach(cust-> System.out.println(cust.getfName() + " "+ cust.getlName()));

        }catch(NoResultException e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public static void changeFname(int id, String fname) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Customer cust = null;
        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Customer.class, id);
            cust.setfName(fname);

            em.persist(cust);
            et.commit();
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    public static void deleteCustomer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Customer cust = null;
        try {
            et = em.getTransaction();
            et.begin();
            cust = em.find(Customer.class, id);
            em.remove(cust);
            em.persist(cust);
            et.commit();
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
}
