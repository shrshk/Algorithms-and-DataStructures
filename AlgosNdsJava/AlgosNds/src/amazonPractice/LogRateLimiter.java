package amazonPractice;

import java.util.HashMap;
import java.util.Map;

public class LogRateLimiter {
	Map<String, Integer> map;
	/** Initialize your data structure here. */
	public LogRateLimiter() {
		map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!map.containsKey(message)||timestamp-map.get(message)>=10) {
			map.put(message, timestamp);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		LogRateLimiter log = new LogRateLimiter();	
		System.out.println(log.shouldPrintMessage(1, "foo"));
		System.out.println(log.shouldPrintMessage(10,"foo"));
	}
}
