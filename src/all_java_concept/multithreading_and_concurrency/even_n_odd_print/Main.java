package all_java_concept.multithreading_and_concurrency.even_n_odd_print;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        Thread oddThread = new Thread( ()->
        {
            while(count < 15){
                System.out.println("odd no: " + count);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
                );

        Thread evenThread = new Thread( ()->
        {
            while(count < 15){
                System.out.println("Even no:"+ count);
            }
        }
        );
    }
}
