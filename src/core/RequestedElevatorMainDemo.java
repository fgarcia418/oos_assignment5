package core;
import doors.*;
import motor.*;
import time.MyTimer;
import elevator.*;

public class RequestedElevatorMainDemo{

	private static MyTimer timer;
	
	public static void main(String[] args){
		
		timer = new MyTimer();
		new Thread(timer).start();
		
		Motor motor = new Motor();
		Doors doors = new Doors();
		Elevator elevator = new Elevator(motor,doors);

		timer.addObserver(motor);
		timer.addObserver(doors);

		elevator.elevatorUpButton();
		timer.cancelTimer();
	}

	}


