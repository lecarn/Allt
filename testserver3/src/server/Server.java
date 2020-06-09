package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket serverSocket;


    public static void main(String[] args) throws IOException {
        //Starting server through start and creating "ServerSkit" object that stores variables.
        start();
        ServerSkit s = new ServerSkit();
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println(socket.toString() + "accepted at " + System.currentTimeMillis());
                Socket finalSocket = socket;
                int queue = 0;
                new Thread(){
                    public void run(){
                        System.out.println("Another request on server.");
                        try{
                            InputStream input = finalSocket.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                            OutputStream output = finalSocket.getOutputStream();
                            PrintWriter writer = new PrintWriter(output, true);
                            int queue;
                            int served;

                            String inc = "";
                            String out = "";
                            int intInc =  1;


                            //Case to decide if number taken or person being served.
                            for (inc = reader.readLine(); inc != null; inc = reader.readLine()) {

                                System.out.println("Tog emot: "+inc);
                                intInc = Integer.parseInt(inc);

                                queue = s.getQueue();
                                served = s.getServed();
                                switch(intInc) {
                                    case 1:
                                        queue = s.getQueue();
                                        queue++;
                                        s.setQueue(queue);
                                        writer.println(queue);
                                        writer.println(served);
                                        break;
                                    case 2:
                                        writer.println(queue);
                                        writer.println(served);
                                        System.out.println("Gjorde case 2");
                                        break;
                                    case 3:
                                        served = s.getServed();
                                        served++;
                                        s.setServed(served);
                                        writer.println(queue);
                                        writer.println(served);
                                        System.out.println("Gjorde case 3");
                                        break;
                                    default:
                                        System.out.println("Error!");
                                }
                                System.out.println("Väntar på ny skit");
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                            System.out.println("Client disconnected");
                        }
                    }
                }.start();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

    //starting serversocket.
    private static void start() throws IOException {

        serverSocket = new ServerSocket(8000);

    }


}//class

