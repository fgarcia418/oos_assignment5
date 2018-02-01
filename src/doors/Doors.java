package doors;

import java.util.Observable;
import java.util.Observer;

import doors.DoorsState;
import time.MyTimer;

public class Doors extends Observable implements Observer{
	
	private volatile DoorsState currentDoorState;
	
	public int doorTime;
	
	public Doors() {
		currentDoorState = getClosedState();
		currentDoorState.printState();
	}
	
	public void open() {
		currentDoorState.openDoors();
	}

	public void close() {
		currentDoorState.closeDoors();	
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MyTimer && areOpen()) {
			currentDoorState.checkTime();
			//System.out.println(doorTime + " seconds have passed");
		}
	}

	public boolean areOpen() {
		if(currentDoorState instanceof DoorsOpenState) {
			return true;
		}
		return false;
	}

	public void setCurrentState(DoorsState newState) {
		this.currentDoorState = newState;
		currentDoorState.printState();
		this.setChanged();
		this.notifyObservers();
	}


	
	public DoorsState getOpenState() {
		return new DoorsOpenState(this);
	}
	
	public DoorsState getClosedState() {
		return new DoorsClosedState(this);
	}
}
