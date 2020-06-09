package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Main2 {

    static String username = "admin";
    static String password = "admin";
    static String dbConnection = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";


    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(dbConnection, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from film");

            System.out.println("Ansluten till databasen");
            String format = "%-5s%-30s%-10s\n";
            rs.absolute(5);

            Scanner scn = new Scanner(System.in);
            System.out.println("Printing absolut 5 ");
            System.out.format(format, rs.getString("title"), rs.getString("description"), rs.getString("release_year"));

            rs.updateString("release_year", "k2005");
            rs.updateRow();
            System.out.format(format, rs.getString("title"), rs.getString("description"), rs.getString("release_year"));

//            rs.moveToInsertRow();
//            rs.updateString("name", "Lander down upper");
//            rs.updateString("code", "KoK");
//            rs.insertRow();
//            System.out.println("Lagt in");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}