package design_patterns.behavioural.strategy.impl;

public class OffRoadDriveStrategy implements IDriveStrategy {

	@Override
	public void drive() {
		System.out.println("Off Road Drive Strategy!");

	}

}
