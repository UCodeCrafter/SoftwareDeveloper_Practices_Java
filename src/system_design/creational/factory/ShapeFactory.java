package system_design.creational.factory;

import system_design.creational.factory.allshapes.Circle;
import system_design.creational.factory.allshapes.Rectangle;
import system_design.creational.factory.allshapes.Shape;
import system_design.creational.factory.allshapes.Square;

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
