package com.company.multithreadded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost" , 8000)) {

      OutputStream output = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(output, true);
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      String text = "";
      while (!text.equals("quit")) {
        System.out.print("Insert a message to send:");
        Scanner sc = new Scanner(System.in);

//        text = sc.nextLine();

        writer.println("hejsan");

        System.out.println("Await your reply..");
        String message = reader.readLine();
        System.out.println(message);
      }
    } catch (UnknownHostException e) {
      System.out.println("Server not found: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("I/O error: " + e.getMessage());
    }
  }

}
