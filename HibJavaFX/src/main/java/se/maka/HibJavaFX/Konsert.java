package se.maka.HibJavaFX;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="konsert")
public class Konsert implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="idKonsert",unique = true)
    private int id;
    @Column(name="date", nullable = false)
    private String date;
    @Column(name="artist", nullable = false)
    private String artist;

    @ManyToMany(mappedBy = "konserts")
    private Collection<Personer> personers = new ArrayList<>();

    public Collection<Personer> getPersoners() { return personers; }
    public void setPersoners(Collection<Personer> personers) { this.personers = personers; }

    public void printPersoners(){
        for(Personer p : personers ){
            System.out.println(p.getName() + " " + p.getAge());
        }
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
}
