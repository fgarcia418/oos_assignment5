package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import doors.Doors;
import time.MyTimer;

public class DoorTest {
	
	private static MyTimer timer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timer = new MyTimer();
		new Thread(timer).start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		timer.cancelTimer();
	}

	@Test(timeout=5000)
	public void testDoors() {
	
		Doors doors = new Doors();
		timer.addObserver(doors);
		doors.open();
		while(doors.areOpen()) {
		}
		System.out.println("Doors Basic Functionality Test Complete!\n");
		assertTrue(true);
	}
	
	@Test(timeout=5000)
	public void testDoorsQuicklyClose() {
		Doors doors = new Doors();
		timer.addObserver(doors);
		doors.open();
		while(doors.areOpen()) {
			doors.close();
		}
		System.out.println("Doors Quickly Close Test Complete!\n");
		assertTrue(true);
	}
}
