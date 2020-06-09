//package Thread;
//
//public class Consumer {
//
//    Consumer(){};
//    void consume() {
//        synchronized (lock) {
//            if (buffer.isEmpty()) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(name);
//            System.out.println(buffer.poll());
//            lock.notify();
//        }
//    }
//}