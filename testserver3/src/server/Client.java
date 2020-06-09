package server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {


        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            Scanner scn = new Scanner(System.in);

            String out ="";
            String inc = "";
            String incTwo = "";
            while (!out.equals("quit")){
                System.out.println("What do you want to do?\n 1 to take ticket, 2 to update queue, 3 to serve. ");


                out = scn.nextLine();
                writer.println(out);

                inc = reader.readLine();
                incTwo = reader.readLine();
                System.out.println("inc = "+ inc+ "incTwo = "+ incTwo);

            }


        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}//class
