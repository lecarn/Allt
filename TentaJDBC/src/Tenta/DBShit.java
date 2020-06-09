package Tenta;

import java.sql.*;
import java.util.Scanner;

public class DBShit {

    static String username = "javauser";
    static String password = "java";
    static String dbConnection = "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


    DBShit() throws SQLException {
        try {
            conn = DriverManager.getConnection(dbConnection, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


            System.out.println("Ansluten till databasen");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getAll() throws SQLException {
        rs = stmt.executeQuery("select * from user_password");
        rs.beforeFirst();
        System.out.println("All rows: ");
        System.out.println("--------------------");
        while (rs.next()) {
            System.out.println("Username: " + rs.getString("username")+ "\nPassword: " + rs.getString("password")+"\n");

        }
        System.out.println("--------------------");

    }

    public void createUser(String user, String password) throws SQLException {
        String SQL = "INSERT INTO user_password(username, password) "
                + "VALUES(?,?)";

        long id = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user);
            pstmt.setString(2, password);

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}



