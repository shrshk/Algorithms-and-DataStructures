package datastructures.bestpractices;

import datastructures.bestpractices.Auction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseStreams {
	public static void main(String[] args) {
		List<Auction> auctions = new ArrayList<>(20);
		auctions.add(new Auction(30000, "Audi"));
		auctions.add(new Auction(20000, "BMW"));
		auctions.add(new Auction(20000, "Toyota"));
		auctions.add(new Auction(30000, "Tesla"));
		auctions.add(new Auction(20000, "Cadillac"));

		List<Auction> budgetAuctions = auctions.stream().filter(auction -> isCheap(auction))
				.sorted((auction1, auction2) -> auction1.getDescription().compareTo(auction2.getDescription()))
				// .limit(2)
				.collect(Collectors.toList());
		System.out.println(budgetAuctions);
	}

	private static boolean isCheap(Auction auction) {
		return auction.getPrice() <= 20000;
	}

}
