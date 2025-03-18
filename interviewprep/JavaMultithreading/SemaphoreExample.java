package JavaMultithreading;


import java.util.concurrent.Semaphore;

/*
purpose of semaphore is to control access ot shared resource or a pool of resources by multiple threads concurrently.
It provides way to limit the number of threads that can access the resource simultaneously

It is a synchronization construct that controls access to a shared resource by using a counter.
If counter > 0 -> access allowed, count == 0 -> access denied
 */
public class SemaphoreExample {

    private static final int NUM_THREADS = 5;
    private static final Semaphore semaphore = new Semaphore(2); // allow only 2 threads to access the resouce

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            System.out.println("Thread 1");
        });

        Thread b = new Thread(() -> {
            System.out.println("Thread 2");
        });
        a.start();
        b.start();
        a.run();
        b.run();



        /*// create and start multiple threads
        for(int i = 0; i<NUM_THREADS;i++){
            Thread thread = new Thread(() -> {
                try{
                    semaphore.acquire(); //acquire permit
                    System.out.println(Thread.currentThread().getName()+" is accessing the resource");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" released the resource");
                    semaphore.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            thread.start();
        }*/

    }
}
