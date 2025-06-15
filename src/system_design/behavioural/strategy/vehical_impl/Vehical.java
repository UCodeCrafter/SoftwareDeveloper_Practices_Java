package system_design.behavioural.strategy.vehical_impl;

import system_design.behavioural.strategy.impl.IDriveStrategy;

public class Vehical {
	IDriveStrategy driveStrategy;
	public Vehical(IDriveStrategy driveStrategy) {
		this.driveStrategy  = driveStrategy;
	}
	public void drive() {
		driveStrategy.drive();
	}

}
