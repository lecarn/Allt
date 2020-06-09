package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static String username = "admin";
    static String password = "admin";
    static String dbConnection  = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";


    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(dbConnection, username, password);
//            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = stmt.executeQuery("select * from country");

            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from country where code = ?");
            System.out.println("Ansluten till databasen");
            String format = "%-5s%-30s%-10s\n";
//            rs.beforeFirst();

            System.out.println("Give country code");
            Scanner scn = new Scanner(System.in);
            pstmt.setString(1, scn.nextLine());

            ResultSet rss = pstmt.executeQuery();

            rss.first();
            System.out.println("Jag kommer hit");
            System.out.format(format, rss.getString("code"), rss.getString("name"), rss.getString("population"));




//            System.out.println("First 10 rows: ");
//
//            while(true){
//                int i = 0;
//                for(i = 0; i < 10; i++) {
//                    rs.next();
////                    System.out.format(format, rs.getString("code"), rs.getString("name"), rs.getString("population"));
////                }
//                    System.out.println("Jag kommer hit");
//                scn.nextLine();
//
//                System.out.println("Men inte hit");
//            }


        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        }



    }
}
