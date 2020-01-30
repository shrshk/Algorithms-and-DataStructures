package twoSigmaPractice;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {
	Random random;
	int[] wSums;
	
	RandomPickWithWeight(int[] w) {
        this.random = new Random();
        for (int i=1; i<w.length; i++) {
            w[i]+=w[i-1];
        }
        this.wSums = w;
	}
	
    public int pickIndex() {
        int len = wSums.length;
        int indx = random.nextInt(wSums[len-1]) + 1;
        System.out.println("indx" + indx);
        int i = Arrays.binarySearch(wSums, indx);
        System.out.println("i" + indx);
        return i>=0 ? i : -i-1;
    }
	
	public static void main(String[] args) {
		// w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
		//System.out.println(new RandomPickWithWeight(new int[]{2,5,3,4}).pickIndex());
		int[] x = new int[]{-1,-2,3,4,7};
		System.out.println(Arrays.binarySearch(x, 6));
	}
}
