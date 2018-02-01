package motor;

import motor.Motor;
import motor.MotorState;

public class MotorIsOff implements MotorState{

	private volatile Motor motor; 
	
	public MotorIsOff(Motor motor) {
		this.motor = motor;
	}
	
	@Override
	public void motorTurnOn() {
		motor.setCurrentState(motor.getOnState());
	}

	@Override
	public void motorTurnOff() {
	}

	@Override
	public void printState() {
		System.out.println("Motor is off");
	}

	@Override
	public void checkTime() {
	}

}
