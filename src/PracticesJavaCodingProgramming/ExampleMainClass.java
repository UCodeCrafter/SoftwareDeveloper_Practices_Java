package PracticesJavaCodingProgramming;



public class ExampleMainClass {
    public static void main(String args[]){
        System.out.println("Hello World!");
        System.out.println(Singleton.getInstance().toString());
        System.out.println(Singleton.getInstance().toString());

//        SingletonExample singletonExample = new SingletonExample();
        System.out.println(SingletonExample.getInstance());
        System.out.println(SingletonExample.getInstance());
        SingletonDoubleChecked.EnumSingleton enumSingleton = SingletonDoubleChecked.EnumSingleton.INSTANCE;
        System.out.println(enumSingleton.myBusinessLogics());

    }


}


// Singleton - not thread Safe
class Singleton{
    private static Singleton INSTANCE;

    private Singleton()
    {}

    public static Singleton getInstance(){
        if(INSTANCE == null)
        {
            INSTANCE =  new Singleton();
        }
        return INSTANCE;
    }
}


// Singleton using Synchronized keyword at method level(Poor Performance)
class SingletonExample{
    private static SingletonExample INSTANCE;
    private SingletonExample(){}

    public static SingletonExample getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SingletonExample();

        return INSTANCE;
    }
}

// Singleton using double-checked locking -(High Performance)

class SingletonDoubleChecked{
    //Volatile ensures the volatility of changes across difference threads
    private static volatile SingletonDoubleChecked INSTANCE;

    private SingletonDoubleChecked(){}
    public SingletonDoubleChecked getInstance(){
        if(INSTANCE == null){ // First check (No Locking)

            synchronized (SingletonDoubleChecked.class){ // Lock Block
                if(INSTANCE == null) {// Second check (With Blocking)
                    INSTANCE = new SingletonDoubleChecked();
                }
            }

        }
        return INSTANCE;
    }
//    Singleton using Enum

    public enum EnumSingleton{
        INSTANCE;
        public boolean myBusinessLogics(){
            System.out.println("System My Business Logic execution !");
            return false;
        }

    }


    @FunctionalInterface
    interface Calculator{
        int add(int a, int b);
    }





}