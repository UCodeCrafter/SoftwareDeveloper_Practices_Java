package design_patterns.behavioural.strategy.vehical_impl;


import design_patterns.behavioural.strategy.impl.OffRoadDriveStrategy;

public class OffRoadVehical extends Vehical {

	public OffRoadVehical() {
		super(new OffRoadDriveStrategy());
	}

}
