package all_java_concept.multithreading_and_concurrency.monitor_lock;

public class SharedResources {
    private boolean isItemPresent = false;

    public synchronized void addItem() {
        isItemPresent = true;
        System.out.println("Producer thread calling the notify method" + Thread.currentThread());
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer thread inside consumeItem method" + Thread.currentThread());
        while (!isItemPresent){
            try {
                System.out.println("Consumer thread is waiting" + Thread.currentThread());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumer thread consumed the item");
        isItemPresent = false;
    }
}