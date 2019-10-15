package designPatterns.bestpractices;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* Avoid if else if else if with Condition Pattern */

class Vehicle {
	int price;
	Vehicle(int price) {
		this.price = price;
	}
}
interface Handler{
    boolean handle( Vehicle veh);
}

class CondOne implements Handler {
	@Override
	public boolean handle(Vehicle veh) {
		return veh.price > 30000;
	}	
}

class CondTwo implements Handler {
	@Override
	public boolean handle(Vehicle veh) {
		return veh.price < 10000;
	}	
}

class ConditionPattern {
	static Map<String, Handler> commandMap = new HashMap<>();
    static {
   	 commandMap.put("condOne", new CondOne());
   	 commandMap.put("condTwo", new CondTwo());
    }
    
    public static Optional<Handler> getHandler(String handlerName) {
        return Optional.ofNullable(commandMap.get(handlerName));
    }    
    
}

public class ConditionPatternFactory {
	public static void main(String[] args) {
		String condition = "condOne";
	// if (contion == "condOne") { do something} else if (cond=="condTwo") do something...
		Handler isExpensive = ConditionPattern
	  	      .getHandler(condition)
	  	      .orElseThrow(() -> new IllegalArgumentException("Invalid handler name"));
		if (isExpensive.handle(new Vehicle(35000))) {
			System.out.println("do something");
		}
		
		// doing above avoids cases of 
		// if else if else if ......
	}
     
}



