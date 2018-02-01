package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import motor.Motor;
import time.MyTimer;

public class MotorTest {
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


	@Test(timeout=11000)
	public void testMotor() {
	
		Motor motor = new Motor();
		timer.addObserver(motor);
		
		motor.turnOn();
		while(motor.isOn()) {
		}
		System.out.println("Motor test complete");
		assertTrue(true);
	}
}
