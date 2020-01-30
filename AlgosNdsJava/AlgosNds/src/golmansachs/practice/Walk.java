package golmansachs.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Walk {
	public Integer[] walk(String path) {
		Map<Character, int[]> map = new HashMap<>();
		map.put('U', new int[] { 0, 1 });
		map.put('D', new int[] { 0, -1 });
		map.put('R', new int[] { 1, 0 });
		map.put('L', new int[] { -1, 0 });

		Integer[] curr = new Integer[] { 0, 0 };
		for (char c : path.toCharArray()) {
			int[] dir = map.get(c);
			if (dir != null) {
				curr[0] += dir[0];
				curr[1] += dir[1];
			}
		}

		return curr;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Walk().walk("UDX R")));
	}
}
