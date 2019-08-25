package amazon;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meetup {
	static List<List<String>> events(List<List<String>> timeSlots) {
		int[] timeline = new int[1800 - 700];
		Arrays.fill(timeline, 0);
		for (List<String> slot : timeSlots) {			
			int durationIntStart = Integer.parseInt(slot.get(0).replace(":", ""));
			durationIntStart = durationIntStart >= 700 ? durationIntStart : 700;
			int durationIntEnd = Integer.parseInt(slot.get(1).replace(":", ""));
			durationIntEnd = durationIntEnd <= 1800 ? durationIntEnd : 1800;
			if (durationIntEnd <= 1800 && durationIntStart >= 700) {
				for (int i=durationIntStart-700; i<durationIntEnd-700; i++) {
					timeline[i] = 1; // update range with 1
				}					
			}
		}

		// now pick free slots from the timeline.
		// System.out.println(timeline[99]);

		// for (int i=0; i<		

		return freeTime(timeline);
	}
	
	// improve this method.
	static List<List<String>> freeTime(int[] timeline) {
		List<List<String>> result = new ArrayList<>();
		int i=0, j=i+1;
		while (i<timeline.length-1 && j<timeline.length-1) {
			if(timeline[i]==0 && timeline[j]==0) {
				j++;
			}
			if (timeline[i]==0 && timeline[j]==1) {
				result.add(asList(String.valueOf(i+700),String.valueOf(j-1+700)));
				i=j;
				j=j+1;
			}	
			if (timeline[i]==1 && timeline[j]==1) {
				i++;
				j++;
			}
			if (timeline[j]==0 && timeline[i]==1) {
				i=j;
				j=j+1;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<String>> Input = asList(asList("16:00", "16:30"), asList("6:00", "7:30"), asList("8:00", "9:20"),
				asList("8:00", "9:00"), asList("17:30", "19:20"));
		System.out.println(events(Input));
	}

}
