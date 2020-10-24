package amazonLeetCode;

import java.util.Map;

class Calendar {
	private Map<String, String> exampleWithInterval;

	public Map<String, String> getExampleWithInterval() {
		return exampleWithInterval;
	}

	public void setExampleWithInterval(Map<String, String> exampleWithInterval) {
		this.exampleWithInterval = exampleWithInterval;
	}
	
}

class Specification {
	private String type;
	private Calendar calendar;
}

public class YAMLExample {
	/*apiVersion: argoproj.io/v1alpha1
kind: EventSource
metadata:
  name: calendar-event-source
spec:
  type: calendar
  calendar:
    example-with-interval:
      # creates an event every 10 seconds
      schedule: "30 * * * *"*/
	
	private String name;
	private String kind;
	private Map<String, String> metadata;  // {metadata: {name: ces, x:y,...}}
	private Specification spec;	
	
	
}
