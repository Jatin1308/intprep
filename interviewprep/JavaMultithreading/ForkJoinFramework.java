package JavaMultithreading;

/*
    designed to efficiently parallelize divide-and-conquer algo, where problem is recursivel split into smaller
    independent problem

    Key Components:
        1. ForkJoin Pool: specialized implementation of ExecutorService optimized for recursive parallelism
        2. ForkJoin Task: lightweight task that can be forked(split) into subtasks and joined once completed
            RecursiveTask<T> -> Returns result
            RecursiveAction -> Performs an operation but does not return a result

        3. WorkStealing Algo: instead of eaiting for tasks, idle worker threads dynamically steal tasks from the tail of another
            thread's dequeue(double ended queue)

        How it works?
            1. main task is submitted to ForkJoin Pool
            2. task divides itself into smalled subtasks
            3. each subtask is executed independently in parallel
            4. once all subtasks finish, their results are merge to get the final output
            5. if a worker thread run out of tasks, it steals work from other busy threads

        RealWorld use cases:
            Recursive algo: parallelizing merge sort, quick sort, matrix multiplication, tree traversal


 */


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFramework {

    static class SumTask extends RecursiveTask<Integer>{
        private static final int THRESHOLD = 10;
        private int[] array;
        private int start, end;

        public SumTask(int[] array, int start, int end){
            this.array = array;
            this.start = start;
            this.end = end;
        }
        @Override
        protected Integer compute() {
            if (end-start <= THRESHOLD){
                int sum = 0;
                for (int i=start;i<end;i++)
                    sum+=array[i];
                return sum;
            }else{
                int mid = (start+end)/2;
                SumTask leftTask = new SumTask(array,start,mid);
                SumTask rightTask = new SumTask(array,mid,end);

                // Fork the subtask to execute in parallel
                leftTask.fork();
                rightTask.fork();

                //JOIN
                return leftTask.join()+rightTask.join();
            }
        }
    }

    public static void main(String[] args) {


        int[] array = {1,2,3,4,5,6,7,8,9,10};
        ForkJoinPool pool = ForkJoinPool.commonPool();

        int result = pool.invoke(new SumTask(array,0,array.length));

        System.out.println("Sum: "+result);


    }
}
