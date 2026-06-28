package all_java_concept.multithreading_and_concurrency.producer_n_Consumer_problem;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.sleep;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int size;

    public SharedResource(int size){
        this.sharedBuffer = new LinkedList<>();
        this.size = size;
    }

    public synchronized void produceItem(int item) throws InterruptedException {
        while (sharedBuffer.size() == size){
            System.out.println("Buffer is full, Producer is waiting for consumer!");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced : "+ item);
        notify();

    }

    public synchronized void comsumeItem() throws InterruptedException {
        if(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty: ");
            wait();
        }else{
            System.out.println("Consumed: "+ sharedBuffer.poll());
            notify();
        }
    }


}
