package motor;

import motor.Motor;
import motor.MotorState;

public class MotorIsOn implements MotorState{
	private volatile Motor motor;
	
	public MotorIsOn(Motor motor) {
		this.motor = motor;
		motor.motorTime = 0;
	}
	
	@Override
	public void motorTurnOn() {
	}

	@Override
	public void motorTurnOff() {
		motor.setCurrentState(motor.getOffState());
	}
	
	@Override
	public void printState() {
		System.out.println("Motor is on");
	}
	
	@Override
	public void checkTime() {
		motor.motorTime++;
		if(motor.motorTime>=10) {
			motorTurnOff();
		}
	}
}
