package leetcodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

class DealerSetting {
	String id;
	String lotId;

	DealerSetting(String id, String lotId) {
		this.id = id;
		this.lotId = lotId;
	}
}

public class Openmate {

	List<DealerSetting> dealers;

	Openmate() {
		dealers = Arrays.asList(new DealerSetting("1", "10"), new DealerSetting("2", "15"), new DealerSetting("2", "10"), 
				new DealerSetting("3", "10"));
	}

	public List<DealerSetting> getFiltered(List<String> ids, List<Pair<String,String>> DealerLots) {
		List<DealerSetting> myDealers = new ArrayList<>();
		for (DealerSetting dealer : dealers) {
			if (ids.contains(dealer.id)) {
				myDealers.add(dealer);
			}
		}
		
		Map<String, List<String>> dealerLotMap = new HashMap<>();
		
		for (Pair<String,String> dealerLot: DealerLots) {
			String openMateDealerId = dealerLot.getKey();
			List<String> lots = dealerLotMap.getOrDefault(openMateDealerId, new ArrayList<>());
			lots.add(dealerLot.getValue());
			dealerLotMap.put(openMateDealerId, lots);
		}

		List<DealerSetting> filtered = new ArrayList<>();

		for (DealerSetting dealer : myDealers) {
			List<String> lotIds = dealerLotMap.get(dealer.id);
			if (lotIds!=null && lotIds.contains(dealer.lotId)) {
				filtered.add(dealer);
				System.out.println(dealer.id);
			}

		}

		return filtered;
	}

	public static void main(String[] args) {
		// dealerId + lotId
		List<String> ids = Arrays.asList("1","2");
		String idType = "openmate,1:10,2:15"; // dealerId:lotId
		String[] tokens = idType.split(",");
		List<Pair<String,String>> dealerLots = new ArrayList<>();
		for (int idx=1; idx<tokens.length; idx++) {
			String[] dealerLot = tokens[idx].split(":");	
			dealerLots.add(new Pair<>(dealerLot[0], dealerLot[1]));
		}
		System.out.println(new Openmate().getFiltered(ids, dealerLots));
	}
}
