package design_patterns.behavioural.strategy.impl;

public class NormalDriveStrategy implements IDriveStrategy{

	@Override
	public void drive() {
		System.out.println("Normal Drive Strategy!");
		
	}

}
