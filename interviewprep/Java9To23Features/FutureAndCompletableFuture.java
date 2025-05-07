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



        // difference bw runAsync and supplyAsync
        // runAsync -> runs an asynchronous task that does not return a value (Runnable)
        // supplyAsync -> runs an asynchron task that returns a value (Supplier)

        CompletableFuture.runAsync(() -> System.out.println("Task executed from runAsync"));
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> 10);







        // difference b/w thenCompose() and thenCombine()
        // thenCompose(): chain 2 futures where second one depends on first one's result. It flattens 2 stages
        // thenCombine(): combine 2 independent futures and apply function to both results

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
//                .thenCompose(res -> CompletableFuture.supplyAsync(() -> res*2));
//        System.out.println(future.join());
//
//        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
//        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);
//        CompletableFuture<Integer> combined = f1.thenCombine(f2, Integer::sum);
//        System.out.println(combined.join());






        // combining different futures

//        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
//        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);
//
//        CompletableFuture<Integer> combined = f1.thenCombine(f2, (r1,r2) -> {
//            try {
//                Thread.sleep(8000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return r1+r2;
//        });
//        System.out.println(combined.join());
//        System.out.println(combined);





        // handling both the results and exceptions in a completable future
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            if(true) throw new RuntimeException("Failed!!");
//            return 10;
//        });
//        CompletableFuture<Integer> handledFuture = future.handle((res,ex) -> {
//            if (ex!=null){
//                System.out.println("Exception: "+ex.getMessage());
//                return 0;
//            }return res;
//        });
//
//        System.out.println(handledFuture.join());

        // chaining multiple asynchronous computation with completable future
//        CompletableFuture.supplyAsync(() -> 10)
//                .thenApply(result -> result*2)
//                .thenAccept(result -> System.out.println("Final Result: "+result));



        // completable future to run multiple tasks in parallel nd wait for all to complete
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
//        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1,future2);
//        allFutures.thenRun(() ->{
//            System.out.println("Both tasks completed!!!");
//        });



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
