package com.com;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println("Hello World");
        Chooser chooser = new Chooser();

        chooser.Choose();

        System.out.println("Goodbye World");
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
//        DB database = mongoClient.getDB("marcus");
//        DBCollection collection = database.getCollection("test");
//        List<Integer> postnr = new ArrayList<Integer>(){{
//            add(82400);
//            add(82462);
//        }};
//        postnr.add(12345);
//        DBObject person = new BasicDBObject("_id", 2)
//                .append("person", "Fredrik Terent")
//                .append("adress", "Sörviksta 254")
//                .append("postnr", postnr);
//        collection.insert(person);
//        System.out.println(collection.getCount());

//        DBObject person = new BasicDBObject();

//        Object temp = collection.findOne(1);
//        System.out.println(temp.toString());
//
//
    }
}


