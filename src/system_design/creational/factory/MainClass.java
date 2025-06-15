package system_design.creational.factory;

import java.util.Scanner;

import system_design.creational.factory.allshapes.Shape;

public class MainClass {

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		Scanner sc ;
		while (true) {
			System.out.println("Enter the type you want a object eg: CIRCLE, SQUARE, RECTANGLE or NA... ");
			sc = new Scanner(System.in);
			
			String input  = sc.nextLine();
			if(input.equalsIgnoreCase("NA")) {
				System.out.println("Programe is ended!");
				break;
			}
			Shape shape = shapeFactory.getShape(input);
			if(shape==null)
				System.out.println("shape is not Valid type!");
			else
			shape.draw();
			
		}
		
		
	}

}
