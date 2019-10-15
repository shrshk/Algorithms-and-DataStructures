package amazonPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String result = "";
        int maxCount = 0;
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split("\\W+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word: words) {
            if (!wordFreq.containsKey(word)) {               
                wordFreq.put(word, 1);
            } else {
                wordFreq.put(word, wordFreq.get(word)+1);
            }
            for (Map.Entry<String, Integer> entry: wordFreq.entrySet()) {
                if (!bannedSet.contains(entry.getKey())) {
                    if (entry.getValue() > maxCount) {
                        maxCount = entry.getValue(); 
                        result = entry.getKey();
                    }                        
                }
            }
        }  
        
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", 
				new String[]{"hit"}));
	}
}
