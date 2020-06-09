package com.com;

import java.util.List;

public class Person {
    String name;
    int personNr;
    List<Adresser> adress;

    Person(){}

    public int getPersonNr() { return personNr; }
    public void setPersonNr(int personNr) { this.personNr = personNr; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Adresser> getAdress() { return adress; }
    public void setAdress(List<Adresser> adress) { this.adress = adress; }
}
