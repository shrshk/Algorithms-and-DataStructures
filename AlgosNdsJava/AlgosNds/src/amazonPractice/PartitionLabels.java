package amazonPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            map.put(S.charAt(i),i);
        }
        
        List<Integer> res = new ArrayList<>();
        
        int last = 0;
        int start = 0;
        
        for (int i=0; i<S.length(); i++) {
            last = Math.max(last, map.get(S.charAt(i)));
            if (last == i) {
                res.add(last-start+1);
                start = last + 1;
            }
        }
        
        return res;
        
    }
}
