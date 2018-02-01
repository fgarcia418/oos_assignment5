package motor;

import java.util.Observable;
import java.util.Observer;

import motor.MotorState;
import time.MyTimer;

public class Motor extends Observable implements Observer {
	
	private volatile MotorState currentMotorState;
	
	public int motorTime;
	
	public Motor() {
		currentMotorState = getOffState();
		currentMotorState.printState();
	}

	public void turnOn() {
		currentMotorState.motorTurnOn();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MyTimer && isOn()) {
			currentMotorState.checkTime();
		}
	}

	public boolean isOn() {
		if(currentMotorState instanceof MotorIsOn)
			return true;
		return false;
	}

	public MotorState getOffState() {
		MotorState turnedOff = new MotorIsOff(this);
		return turnedOff;
	}
	public MotorState getOnState() {
		MotorState turnedOn = new MotorIsOn(this);
		return turnedOn;
	}

	public void setCurrentState(MotorState newState) {
		this.currentMotorState = newState;
		currentMotorState.printState();
		this.setChanged();
		this.notifyObservers();
	}

}