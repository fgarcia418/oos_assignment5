package elevator;

import java.util.Observable;
import java.util.Observer;
import doors.Doors;
import motor.Motor;
import motor.MotorIsOn;

public class Elevator implements Observer {
	
	private ElevatorIdleState idleState = null;
	
	private Motor motor;

	private Doors doors;
	
	private ElevatorState currentElevatorState;

	private volatile Boolean motorOn;

	private volatile Boolean doorsOpen;

	public int currentFloor;

	public Elevator(Motor motor, Doors doors) {
		idleState = new ElevatorIdleState(this);
		currentElevatorState = idleState;
		currentFloor = 1;
		this.motor = motor;
		this.doors = doors;
		motor.addObserver(this);
		doors.addObserver(this);
		currentElevatorState.printState();
		motorOn = false;
		doorsOpen = false;

	}
	public void elevatorUpButton() {
		motor.turnOn();
		if(currentFloor < 5 && doorsOpen == false && motorOn == true) {
			currentElevatorState.goUp();
			while(motor.isOn()) {
			}
			doorsOpen = true;
			while(doorsOpen) {
			}
		}
	}
	public void elevatorDownButton() {
		motor.turnOn();
		if(currentFloor > 1 && doorsOpen == false && motorOn == true) {
			currentElevatorState.goDown();
			while(motor.isOn()) {
			}
			doorsOpen = true;
			while(doorsOpen) {
			}
		}
	}
	
	public void elevatorOpenDoors() {
		doors.open();
	}

	public void elevatorCloseDoors() {
		doors.close();
	}
	
	public boolean checkDoors() {
		return doorsOpen;
	}
	
	public ElevatorGoingUpState getGoingUpState() {
		return new ElevatorGoingUpState(this);
	}
	
	public ElevatorGoingDownState getGoingDownState() {
		return new ElevatorGoingDownState(this);
	}
	
	public ElevatorIdleState getIdleState() {
		return idleState;
	}
	public void setCurrentState(ElevatorState newState) {
		this.currentElevatorState = newState;
		currentElevatorState.printState();
	}
	
	@Override
	public void update(Observable o, Object arg) {

		if(o instanceof Motor) {
			motorOn = motor.isOn();
			if(motorOn == false) {
				currentElevatorState.idle();
			}
		}

		if(o instanceof Doors) {
			doorsOpen = doors.areOpen();
		}
	}


}
