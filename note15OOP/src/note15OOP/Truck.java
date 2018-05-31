package note15OOP;

public class Truck extends Auto {
	private double bedSize = (double) 100.0;
	private float maxSpeed = (float) 80.5;
	public Truck() {
		System.out.println("Create a truck! ");
		fuelKind = fuelType.DIESEL;
	}
	
	public float getMaxSpeed() {
		return(maxSpeed);
	}
	
	public double getBedSize() {
		return(bedSize);
	}
	
	public void drive(int distance) {
		System.out.println("Simulating driving TRUCK for " + distance + " miles. ");
	}
	
	public VehicleClassType vehicleKind() {
		return(VehicleClassType.TRUCK);
	}
}
