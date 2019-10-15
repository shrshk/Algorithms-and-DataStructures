package datastructures.bestpractices;

import java.util.HashSet;
import java.util.Set;

class Vehicle {
	
}

public class BadInventory {
    //no duplicates allowed, hence use a Set
    private Set<Vehicle> vehicles = new HashSet<Vehicle>(10);
    
    //exposes the vehicles to the caller 
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

} 