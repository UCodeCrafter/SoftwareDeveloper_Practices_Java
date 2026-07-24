package design_patterns.behavioural.strategy.vehical_impl;

import design_patterns.behavioural.strategy.impl.IDriveStrategy;

public class Vehical {
	IDriveStrategy driveStrategy;
	public Vehical(IDriveStrategy driveStrategy) {
		this.driveStrategy  = driveStrategy;
	}
	public void drive() {
		driveStrategy.drive();
	}

}
