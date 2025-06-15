package system_design.behavioural.strategy.vehical_impl;


import system_design.behavioural.strategy.impl.SportsDriveStrategy;

public class SportsVehical extends Vehical {

	public SportsVehical() {
		super(new SportsDriveStrategy());
	}

}
