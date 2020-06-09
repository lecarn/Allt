package se.maka.HibJavaFX;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="konsert_personer")
public class Konsert_Personer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="idKonsert",unique = true)
    private int id;

    @Column(name="idPersoner", nullable = false)
    private int idPersoner;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdPersoner() { return idPersoner; }
    public void setIdPersoner(int idPersoner) { this.idPersoner = idPersoner; }


}
