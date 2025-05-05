package JavaMultithreading;

public class ProducerConsumerRevision {

    private static final Object lock = new Object(); // Object used as a monitor for synchronization
    private static boolean condition = false; // Shared condition variable

    public static void main(String[] args) {

        // consumer thread

        Thread consumerThread = new Thread(() ->{
           synchronized (lock){
               while(!condition){
                   try {
                       lock.wait();
                   }catch(InterruptedException e){
                       e.printStackTrace();
                   }
               }
               System.out.println("Consumer: resource consumed");
           }
        });

        Thread producerThread = new Thread(() -> {
            System.out.println("Producer: resource produced");
            synchronized (lock){
                condition=true;
                lock.notify();
            }
        });
        consumerThread.start();
        producerThread.start();
    }
}
