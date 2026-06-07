package all_java_concept.multithreading_and_concurrency.even_n_odd_print;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        final int[] count = {0};
        Thread oddThread = new Thread( ()->
        {
            for (int i = 0; i < 10; i++) {
                if(i%2==0){
//                    try {
////                        wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
                System.out.println(i);

            }
        }
                );

        Thread evenThread = new Thread( ()->
        {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

            }
        }
        );
    }
}
