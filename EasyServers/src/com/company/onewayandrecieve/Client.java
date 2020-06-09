package com.company.onewayandrecieve;

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
    try (Socket socket = new Socket("localhost", 8000)) {

      OutputStream output = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(output, true);
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

//     writer.println("Joined!");
      String text = "";
      while (!text.equals("quit")) {
        Scanner sc = new Scanner(System.in);

        text = sc.nextLine();

        writer.println(text);

        String message = reader.readLine();
        System.out.println(message);
      }

//      do {
//        text = sc.next();
//        writer.println(text);
//        InputStream input = socket.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//
//        String message = reader.readLine();
//
//        System.out.println(message);
//      } while (!text.equals("bye"));
      socket.close();

    } catch (UnknownHostException e) {
      System.out.println("Server not found: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("I/O error: " + e.getMessage());
    }
  }

}
