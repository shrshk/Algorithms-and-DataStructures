package datastructures.bestpractices;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GoodInventory {
	 
    private Set<Vehicle> vehicles = new HashSet<Vehicle>( );
 
    public void addCar(Vehicle vehicle) {
        // throw exception early
        if (vehicle == null) {
            new IllegalArgumentException("vehicle can't be null");
        }
        //more checks here to add a valid Car
        vehicles.add(vehicle);
    }
 
    public void removeCar(Vehicle vehicle) {
        if (vehicle == null) {
           new IllegalArgumentException("Vehicle can't be null");
        }
        //... more checks here before removing a car
        vehicles.remove(vehicle);
    }
 
    public Set<Vehicle> getCars( ) {
        // prevent addition or removal from outside this class
        return Collections.unmodifiableSet(vehicles);
    }
} 