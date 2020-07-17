package leetcodeContests.contest186;

public class MaxPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {        
        // steps
        // calculate sum until n-k
        // total-sum is the diff if k=0 diff=total we pick everything
        // keep left at 0 and right at n-k
        // keep removing item from left and add it to right and check if we get maxDiff
        // return diff.
        
        int n = cardPoints.length;
        int total = 0, sum=0;
        for (int i=0; i<n-k; i++)
            sum+=cardPoints[i]; // 10
        for (int i=0; i<n; i++)
            total+=cardPoints[i]; // 22
        int diff = total-sum; // 12
        
        int right = n-k; // 4
        int left = 0; // 0
        
        while(right > 0 && right<n) {
            sum-=cardPoints[left]; 
            sum+=cardPoints[right];
            diff = Math.max(diff, total-sum);
            left++;
            right++;
        }
        
        
        return diff;       
    }
    
	public int maxScoreWrong(int[] cardPoints, int k) {
		// cardPoints = [1,2,3, 4, 5,6,1], k = 3
		// 0,1 1 1 100 4 2 5 1 // 1, 2,3, 4, 5,6,
		// 4

		// steps

		int left = 0;
		int score = 0;
		int right = cardPoints.length - 1;
		while (left <= right && k > 0) {
			if (right==8) {
				System.out.println(right);
			}
			int i = left, j = right;
			int counter = k;
			int leftScore = 0;
			int rightScore = 0;			
			while (counter > 0) {				
				leftScore += cardPoints[i];
				rightScore += cardPoints[j];
				i++;
				j--;
				counter--;
			}

			if (leftScore > rightScore) {
				score += cardPoints[left];
				System.out.println("left" + " " + left);
				left++;

			} else {
				score += cardPoints[right];
				System.out.println("right" + " " + right);
				right--;

			}

			k--;
		}

		return score;

	}

	public static void main(String[] args) {
		// [61,16,51,40,37,21,96,70,13,98,28,75,74,87,68,55,95,24,46,87]

		int[] cardPoints = new int[] { 61, 16, 51, 40, 37,  21, 96, 70, 13,      98, 28, 75, 74, 87, 68, 55, 95, 24, 46, 87 };
		// System.out.println(cardPoints.length);

		System.out.println(new MaxPointsFromCards().maxScore(cardPoints, 19));
	}
}
