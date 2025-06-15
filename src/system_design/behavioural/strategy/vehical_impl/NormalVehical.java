package system_design.behavioural.strategy.vehical_impl;


import system_design.behavioural.strategy.impl.NormalDriveStrategy;

public class NormalVehical extends Vehical {

	public NormalVehical() {
		super(new NormalDriveStrategy());
	}

}
