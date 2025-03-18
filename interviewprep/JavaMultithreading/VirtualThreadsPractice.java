package JavaMultithreading;


import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

/*
Unlike traditional OS threads(kernel threads), virtual threads are managed directly by JVM,
can be created and scheduled more efficiently.
They exist to provide scale (higher throughput), not speed (low latency)

 */
public class VirtualThreadsPractice {
    public static void main(String[] args) throws InterruptedException {

        // Platform thread example
        List<Thread> listThreads = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();

        final int numberOfThreads = 1000000;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // simulate a task
                System.out.println("Fetching data from API");
                try{
                    Thread.sleep(100000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Data fetched from API");
            }
        };

        /*for (int i=0; i<numberOfThreads;i++){
            Thread thread = new Thread(runnable);
            // CPU capacity and memory
            // Platform threads typically have a large thread stack and other resources,
            // so u might get error after sometime while creating threads
            thread.setDaemon(true);
            thread.setName("Thread"+i);
            thread.start();
            String str = String.format("Thread number %s ",i);
            System.out.println(str);
            listThreads.add(thread);
        }

        for(Thread t: listThreads){
            t.join();
            System.out.println(t.getName() +" is completed");
        }*/
// ******************************************************************

        // will use VirtualThreads instead of platform threads

        for (int i=0; i<numberOfThreads;i++){
            Thread thread = Thread.ofVirtual().unstarted(runnable);
            // CPU capacity and memory
            // Platform threads typically have a large thread stack and other resources,
            // so u might get error after sometime while creating threads
//            thread.setDaemon(true);
            thread.setName("VirtualThread"+i);
            thread.start();
            String str = String.format("Thread number %s ",i);
            System.out.println(str);
            listThreads.add(thread);
        }

        for(Thread t: listThreads){
            t.join();
            System.out.println(t.getName() +" is completed");
        }



    }
}
