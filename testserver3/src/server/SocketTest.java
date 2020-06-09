package server;

import java.io.*;
import java.net.Socket;

public class SocketTest {
    String queue;
    String served;
    String out;

    SocketTest() {
    }

    //Takes number and sends to server and returns the queue
    public String getQueue(String out) {
        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            writer.println(out);

            queue = reader.readLine();
            served = reader.readLine();
            System.out.println(" queue = " + queue + " served = " + served);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return queue;

    }

    //Takes number and sends to server and returns the served
    public String getServed(String out) {
        try (Socket socket = new Socket("localhost", 8000)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            writer.println(out);

            queue = reader.readLine();
            served = reader.readLine();
            System.out.println(" queue = " + queue + " served = " + served);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return served;

    }
}

