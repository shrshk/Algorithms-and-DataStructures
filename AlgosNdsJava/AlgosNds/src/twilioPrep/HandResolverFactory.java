package twilioPrep;

import java.util.Arrays;
import java.util.List;

public class HandResolverFactory {
	static List<HandResolver> handResolverList;
	
	HandResolverFactory() {
		handResolverList = Arrays.asList(
				new RoyalFlushResolver(),
				new StraightFlushResolver(),
				new FourOfAKindResolver()
				);
	}
 
//    public static List<HandResolver> getHandResolverList() {
//        return handResolverList;
//    }
	
	public static int resolveHand(String[] hand) {
		for (HandResolver resolver: handResolverList) {
			int handValue = resolver.resolve(hand);
			if (handValue>0)
				return handValue;
		}
		return 0;
	}
}
