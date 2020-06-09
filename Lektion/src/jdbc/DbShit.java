package jdbc;

import java.sql.*;
import java.util.Scanner;

public class DbShit {

    static String username = "admin";
    static String password = "admin";
    static String dbConnection = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String format = "%-5s%-30s%-10s\n";
    Scanner scn = new Scanner(System.in);


    DbShit() throws SQLException {
        try {
            conn = DriverManager.getConnection(dbConnection, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from country");

            System.out.println("Ansluten till databasen");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void getFirstTen() throws SQLException {
        rs.beforeFirst();
        System.out.println("First 10 rows: ");
        System.out.println("-----------------");
        while (true) {
            int i = 0;
            for (i = 0; i < 10; i++) {
                rs.next();
                System.out.format(format, rs.getString("code"), rs.getString("name"), rs.getString("population"));
            }
            System.out.println("Jag kommer hit");

        }
    }
    public void getNextTen(){

    }

}
