package twilioPrep;

public class PokerHands {

	public String[] winningHand(String[] hand1, String[] hand2) {
		// ['SA', 'SK', 'SQ', 'SJ', 'S10'] RF

		// ['SJ', 'S10', 'S9', 'S8', 'S7'] SF

		// ['SJ', 'H10', 'HJ', 'CJ', 'DJ'] 4K
		// ['SJ', 'H10', 'CJ', 'C10','DJ'] FH
		// ['S2', 'S3', 'S4', 'S5', 'SK'] Flush
		// ['S2', 'H3', 'H4', 'C5', 'D6'] St.
		// ['S2', 'S3', 'S4', 'C2', 'D2'] 3K
		// ['S2', 'S3', 'S4', 'C2', 'D3'] 2Pair

		// ['S2', 'HJ', 'HQ', 'C2', 'D4'] pair

		// ['HA', 'D2', 'D3', 'D4', 'D5'] highcard

		return HandResolverFactory.resolveHand(hand1) < HandResolverFactory.resolveHand(hand2) ? hand1 : hand2;
	}

	public static void main(String[] args) {

	}
}
