package note15OOP;

public interface Vehicle {
	// Interfaces are like contracts
	// No code inside!!!
	// Method definitions only, nothing inside of them
	// No "new", objects, or instantiation
	enum VehicleClassType {
		CAR, TRUCK
	}
	public float getMaxSpeed();
	public void drive(int distance);
	public VehicleClassType vehicleKind();

}
