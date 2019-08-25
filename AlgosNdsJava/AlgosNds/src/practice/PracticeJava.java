package practice;

import java.util.HashMap;
import java.util.Map;

public class PracticeJava {
	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		map1.put("inventory", "age");
		map2.put("inventory", "dateInStock");
		map1.putAll(map2);
		map2.forEach(
			    (key, value) -> map1.merge( key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2)
			);
		System.out.println(map2.toString());
		
	}
}
