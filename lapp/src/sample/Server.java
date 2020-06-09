package sample;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

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
                        System.out.println("Client connected");
                        try {
                            InputStream input = finalSocket.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                            OutputStream output = finalSocket.getOutputStream();
                            PrintWriter writer = new PrintWriter(output, true);




                            int queue = 0;
                            String incomingMessage = "";
                            String sentMessage = "";


                            while (!incomingMessage.equals("quit")) {
                                incomingMessage = reader.readLine();
                                System.out.println("Recieved: " + incomingMessage);


                                System.out.println("Await clients response..");
                                queue++;
                                String queueString = Integer.toString(queue);
                                writer.println(queueString);

                            }
                        } catch (Exception e) {
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