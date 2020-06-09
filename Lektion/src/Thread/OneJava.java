package Thread;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class OneJava {


    private static Object lock = new Object();

    private static Queue buffer;
    private static int count;
    private static String name;
    private static String wannaDo;
    private static Thread tName;


    static class Producer {

        Producer(){}
        static void produce() {
            synchronized (lock) {
                if (buffer.size() > 150) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Adding name: "+name);
                buffer.add(name);
                lock.notify();
            }
        }
    }


    static class Consumer {

        Consumer(){};
        void consume() {
            synchronized (lock) {
                if (buffer.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else
                System.out.println("Consuming: "+buffer.poll());
                lock.notify();
            }
        }
    }



    public static void main(String[]args) throws InterruptedException {

        buffer = new PriorityQueue();
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();




        while(true){
            System.out.println("1 = produce, 2 = consume");
            Scanner scn = new Scanner(System.in);
            wannaDo = scn.nextLine();

            switch(wannaDo){
                case "1":
                    System.out.println("Whats your name");
                    name = scn.nextLine();

                   Thread test = new Thread(){
                        public void run(){

                            producer.produce();
                        }
                    };
                    test.start();
                    test.join();
                    break;
                case "2":
                    System.out.println("Consuming");
                    new Thread(){
                        public void run(){
                            consumer.consume();
                        }
                    }.start();
                    break;
                default:
                    System.exit(0);
            }

        }

    }
}


