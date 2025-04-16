package JavaDesignPatterns;


/**
 * singleton design pattern ensures a class has only one instance and provides a global point of access to that instance.
 *
 * how to create a singleton
 *
 *      1. eager initialization: create instance of the singleton class is created at the time of class loading, private constr
 *      2. Lazy initialization - instance created only when it is needed for the first time
 *      3. ThreadSafe Singleton-
 */
public class Singleton {

    // 1. , 2.
    private static final Singleton INSTANCE = new Singleton();

    private Singleton(){}
    public static Singleton getInstance(){
        return INSTANCE;
    }

    public static synchronized Singleton getSynchronizedInstance(){
        return new Singleton();
    }
}
