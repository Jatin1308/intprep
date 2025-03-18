package JavaMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
        Types of threadpools in executor service:

        1. FixedThreadPool: fixed number of threads, if all working and task i submitted, it is enqueued until a thread is free
        2. CachedThread: A CachedThreadPool dynamically adjusts the number of threads based on the workload. Threads are created
            as needed and reused if available. Unused threads are terminated after a specified idle timeout.
        3. SingleThreadPool: only single thread in a pool
        4. ScheduledThreadPool: A ScheduledThreadPool is used for executing tasks at a specific time or with
            a fixed delay between executions. It maintains a pool of threads and supports scheduling tasks with
            methods like schedule(), scheduleAtFixedRate(), and scheduleWithFixedDelay().
*/



/*
ExecutorService

    High level concurrency utility. manage and execute tasks asynchronously in a pool of threads,
    it abstracts away the complexity of thread management.

    ExecutorService is more abstract and easier to use but ThreadPoolExecutor offers greater
    flexibility and customization options
 */
public class ExecService {

    public static void main(String[] args) {

        // single threaded
        ExecutorService singleThreadExecutor =  Executors.newSingleThreadExecutor();
        System.out.println("SingleThread Executor");
        for(int i =1;i<=5;i++){
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("SingleThread Task: "+taskId +", executed by Thread: "+Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();

        // fixed thread pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println("Fixed Thread Pool");
        for(int i =1;i<=5;i++){
            final int taskId = i;
            fixedThreadPool.execute(() -> {
                System.out.println("FixedThread task: "+taskId +", executed by thread: "+Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();

        // cached thread pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("Cached Thread Pool");
        for(int i =1;i<=5;i++){
            final int taskId = i;
            cachedThreadPool.execute(() -> {
                System.out.println("CachedThread task: "+taskId +", executed by thread: "+Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();


        // scheduled thread pool
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("Scheduled Thread Pool");
        for(int i =1;i<=5;i++){
            final int taskId = i;
            scheduledThreadPool.schedule(() -> {
                System.out.println("ScheduledThread task: "+taskId +", executed by thread: "+Thread.currentThread().getName());
            },3, TimeUnit.SECONDS);
        }
        scheduledThreadPool.shutdown();


    }
}
