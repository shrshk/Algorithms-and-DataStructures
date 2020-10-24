package atlassianPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoboDirections {

	public int[] getPos(String dirs) {
		Map<Character, int[]> dirMap = new HashMap<>();
		dirMap.put('U', new int[] { 0, 1 });
		dirMap.put('D', new int[] { 0, -1 });
		dirMap.put('R', new int[] { 1, 0 });
		dirMap.put('L', new int[] { -1, 0 });

		int[] pos = new int[] { 0, 0 };

		Map<Character, Character> leftMap = new HashMap<>();
		Map<Character, Character> rightMap = new HashMap<>();

		// R L U D
		// U D L R
		leftMap.put('R', 'U');
		leftMap.put('L', 'D');
		leftMap.put('U', 'L');
		leftMap.put('D', 'R');

		// R L U D // D U R L
		rightMap.put('R', 'D');
		rightMap.put('L', 'U');
		rightMap.put('U', 'R');
		rightMap.put('D', 'L');

		char currDir = 'R';

		for (char c : dirs.toCharArray()) {
			if (c != 'F') {
				if (c == 'L')
					currDir = leftMap.get(currDir);
				if (c == 'R')
					currDir = rightMap.get(currDir);
				continue;
			}

			int[] toMove = dirMap.get(currDir);

			pos[0] += toMove[0];
			pos[1] += toMove[1];

		}

		return pos;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new RoboDirections().getPos("LLRF")));
	}
}
