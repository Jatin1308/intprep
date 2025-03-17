public class StringBufferAndBuilder {


    public static void main(String[] args) throws InterruptedException {

//        // should be used for multithreaded env
//        StringBuffer buffer = new StringBuffer("Buffer"); // capacity -> 16 + length of string passed
//        System.out.println(buffer.capacity());
//
//
//        // should be used for single threaded env
//        // faster than stringbuffer
//        StringBuilder builder = new StringBuilder("Builder");
//        System.out.println(builder.capacity());


        // why string buffer is threadsafe?

//        StringBuilder builder = new StringBuilder(); // -> not thread safe
        StringBuffer builder = new StringBuffer(); // -> thread safe

        Thread t1 = new Thread(() -> {
           for(int i = 0; i<1000;i++){
               builder.append('A');
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i<1000;i++){
                builder.append('B');
            }
        });

        t1.start();t2.start();

        t1.join();t2.join();


        System.out.println("length: "+builder.toString().length());


    }
}
