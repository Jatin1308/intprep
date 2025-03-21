package JavaMultithreading;

import java.util.concurrent.*;

public class ThreadPoolInExecutorService {

    public static void main(String[] args) {

        BlockingQueue<Runnable> blockingQueue =  new LinkedBlockingQueue<Runnable>(3);

        ExecutorService threadPoolExecutorService = new ThreadPoolExecutor(3,
                                                            5,
                                                            10,
                                                            TimeUnit.SECONDS,

                                                            // you need to specify size of the
                                                            // queue to enable other
                                                            // threads to run the runnable
                                                            blockingQueue);


        for(int i = 0;i<10;i++){

            int finalI = i;
            System.out.println("befor execute:" +finalI);
            threadPoolExecutorService.execute(() -> {
                try{
                    System.out.println("QueueSize: "+blockingQueue.size()+", Content: "+blockingQueue);
                    Thread.sleep(130);
                    System.out.println("Task "+ finalI +" completed");
                }

                catch(Exception e){
                    e.printStackTrace();}
            });
        }
    }
}
