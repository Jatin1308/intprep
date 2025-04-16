package JavaIOandNIO;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * IO:
 *      - stream oriented: data is read one byte at a time, sequential access approach
 *      - blocking: operations are blocking performance bottlenecks
 *      - streams: uses inputstream and outputstream (for byte streams) and reader and wroter (for character streams)
 *      - no selector support
 *      - work directly with primitive data types
 *
 * NIO:
 *      - buffer oriented: data is read into buffer and then processed from there, non-sequential access
 *      - non blocking
 *      - channels: NIO introduced channels like FileChannel, DatagramChannel, SocketChannel which can be used in async task
 *      - provides the selector class which allows single thread to monitor multiple channels for events such as reading,
 *      writing, and connection requests.
 *      - use buffer classes like ByteBuffer, charbuffer etc, allows random access, reading and writing
 *
 *
 */
public class DifferenceInIOandNIO {

    public static void main(String[] args) {

        System.out.println("Current path: "+System.getProperty("user.dir"));
        // file input and output stream

        FileInputStream fis = null;
        try{
            fis = new FileInputStream("JavaIOandNIO/example.txt");

            int content;
            while((content = fis.read()) != -1){
                System.out.println((char) content);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(fis != null)
                    fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
