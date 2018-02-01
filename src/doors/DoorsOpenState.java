package doors;

import doors.Doors;
import doors.DoorsState;

public class DoorsOpenState implements DoorsState {
	
	private Doors doors;

	public DoorsOpenState(Doors doors) {
		this.doors = doors;
		doors.doorTime = 0;
	}
	
	@Override
	public void openDoors() {
		System.out.println("Elevator doors are already open");
	}
	
	@Override
	public void closeDoors() {
			doors.setCurrentState(doors.getClosedState());
	}
	
	@Override
	public void printState() {
		System.out.println("Elevator doors are open");
	}

	@Override
	public void checkTime() {
		doors.doorTime++;
		if(doors.doorTime>=5) {
			closeDoors();
		}
		
	}
	
}
