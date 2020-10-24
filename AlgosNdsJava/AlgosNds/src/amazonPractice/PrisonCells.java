package amazonPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrisonCells {
    public List<Integer> cellCompete(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;
        for (int i=0; i<N; i++) {
            int[] nextDay = nextDay(cells);
            String key = Arrays.toString(nextDay);
            if (!set.contains(key)) {
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = nextDay;
        }
        
        if (hasCycle) {
            N%=cycle;
            for (int i=0; i<N; i++) {
                cells = nextDay(cells);
            }
        }
        
        for (int i: cells)
        	System.out.println(i);
        
        return Arrays.stream(cells).boxed().collect(Collectors.toList());
    }
    
    private int[] nextDay (int[] cells) {
        int[] tmp = new int[cells.length];
        for (int i=1; i<cells.length-1; i++) {
            tmp[i] = cells[i-1]==cells[i+1] ? 1 : 0;
        }
        return tmp;
    }
    
    public static void main(String[] args) {
    	int[] cells = new int[]{1,0,0,0,0,1,0,0};
		System.out.println(new PrisonCells().cellCompete(cells, 1));
	}
    
}
