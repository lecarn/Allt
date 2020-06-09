package com.com;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MongoDB {

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    DB database = mongoClient.getDB("marcus");
    DBCollection collection = database.getCollection("test");

    Scanner scn = new Scanner(System.in);
    Person person = new Person();
    int nmbAdress;
    Adresser tempAdresser = new Adresser();
    List<Adresser> adress = new ArrayList<>();
    List<Integer> postnr = new ArrayList<>();

    MongoDB(){}

    public void create(){
        System.out.println("Vilket namn?");
        person.setName(scn.nextLine());
        System.out.println("Vilket personnummer?");
        person.setPersonNr(scn.nextInt());
        System.out.println("Hur många adresser vill du lägga till?");
        nmbAdress = scn.nextInt();
        for(int i = 0; i < nmbAdress; i++){
            System.out.println("Ange adress");
            scn.next();
            tempAdresser.setAdress(scn.nextLine());
            System.out.println("Ange ort");
            tempAdresser.setOrt(scn.nextLine());
            System.out.println("Ange postnr");
            tempAdresser.setPostnr(scn.nextInt());
            adress.add(tempAdresser);
        }
        person.setAdress(adress);
        //Converting a custom class(Person) to BasicDBObject
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(person));
        collection.insert(obj);
    }

    public void show(){
        DBCursor cursor = collection.find();
        while(cursor.hasNext()){
            Object temp = cursor.next();
            System.out.println(temp.toString());
        }
    }

    public void edit(){
        System.out.println("Ange id för person du vill editera.");
        int whereName = scn.nextInt();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("personNr", whereName);
        DBCursor whereCursor = collection.find(whereQuery);
        while(whereCursor.hasNext()) {
            DBObject whereObj = whereCursor.next();
            Person wherePerson = (new Gson()).fromJson(whereObj.toString(), Person.class);
            System.out.println(whereObj);
            System.out.println(wherePerson.getName());
        }
    }


    public void editer(){
        System.out.println("-----------------------------");
        System.out.println("Gör ett val");
        System.out.println("1, För att ändra namn");
        System.out.println("2, För att ändra personNr");
        System.out.println("3, För att ta bort");
        System.out.println("4, För att exit");
        System.out.println("-----------------------------");
        int editChoice = scn.nextInt();



    }
}
