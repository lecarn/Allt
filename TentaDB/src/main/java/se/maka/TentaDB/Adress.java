package se.maka.TentaDB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="adress")
public class Adress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_adress", unique = true)
    private int id;
    @Column(name = "street_name", nullable = true)
    private String streetName;
    @Column(name = "postal_code", nullable = true)
    private int postalCode;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public int getPostalCode() { return postalCode; }
    public void setPostalCode(int postalCode) { this.postalCode = postalCode; }




}



