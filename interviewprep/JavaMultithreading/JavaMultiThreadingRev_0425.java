package JavaMultithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaMultiThreadingRev_0425 {
    static int  i;
    public static void main(String[] args) throws InterruptedException {


//        ExecutorService ex = Executors.newFixedThreadPool(5);
//        for(int i = 0 ; i<5; i++){
//            ex.execute(() -> {
//                System.out.println("Running thread: "+Thread.currentThread().getName());
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//        ex.shutdown();


//        while(true){
////            ExecutorService vt = Executors.newVirtualThreadPerTaskExecutor();
////            vt.execute(() -> {
////                System.out.println("The VT name: "+Thread.currentThread().getName());
////            });
//            Thread t = new Thread(() -> {
//                System.out.println("Thread Name: "+Thread.currentThread().getName());
//                try {
//                    Thread.sleep(100000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            t.start();
//
//
//        }




//        SharedCounter sharedCounter =  new SharedCounter();
//
//        new Thread(() -> {
//            for(int i = 0; i <100000;i++)
//                sharedCounter.increment();
//            System.out.println("Thread 1 completed");
//        }).start();
//
//        new Thread(() -> {
//            for(int i = 0; i<100000; i++)
//                sharedCounter.increment();
//            System.out.println("Thread 2 completed");
//        }).start();
//        Thread.sleep(3000);
//
//        System.out.println(sharedCounter.getCount());




    }
}


//        MyThread t = new MyThread();
//        MyRunnable r = new MyRunnable();
//        t.start();
//
//        Thread tr = new Thread(r);
//        tr.start();
//    Runnable r = () -> {
//        System.out.println("Runnable running");
//    };
//        r.run();
//        Callable<String> c = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "Ki chakkar aa";
//            }
//        };
//        c.call();
//class MyThread extends Thread{
//
//    @Override
//    public void run(){
//        System.out.println("MyThread :: Thread running: "+Thread.currentThread().getName());
//    }
//}
//
//class MyRunnable implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("MyRunnable :: Thread running: "+Thread.currentThread().getName());
//    }
//}


