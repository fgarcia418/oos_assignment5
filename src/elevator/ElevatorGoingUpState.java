package elevator;

import elevator.ElevatorState;

public class ElevatorGoingUpState implements ElevatorState {
	
	private volatile Elevator elevator;
	
	public ElevatorGoingUpState(Elevator elevator) {
		this.elevator = elevator;
	}
	
	@Override
	public void goUp() {
		System.out.println("This elevator can't do that right now");
	}
	
	@Override
	public void goDown() {
		System.out.println("This elevator can't do that right now");
	}
	
	@Override
	public void idle() {
		elevator.setCurrentState(elevator.getIdleState());
	}

	@Override
	public void printState() {
		System.out.println("Elevator is going up");
	}

}
