package JavaMultithreading;

public class NotifyWaitNotifyAll {

    private static final Object lock = new Object(); // object used as monitor for synchronization
    private static boolean condition = false; // shared condition variable

    public static void main(String[] args) throws InterruptedException {

        // Consumer Thread
        Thread consumerThread = new Thread(() -> {
            synchronized (lock){
                while(!condition){ // wait until condition is true
                    try{
                        System.out.println("Waiting");
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer: Resource Consumed");
            }
        });

        // Producer Thread
        Thread producerThread = new Thread(() -> {
            System.out.println("Producer: Resource Produced");

            synchronized (lock){
                condition = true;
                lock.notify();
            }
        });
        consumerThread.start();
        producerThread.start();
    }

}
