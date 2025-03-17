package JavaMultithreading;


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
public class ExecutorAndExecutorService {
}
