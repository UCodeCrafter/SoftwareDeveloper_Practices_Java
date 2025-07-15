package all_java_concept.multithreading_and_concurrency.monitor_lock;

public class Main {
    public static void main(String[] args) {
        SharedResources sharedResources = new SharedResources();


        Thread producerThread = new Thread(() ->
        {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResources.addItem();
        });
        Thread consumerThread = new Thread(sharedResources::consumeItem);

        producerThread.start();
        consumerThread.start();




    }
}
