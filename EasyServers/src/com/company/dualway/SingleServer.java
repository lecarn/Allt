package com.company.dualway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8000)) {
      System.out.println("Listenning on Port 8000");

      Socket socket = serverSocket.accept();
      System.out.println("New Client is in");

      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      OutputStream output = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(output, true);

      String incommingMessage = "";
      String sentMessage = "";

      while (!incommingMessage.equals("quit")) {
        incommingMessage = reader.readLine();
        System.out.println(incommingMessage);
        System.out.print("Send a reply:");

        Scanner sc = new Scanner(System.in);
        sentMessage = sc.nextLine();

        writer.println(sentMessage);
        System.out.println("Await clients response..");
      }
      socket.close();

    } catch (IOException e) {
      System.out.println("Server Exception " + e.getMessage());
      e.printStackTrace();
    }
  }

}