package JavaMultithreading;



// should not use this type of legacy code, instead use functional programming style
/*class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread 1 is running");

    }
}*/
public class MultiThreading {

    public static void main(String[] args) {
        /*
         * difference b/w threads and processes
         * process -> notepad, chrome etc
         * thread -> multiple threads can exist within a single process
         */

        // creating thread
        /*MyThread t1 = new MyThread();
        t1.start();*/


        // this is also not recommended
        Thread obj = new Thread(() -> {
            System.out.println("Thread 2 is running");
        });
        obj.start();



        // we will use runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 3 is running: "+Thread.currentThread());
            }
        };

        Thread obj3 = new Thread(runnable,"Runnable Thread");
        obj3.start();

        // instead of using new Runnable we can give lambda expression

        Runnable run2 = () ->{
            System.out.println("Thread 4 is running: "+Thread.currentThread());
        };
        Thread t4 = new Thread(run2, "Lambda Expression Runnable");
        t4.start();




    }
}
