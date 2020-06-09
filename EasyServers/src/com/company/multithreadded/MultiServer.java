package com.company.multithreadded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiServer {

  private static ServerSocket serverSocket;

  public static void main(String[] args) throws IOException {
    openServerStart();
    while (true) {
      Socket socket = null;
      try {
        socket = serverSocket.accept();
        System.out.println(socket.toString() + " accepted at " + System.currentTimeMillis());
        Socket finalSocket = socket;
        new Thread() {
          public void run() {
            System.out.println("Yet another Client is in!");
            try {
              InputStream input = finalSocket.getInputStream();
              BufferedReader reader = new BufferedReader(new InputStreamReader(input));

              OutputStream output = finalSocket.getOutputStream();
              PrintWriter writer = new PrintWriter(output, true);

              String incommingMessage = "";
              String sentMessage = "";

              while (!incommingMessage.equals("quit")) {
                incommingMessage = reader.readLine();
                System.out.println("Recieved: " + incommingMessage);

                writer.println(incommingMessage);
                System.out.println("Await clients response..");
              }
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  private static void openServerStart() throws IOException {
    serverSocket = new ServerSocket(8000);
  }

}
