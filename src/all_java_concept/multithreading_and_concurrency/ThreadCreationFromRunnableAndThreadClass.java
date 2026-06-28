package all_java_concept.multithreading_and_concurrency;

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Thread created in the MyThread class "+ " :: "+ Thread.currentThread().getName() );
    }
}

class RunnableThread implements Runnable{
    public void run(){
        System.out.println("Runnable Thread :: " + Thread.currentThread().getName());

    }
}

public class ThreadCreationFromRunnableAndThreadClass {
    public static void main(String[] args) {
        System.out.println("Main Thread Name :: "+ Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();


        RunnableThread runnableThread = new RunnableThread();
        Thread threadFromRunnable = new Thread(runnableThread);
        threadFromRunnable.start();
        /**
         * Thread States(5) :: NEW -> (Runnable <-(Blocked/Waiting)-> Running) -> Terminated
         * Blocked- when I/O task acquire lock
         * Waiting - explicitly make to wait based on condition - Wait() & notify()
         * Timed Waiting - when sleep for some time - Using Sleep() & Join()
         * Runnable - waiting for CPU
         */



    }
}
