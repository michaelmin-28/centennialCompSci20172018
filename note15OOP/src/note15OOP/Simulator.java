package note15OOP;
import java.util.ArrayList;
public class Simulator {

	public static void main(String[] args) {
		System.out.println("A vehicle simulation. ");
		
		// ArrayList to keep a list of vehicles to simulate
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Car());
		vehicles.add(new Truck());
		
		for (Vehicle device : vehicles) {
			int distance =  (int)(device.getMaxSpeed() * 4);
			// Simulate driving the device for the distance
			device.drive(distance);
			
			switch (device.vehicleKind()) {
				case CAR:
					Car carVehicle = (Car) device;
					System.out.println("Trunk Size: " + carVehicle.getTrunkSize());
					System.out.println("The On Star Test returned: " + carVehicle.onStarTest(Ford.ModelNames.F150));
					break;
				case TRUCK:
					Truck truckVehicle = (Truck) device;
					System.out.println("Bed Size: " + truckVehicle.getBedSize());
					break;
				default:
					System.out.println("Error - UNKNOWN VEHICLE!");
					break;
					
			}
		}
	}

}
