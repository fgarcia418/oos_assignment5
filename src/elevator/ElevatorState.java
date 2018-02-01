package elevator;

public interface ElevatorState {
	public abstract void goUp();
	public abstract void goDown();
	public abstract void idle();
	public abstract void printState();
}
