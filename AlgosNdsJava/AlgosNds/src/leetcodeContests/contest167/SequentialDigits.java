package leetcodeContests.contest167;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigitsHack(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int[] allSeqNums = new int[]{
                12,23,34,45,56,67,78,89,
                123,234,345,456,567,678,789,
                1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,
                123456,234567,345678,456789,
                1234567,2345678,3456789,
                12345678,23456789,
                123456789            
            };
        for (int i=0; i<allSeqNums.length; i++) {
            if (allSeqNums[i]<low)
                continue;
            if (allSeqNums[i]>high)
                break;
            res.add(allSeqNums[i]);
        }
        return res;            
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int digit = 1; digit < 9; ++digit) {
            int next = digit, n = next;
            //100 //300
            //next = 1 // n = 1
            while (n <= high && next < 10) {
                if (n >= low) {
                    res.add(n);
                }
                int n1 = n * 10 + ++next; // 
                if (n1 > n) {
                    n = n1;
                }else { // Integer overflow.
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;        
    }
    
    public static void main(String[] args) {
		System.out.println(new SequentialDigits().sequentialDigits(100, 300));
	}
}
