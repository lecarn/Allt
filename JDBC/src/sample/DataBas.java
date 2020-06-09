package sample;

import java.sql.*;
import java.sql.ResultSet;

public class DataBas {

    static String username = "javauser";
    static String password = "java";
    static String dbConnection = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    ResultSet rsActor;
    PreparedStatement pstmt;
    String title;
    String description;
    String releaseYear;
    String tempReleaseYear;
    String rentalRate;
    String length;
    String replacementCost;
    String rating;
    String specialFeatures;
    StringBuilder actors = new StringBuilder();
    String actorTest;
    int id = 1;


    DataBas() throws SQLException {
        try {
            conn = DriverManager.getConnection(dbConnection, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select film_id, title, description, release_year, rental_rate, length, replacement_cost, rating, special_features from film;");
            PreparedStatement pstmt = conn.prepareStatement("select * from actor a inner join film_actor fa on a.actor_id = a.actor_id inner join film f on f.film_id = fa.film_id Where f.film_id like ?");


            System.out.println("Ansluten till databasen");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void saveFilm(String incTitle, String incDescription, String incReleaseYear, String incRentalRate,
                         String incLength, String incReplacementCost, String incRating, String incSpecialFeatures) throws SQLException {

        rs.absolute(id);
        rs.updateString("title", incTitle);
        rs.updateString("description", incDescription);
        rs.updateString("release_year", incReleaseYear);
        rs.updateString("rental_rate", incRentalRate);
        rs.updateString("length", incLength);
        rs.updateString("replacement_cost", incReplacementCost);
        rs.updateString("rating", incRating);
        rs.updateString("special_features", incSpecialFeatures);
        rs.updateRow();
    }

    public String getActor() throws SQLException {
        System.out.println(id);
        actors.setLength(0);
        rsActor =stmt.executeQuery("SELECT first_name,last_name from actor INNER JOIN film_actor on film_actor.actor_id=actor.actor_id INNER JOIN film on  film.film_id = film_actor.film_id   WHERE film.film_id=" + id);
        while(rsActor.next()){
            actors.append(rsActor.getString("first_name")+"\n");
        }


        System.out.println(actors);


        return actors.toString();
    }

    public void nextFilm() throws SQLException {
        if(id < 1000) {
            rs.next();
            setVar();
        }
    }

    public void previousFilm() throws SQLException {
        if(id >1) {
            rs.previous();
            setVar();
        }else
            System.out.println("out of bounds");
    }

    public void lastFilm() throws SQLException {
        rs.last();
        setVar();
    }
    public void firstFilm() throws SQLException {
        rs.first();
       setVar();
    }

    public void setVar() throws SQLException {
        id = rs.getInt("film_id");
        System.out.println(id);
        title = rs.getString("title");
        description = rs.getString("description");
        tempReleaseYear = rs.getString("release_year");
        releaseYear = tempReleaseYear.substring(0,4);
        rentalRate = rs.getString("rental_rate");
        length = rs.getString("length");
        replacementCost = rs.getString("replacement_cost");
        rating = rs.getString("rating");
        specialFeatures = rs.getString("special_features");

        System.out.println(title + description + releaseYear + rentalRate + length + replacementCost + rating + specialFeatures);
    }

    public String getTitle(){ return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getReleaseYear() { return releaseYear; }
    public void setReleaseYear(String releaseYear) { this.releaseYear = releaseYear; }
    public String getRentalRate() { return rentalRate; }
    public void setRentalRate(String rentalRate) { this.rentalRate = rentalRate; }
    public String getLength() { return length; }
    public void setLength(String length) { this.length = length; }
    public String getReplacementCost() { return replacementCost; }
    public void setReplacementCost(String replacementCost) { this.replacementCost = replacementCost; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
    public String getSpecialFeatures() { return specialFeatures; }
    public void setSpecialFeatures(String specialFeatures) { this.specialFeatures = specialFeatures; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
