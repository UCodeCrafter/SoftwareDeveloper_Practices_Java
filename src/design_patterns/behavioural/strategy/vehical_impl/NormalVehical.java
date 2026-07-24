package design_patterns.behavioural.strategy.vehical_impl;


import design_patterns.behavioural.strategy.impl.NormalDriveStrategy;

public class NormalVehical extends Vehical {

	public NormalVehical() {
		super(new NormalDriveStrategy());
	}

}
