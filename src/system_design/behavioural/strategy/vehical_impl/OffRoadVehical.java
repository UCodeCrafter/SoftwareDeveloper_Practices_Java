package system_design.behavioural.strategy.vehical_impl;


import system_design.behavioural.strategy.impl.OffRoadDriveStrategy;

public class OffRoadVehical extends Vehical {

	public OffRoadVehical() {
		super(new OffRoadDriveStrategy());
	}

}
