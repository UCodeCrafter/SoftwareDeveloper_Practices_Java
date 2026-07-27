package design_patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The Observer design pattern is a behavioral design pattern,
 * used to create a one-to-many dependency between objects so that when one object (the subject) changes its state,
 * all its dependents (observers) are notified and updated automatically.
 */
public class Observer {

    public static void main(String[] args) {
        StockMarketImpl stockMarket = new StockMarketImpl();

        stockMarket.registerObserver(new Investor("John Doe"));
        stockMarket.registerObserver(new Investor("Uttam"));


        stockMarket.setStockPrice("AAPL", 150.00);


        stockMarket.setStockPrice("INFOSYS", 150.00);
        stockMarket.registerObserver(new Investor("NANDU"));

        stockMarket.setStockPrice("ITC", 150.00);




    }

}

interface StockObserver {
    void update(String stockSymbol, double stockPrice);

}

class Investor implements StockObserver{
    private String name;

    public Investor(String name){
        this.name = name;
    }

    public void update(String stockSymbol, double stockPrice){
        System.out.println(name + " received an update for " + stockSymbol + " :$"+stockPrice);
    }
}

interface StockMarket{
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(String stockSymbol, double stockPrice);
}


class StockMarketImpl implements StockMarket{
    List<StockObserver> observers;
    public StockMarketImpl(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(StockObserver observer) {
        this.observers.add(observer);

    }

    @Override
    public void removeObserver(StockObserver observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObservers(String stockSymbol, double stockPrice) {
        for(StockObserver observer: observers){
            observer.update(stockSymbol, stockPrice);
        }

    }

    //
    public void setStockPrice(String stockSymbol, double stockPrice) {
        notifyObservers(stockSymbol, stockPrice);
    }
}
