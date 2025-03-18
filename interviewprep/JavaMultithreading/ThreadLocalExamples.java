package JavaMultithreading;


/*
    ThreadLocal class helps in creating variables that can only be read and written by the same thread
    these variables are unique to each thread and are not shared amng threads
    Improve performance by avoiding synchronization overhead in multithreaded env
 */
public class ThreadLocalExamples {
    public static void main(String[] args) {

        ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();

        // simulate userlanding on webpage
        Long userId = 12345L;
        Long userId1 = 5678L;

        Thread requestThread = new Thread(() -> {
            System.out.println("Started Thread for: "+userId);
            userIdThreadLocal.set(userId);

            //Process m logic and database call
            System.out.println("Completed logic for ID: "+userId);

            //Good coding practice
            userIdThreadLocal.remove();
            System.out.println("Removed: "+userId);
        });

        Thread requestThread1 = new Thread(() -> {
            System.out.println("Started Thread for: "+userId1);
            userIdThreadLocal.set(userId1);

            //Process m logic and database call
            System.out.println("Completed logic for ID: "+userId1);

            //Good coding practice
            userIdThreadLocal.remove();
            System.out.println("Removed: "+userId1);
        });

        requestThread.start();
        requestThread1.start();


//        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
//
//        Thread o3 = new Thread(() -> {
//            inheritableThreadLocal.set("Instagram");
//            Thread o4 = new Thread(() -> {
//                System.out.println("Inheritable: "+inheritableThreadLocal.get());
//            });
//        });



    }
}
