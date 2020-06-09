package se.maka.HibJavaFX;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="personer")
public class Personer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="idpersoner",unique = true)
    private int id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="age", nullable = false)
    private int age;

    @ManyToMany
    @JoinTable(name="konsert_personer", joinColumns = @JoinColumn(name = "idpersoner"),
    inverseJoinColumns = @JoinColumn(name="idkonsert")
    )
    private Collection<Konsert> konserts = new ArrayList<>();

    public Collection<Konsert> getKonserts() { return konserts; }
    public void setKonserts(Collection<Konsert> konserts) { this.konserts = konserts; }

    public int getId() { return id; }
    public void setId(int id) {
        this.id= id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


}
