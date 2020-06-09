//package Thread;
//
//public class ProducerConsumer {
//    private static Object key = new Object();
//    private static String[] buffer;
//    private static int count;
//
//
//    ProducerConsumer(){}
//
//    public void producer() {
//        synchronized (key) {
//            if(isFull(buffer)) {
//                try {
//                    key.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            buffer[count++] = "hej";
//            key.notifyAll();
//        }
//    }
//
//    public void consumer() {
//        synchronized (key) {
//            if(isEmpty(buffer)) {
//                try {
//                    key.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            buffer[--count] = "";
//            key.notifyAll();
//        }
//    }
//    static boolean isEmpty(String[] buffer) {return count == 0;}
//    static boolean isFull(String[] buffer){ return count == buffer.length;}
//}
