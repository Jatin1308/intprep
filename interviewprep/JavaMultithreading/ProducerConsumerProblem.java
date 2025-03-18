package JavaMultithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



/*
Producer-Consumer problem is a classic synchronization problem in concurrent programming where there are 2 types of threads:
producers and consumers

Challenge: to ensure that producers do not produce items when buffer is full and consumers do not consume items when the buffer is empty.
one effective way is using BlockingQueue interface in java

ProducerThread ---> SharedQueue ---> ConsumerThread -> have problem in this architecture
if speed of producer > consumer: overflow of the shared queue
if speed of producer < consumer: consumer will try to fetch events from empty queue


Can be solved with BlockingQueue
 */

class ProducerBlockingQueue implements Runnable{
    private  BlockingQueue<Integer> queue;

    public ProducerBlockingQueue(BlockingQueue<Integer> queue){this.queue = queue;}

    @Override
    public void run() {
        try{
            for(int i = 0; i < 100; i++){
//                Thread.sleep(1000);
                queue.put(i);
                System.out.println("Produced: "+i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ConsumerBlockingQueue implements Runnable{
    private  BlockingQueue<Integer> queue;

    public ConsumerBlockingQueue(BlockingQueue<Integer> queue){this.queue = queue;}

    @Override
    public void run() {
        try{

            whileLoop:
                while(true){
                    Integer item = queue.take();
                    System.out.println("Consumer: "+item);
//                    Thread.sleep(2000);
                }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


public class ProducerConsumerProblem {

    public static void main(String[] args) {

        // shared queue - will be used both in producer and consumer
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // creating producer and consumer threads
        ProducerBlockingQueue producer = new ProducerBlockingQueue(queue);
        ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);

        // starting consumer and producer threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }
}
