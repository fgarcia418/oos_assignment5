package motor;

public interface MotorState {
	
	public abstract void motorTurnOn();
	
	public abstract void motorTurnOff();
	
	public void printState();
	
	public abstract void checkTime();
}
