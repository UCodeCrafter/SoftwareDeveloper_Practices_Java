package all_java_concept.multithreading_and_concurrency.producer_n_Consumer_problem;

public class MainClass {
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource(10);
        final int[] count = {0};



        Thread addItemThread = new Thread(()->{
            int i = 0;
            while(i < 10) {
                try {
                    sharedResource.produceItem(i++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread removeItemThread = new Thread(()->{
            while(addItemThread.isAlive()){

                try {
                    sharedResource.comsumeItem();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        addItemThread.start();
        removeItemThread.start();


    }

}
