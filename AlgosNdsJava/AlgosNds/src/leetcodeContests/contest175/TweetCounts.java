package leetcodeContests.contest175;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TweetCounts {

	Map<String, List<Integer>> tweetMap;
	Map<String, Integer> times;

	public TweetCounts() {
		tweetMap = new HashMap<>();
		times = new HashMap<>();
		times.put("minute", 60);
		times.put("hour", 3600);
		times.put("day", 86400);
	}

	public void recordTweet(String tweetName, int time) {
		List<Integer> tweetTimes = tweetMap.getOrDefault(tweetName, new ArrayList<>());
		tweetTimes.add(time);
		tweetMap.put(tweetName, tweetTimes);
	}

	public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
		List<Integer> recordTimes = tweetMap.get(tweetName);
		List<Integer> res = new ArrayList<>();
		if (recordTimes.size() == 0)
			return res;
		List<Integer> filteredRecordTimes = recordTimes.stream().filter(item -> item >= startTime && item <= endTime)
				.collect(Collectors.toList());
		Collections.sort(filteredRecordTimes);

		int maxRecordTime = filteredRecordTimes.get(filteredRecordTimes.size() - 1);
		int intervals = maxRecordTime / times.get(freq) + 1;

		int start = startTime;
		int end = startTime + times.get(freq);
		int maxTime = Math.max(times.get(freq), endTime) + times.get(freq);
		int i = 0;
		int intervalStart = 0;
		int count = 0;

		while (intervalStart < intervals && end <= maxTime && i < filteredRecordTimes.size()) {
			Integer time = filteredRecordTimes.get(i);
			
			if (time >= start && time < end) {
				if (res.size()==0)
					res.add(intervalStart, ++count);
				else
					res.set(intervalStart, ++count);					
				i++;
			} else {
				intervalStart++;				
				count = 0;
				res.add(intervalStart, count);
				start = end;				
				end = end + times.get(freq);
			}

		}

		return res;
	}

	public static void main(String[] args) {
		TweetCounts tweetCounts = new TweetCounts();
		tweetCounts.recordTweet("tweet3", 0);
		tweetCounts.recordTweet("tweet3", 60);
		tweetCounts.recordTweet("tweet3", 10);
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute","tweet3",0,59));
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
		tweetCounts.recordTweet("tweet3", 120);
		 System.out.println(tweetCounts.getTweetCountsPerFrequency("hour",
		 "tweet3", 0, 210));

	}
}

/**
 * Your TweetCounts object will be instantiated and called as such: TweetCounts
 * obj = new TweetCounts(); obj.recordTweet(tweetName,time); List<Integer>
 * param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
// int chunks = (int) Math.ceil(filteredRecordTimes.size()/intervalSize)
// ;
// for (int i=0; i<filteredRecordTimes.size(); i+=chunks) {
// List<Integer> subList = filteredRecordTimes.subList(i,
// Math.min(i+chunks, filteredRecordTimes.size()));
// res.add(subList.size());
// }