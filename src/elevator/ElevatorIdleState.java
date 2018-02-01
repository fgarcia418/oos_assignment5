package elevator;

public class ElevatorIdleState implements ElevatorState {
	private Elevator elevator;
	
	private int visited;

	public ElevatorIdleState(Elevator elevator) {
		this.elevator = elevator;
		visited = 0 ;
	}

	@Override
	public void goUp() {
		elevator.currentFloor++;
		elevator.setCurrentState(elevator.getGoingUpState());
	}

	@Override
	public void goDown() {
		elevator.currentFloor--;
		elevator.setCurrentState(elevator.getGoingDownState());	

	}

	@Override
	public void idle() {
	}

	@Override
	public void printState() {
		System.out.println("Elevator is idle");
		visited++;
		if(visited > 1) {
			System.out.println("The elevator arrives at floor " + elevator.currentFloor);
			elevator.elevatorOpenDoors();
		}
	}
}
