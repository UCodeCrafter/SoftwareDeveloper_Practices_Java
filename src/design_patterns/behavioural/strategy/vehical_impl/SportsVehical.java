package design_patterns.behavioural.strategy.vehical_impl;


import design_patterns.behavioural.strategy.impl.SportsDriveStrategy;

public class SportsVehical extends Vehical {

	public SportsVehical() {
		super(new SportsDriveStrategy());
	}

}
