//package twilioPrep;
//
///******************************************************************************
// * name: Donna Gabai netID: dgabai precept: P99
// * 
// * Description: PokerHand data type. Can construct a hand from standard input,
// * format a hand for output, determine if a hand is a flush or a full house.
// * Test main() sets up 5-card poker hands from standard input, prints flushes
// * and full houses (one per line).
// * 
// * Dependencies: StdIn, StdOut
// */
//
//public class PokerHand {
//	// class constants
//	private static final int HANDSIZE = 5; // 5 cards per hand
//
//	// instance variables
//	private String[] hand; // each String is one card
//
//	// constructor reads a 5-card poker hand from StdIn
//	public PokerHand() {
//		hand = new String[HANDSIZE];
//		for (int i = 0; i < HANDSIZE; i++) {
//			hand[i] = StdIn.readString();
//		}
//
//		// sort the hand, note Queen is higher than King!
//		// Ten is highest of all!
//		// 2, 3, 4, 5, 6, 7, 8, 9, A, J, K, Q, T
//		java.util.Arrays.sort(hand);
//
//	}
//
//	// is this hand a flush?
//	public boolean flush() {
//		// looking for suit (last character) all the same
//		char suit = hand[0].charAt(1);
//		for (int i = 1; i < HANDSIZE; i++) {
//			if (suit != hand[i].charAt(1))
//				return false;
//		}
//		// made it through! ALL EQUAL!
//		return true;
//	}
//
//	// is this hand a full house?
//	public boolean fullHouse() {
//		// looking for 3 matching and 2 matching
//		// since hand is sorted, first and last will be different
//		// first card
//		char rank1 = hand[0].charAt(0);
//		int sumRank1 = 1;
//		// last card
//		char rank2 = hand[HANDSIZE - 1].charAt(0);
//		int sumRank2 = 1;
//		// count cards similar to first and last cards
//		for (int i = 1; i < HANDSIZE - 1; i++) {
//			if (hand[i].charAt(0) == rank1)
//				sumRank1++;
//			if (hand[i].charAt(0) == rank2)
//				sumRank2++;
//		}
//
//		// is it a full house?
//		if (sumRank1 == 3 && sumRank2 == 2)
//			return true;
//		if (sumRank1 == 2 && sumRank2 == 3)
//			return true;
//		// no full house :(
//		return false;
//	}
//
//	// string representation of this hand sorted
//	public String toString() {
//		String wholeHand = "";
//		for (int i = 0; i < HANDSIZE; i++)
//			wholeHand = wholeHand + hand[i] + " ";
//		return wholeHand;
//	}
//
//	// test main
//	public static void main(String[] args) {
//		// input one hand at a time
//		// output it if it is a flush or full house
//		while (!StdIn.isEmpty()) {
//			PokerHand ph = new PokerHand();
//			if (ph.flush())
//				StdOut.println("     Flush: " + ph);
//			if (ph.fullHouse())
//				StdOut.println("Full house: " + ph);
//		}
//	}
//}