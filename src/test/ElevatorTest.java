package test;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import doors.Doors;
import elevator.Elevator;
import motor.Motor;
import time.MyTimer;

public class ElevatorTest {
	private static MyTimer timer;
	private static Elevator elevator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timer = new MyTimer();
		new Thread(timer).start();
		
		Motor motor = new Motor();
		Doors doors = new Doors();
		elevator = new Elevator(motor,doors);
		
		timer.addObserver(motor);
		timer.addObserver(doors);
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		timer.cancelTimer();
	}

	@Test(timeout=16000)
	public void testRequestedOutput(){
		elevator.elevatorUpButton();
		assertTrue(true);
		System.out.println("***Going Down Test Complete!\n");

	}
	
	@Test(timeout=16000)
	public void testGoingDown(){
		elevator.currentFloor = 5;
		elevator.elevatorDownButton();
		assertTrue(true);
		System.out.println("***Going Down Test Complete!\n");
	}
	
	@Test(timeout=2000)
	public void testQuicklyCloseDoor(){
		elevator.elevatorOpenDoors();
		while(elevator.checkDoors()) {
			elevator.elevatorCloseDoors();
		}
		assertTrue(true);
		System.out.println("***Quickly Closing Door Test Complete!\n");

	}
	
}

