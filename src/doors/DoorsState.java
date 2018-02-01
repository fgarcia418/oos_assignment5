package doors;

public interface DoorsState {
	
	public abstract void openDoors();
	
	public abstract void closeDoors();
	
	public abstract void printState();
	
	public abstract void checkTime();
}
