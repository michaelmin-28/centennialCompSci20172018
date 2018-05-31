package note15OOP;

public class Car extends Auto implements Ford{
	private float maxSpeed = (float)100.5;
	private float trunkSize = (float)50.5;
	
	public Car() {
		System.out.println("Create a car! ");
		// Set the fuelType class variable
		fuelKind = fuelType.HYBRID;
	}

	public float getMaxSpeed() {
		return(maxSpeed);
	}
	
	public float getTrunkSize() {
		return(trunkSize);
	}

	public void drive(int distance) {
		System.out.println("Simulating driving CAR for " + distance + " miles ");
	}
	
	public boolean onStarTest(Ford.ModelNames model) {
		System.out.println("Ford model: " + model);
		return(false);
	}
	public VehicleClassType vehicleKind() {
		return(VehicleClassType.CAR);
	}
}
