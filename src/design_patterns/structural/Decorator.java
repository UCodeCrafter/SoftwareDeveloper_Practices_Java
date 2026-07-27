package design_patterns.structural;

/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 * This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
 */
public class Decorator {

    public static void main(String[] args) {

    Shape rectangle = new Rectangle();
    rectangle.draw();

    Shape redRectangle = new RedShapeDecorator(new Rectangle());
    redRectangle.draw();

    Shape redCircle  = new RedShapeDecorator(new Circle());
    redCircle.draw();
    }


}



interface Shape{

    public void draw();
}


class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a rectangle");
    }
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a Circle!");
    }
}


abstract class ShapeDecorator implements Shape{
    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape){
        this.decoratorShape = decoratorShape;
    }

    public void draw(){
        decoratorShape.draw();
    }

}

class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratorShape){
        super(decoratorShape);
    }
    @Override
    public void draw(){
        decoratorShape.draw();
        setRedBoarder();

    }

    private void setRedBoarder() {
        System.out.println("Border Color: Red");
    }
}