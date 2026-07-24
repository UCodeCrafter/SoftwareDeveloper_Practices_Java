package design_patterns.creational.factory;

import design_patterns.creational.factory.allshapes.Circle;
import design_patterns.creational.factory.allshapes.Rectangle;
import design_patterns.creational.factory.allshapes.Shape;
import design_patterns.creational.factory.allshapes.Square;

public class ShapeFactory {
	
	public Shape getShape(String type) {
		switch (type) {
		case "CIRCLE": {
			return new Circle();
		}
		case "RECTANGLE":{
			return new Rectangle();
		}
		case "SQUARE":
		{
			return new Square();
		}
		default:
			return null;
		}
		
	
	}

}
