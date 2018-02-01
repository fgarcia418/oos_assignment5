package doors;

import doors.Doors;
import doors.DoorsState;

public class DoorsClosedState implements DoorsState{
	
	private Doors doors;
	
	public DoorsClosedState(Doors doors) {
		this.doors = doors;
	}

	@Override
	public void openDoors() {
		doors.setCurrentState(doors.getOpenState());
	}

	@Override
	public void printState() {
		System.out.println("Elevator doors are closed");
	}

	@Override
	public void closeDoors() {
		System.out.println("Elevator doors are already closed");
	}

	@Override
	public void checkTime() {
	}

}
