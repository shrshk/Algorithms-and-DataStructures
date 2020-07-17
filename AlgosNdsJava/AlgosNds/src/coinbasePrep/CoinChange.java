package coinbasePrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CoinChange {
	Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
    public int coinChangeDFS(int[] coins, int amount) {
        if(amount==0)
            return 0;
        if(amountDict.containsKey(amount))
            return amountDict.get(amount);
        int n = amount+1;
        for(int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount-coin);
                if(next >= 0)
                    curr = 1+next;
            }
            if(curr > 0)
                n = Math.min(n,curr);
        }
        int finalCount = (n==amount+1) ? -1 : n;
        amountDict.put(amount,finalCount);
        return finalCount;
    }
    
    private Integer[][] dp;
    public int coinChange2(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins.length == 0)
            return 0;
        dp = new Integer[coins.length][amount + 1];
        int val = changeFrom(amount, coins, 0);
        for (Integer[] x: dp) {
        	System.out.println(Arrays.toString(x));
        }
        return val;
    }
    
    private int changeFrom(int amount, int[] coins, int currentIndex) {
        if (amount == 0)
          return 1;

        if (amount < 0 || currentIndex == coins.length)
          return 0;

        if (dp[currentIndex][amount] != null)
            return dp[currentIndex][amount];
        
        // Recursive call after selecting the coin at the currentIndex
        int sum1 = changeFrom(amount - coins[currentIndex], coins, currentIndex);

        // Recursive call after excluding the coin at the currentIndex
        int sum2 = changeFrom(amount, coins, currentIndex + 1);

        dp[currentIndex][amount] = sum1 + sum2;
        //System.out.println(dp[currentIndex][amount]);
        return dp[currentIndex][amount];
    }
	
	public int coinChange(int[] coins, int amount) {
		// 1 2 5
		// {[186,419,83,408]
		// 6249}
		// 1 2 5
		// 11

		// steps
		// find shortest way to get to final coin in the coinSet
		// start with amount -> end with coin or exhaust all options
		// maintain visited to avoid adding same num again

		if (coins == null || coins.length == 0 || amount == 0)
			return 0;
		Set<Integer> coinSet = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		for (int coin : coins)
			coinSet.add(coin);

		Queue<Integer> q = new ArrayDeque<>();
		int count = 0;
		q.add(amount); // 11
		while (!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int a = q.poll();
				if (coinSet.contains(a))
					return count;
				for (int c : coins) {
					if (a - c > 0 && !visited.contains(a - c)) {
						q.add(a - c);// 10,9,6 9,8,5
						visited.add(a - c);
					}

				}
			}
		}

		return -1;
	}

	public int coinChangeDP(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int[] dp = new int[amount + 1];
		int sum = 0;

		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					if (min < 0 || temp < min)
						min = temp;
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}

//    def coinChange(self, coins, amount):
//        coins.sort(reverse = True)
//        lenc, self.res = len(coins), 2**31-1
//
//        def dfs(pt, rem, count):
//            if not rem:
//                self.res = min(self.res, count) ## Find an solution, compare the count with global count. Maybe refrese the global count.
//            for i in range(pt, lenc):
//                if coins[i] <= rem < coins[i] * (self.res-count): # if hope still exists
//                    dfs(i, rem-coins[i], count+1)
//
//        for i in range(lenc):
//            dfs(i, amount, 0)
//        return self.res if self.res < 2**31-1 else -1

	public static void main(String[] args) {
		int[] coins = new int[] {186,419,83,408};
		// System.out.println(new CoinChange().coinChangeDFS(coins, 6249));
		System.out.println(new CoinChange().coinChange2(2, new int[]{1,2}));
	}
}
