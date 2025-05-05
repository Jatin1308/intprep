package Java9To23Features;

import jdk.jshell.SourceCodeAnalysis;

import javax.swing.*;
import java.util.concurrent.*;

public class FutureAndCompletableFuture {

//    static void async(){
//        System.out.println("I am async and exiting ");
//        System.exit(500);
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // completable future to run multiple tasks in parallel nd wait for all to complete
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1,future2);

        allFutures.thenRun(() ->{
            System.out.println("Both tasks completed!!!");
        });


        // handling exceptions in completable future
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            if(true){
//                throw new RuntimeException("Calculation Failed!!!");
//            }
//            return 10;
//        }).exceptionally(ex -> {
//            System.out.println("Exception thrown: "+ex.getMessage());
//            return 0;
//        });
//
//        System.out.println("Res: "+future.join());





        // example of completable future to handle/compose results
//        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "World");
//
//        f1.thenCombine(f2, (r1,r2) -> r1+" and "+r2).thenAccept(System.out::println);





        // example of completablefuture as nonblocking

//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            async();
//            try {
//                System.out.println("In comp future thread: "+Thread.currentThread().getName());
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return 20;
//        });
//        completableFuture.thenAccept(result -> System.out.println("Result: "+result));
//        System.out.println("How are you from thread: "+Thread.currentThread().getName());
//        Thread.sleep(4000);



        // example of future as blocking

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<Integer>  future= executor.submit(() -> {
//            Thread.sleep(3000);
//            return 10;
//        });
//        System.out.println(future.get());
//        executor.shutdown();
    }
}
