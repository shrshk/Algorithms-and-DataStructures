package golmansachs.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SubArraySumAtLeastK {
    public int shortestSubarrayNW(int[] A, int K) {
        // steps
        // slide window + hashMap        
        int n = A.length;
        int i=0;
        int j=i;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(i<n && j<n) {
             sum += A[j];
             if (set.contains(sum-K)) {
                 res = Math.min(res, j-i+1);
                 set = new HashSet<>();
                 set.add(0);
                 i++;
                 j=i;
             } else {
                 j++;
             }
            set.add(sum-K);
        }
        
        return res;       
        
    }
    
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) 
        	B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
    
    public int shortestSubarrayExplained(int[] A, int K) {
        //Shortest Subarray with Sum at Least K
        int[] sum = new int[A.length+1];
        for(int i=0;i<A.length;i++){
            sum[i+1]=sum[i]+A[i];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        //the key of this stack is to make sure that smaller value will be on top,
        //why ? because any element >= k is valid, so the safest way is start from small  element.
        //if value is the same or larger, make sure larger index will remained in the stack
        //why ? because we are looking for shortest length which is valid.
        //just keep this in mind, then we can understand the following cases easily
        deque.offer(0);
        int minLen = Integer.MAX_VALUE;
        for(int i=1;i<sum.length;i++){
            //case 1:
            //current element is smaller than or equal peekFirst
            //just put on the peekFirst, because it is small with a larger index
            //that is exactly what we need!
            if(!deque.isEmpty() && sum[i] <= sum[deque.peekFirst()]){   
                deque.offerFirst(i);
            }else{
                //case 2:
                //current element is larger than peekFirst
                //first we will try to update minLen;
                while(!deque.isEmpty() && sum[i]-sum[deque.peekFirst()]>=K){
                    minLen = Math.min(minLen, i-deque.pollFirst());
                }
                //when we leave first while loop, it means we have following three case:
                if(deque.isEmpty()){   
                    // case 2.1: the stack is empty!
                    deque.offerLast(i);
                }else if(sum[deque.peekFirst()] >= sum[i]){   
                    // case 2.2: current element is smaller than peekFirst,
                    //just put on the peekFirst, because it is small with a larger index
                    //that is exactly what we need!
                    deque.offerFirst(i);
                }else{
                    // case 2.3: sum[i]-sum[deque.peekFirst()] < K, 
                    //since current element is still larger than peekFirst, so we can not put it on the peekFirst
                    //but we can pollLast, as long as it is smaller than peekLast, and with a larger index
                    //exactly what we need!
                    while(!deque.isEmpty() && sum[i]<=sum[deque.peekLast()]){
                        deque.pollLast();
                    }
                    deque.offerLast(i);
                }
            } 
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
    
}
