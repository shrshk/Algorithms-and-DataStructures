package datastructures.bestpractices;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// imagine processing a file with auctions and we want to 3 cars with maximum price
// instead of processing the file and saving it to a list and then sorting the entire list
// use a priority queue
// if we want an entire list Collections.sort on a list is more efficient but when 
// we are only interested in top few elements I'd use a Priority Queue.


public class UsePriorityQueue {
	static PriorityQueue<Auction> auctionQ;	
	public static void main(String[] args) {
		int k = 3;
		Comparator<Auction> maxPrice =
		         Comparator.comparing(Auction::getPrice, Collections.reverseOrder());
		auctionQ = new PriorityQueue<>(maxPrice);
		auctionQ.add(new Auction(30000, "Audi"));
		auctionQ.add(new Auction(20000, "BMW"));
		auctionQ.add(new Auction(20000, "Toyota"));
		auctionQ.add(new Auction(30000, "Tesla"));
		auctionQ.add(new Auction(20000, "Cadillac"));
		
		while(!auctionQ.isEmpty() && k > 0) {
			System.out.println(auctionQ.poll().toString());
			k--;
		}
		
	}
}
