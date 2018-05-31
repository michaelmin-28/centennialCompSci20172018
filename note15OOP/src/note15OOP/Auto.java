package note15OOP;

public abstract class Auto implements Vehicle{
	public enum fuelType {
		GAS, DIESEL, ELECTRIC, HYBRID
	}
	public int numWheels = 4;
	public fuelType fuelKind;
	
	public Auto() {
		System.out.println("Create an Auto! ");
	}
	
	public int getWheelCount() {
		return numWheels;
	}
	
	public fuelType getFuelType() {
		return fuelKind;
	}
	
	public abstract float getMaxSpeed();
	public abstract void drive(int distance);
	public abstract VehicleClassType vehicleKind();
		
}
