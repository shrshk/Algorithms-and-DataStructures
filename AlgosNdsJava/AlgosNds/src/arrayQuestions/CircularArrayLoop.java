package arrayQuestions;
/*
public static void main(String[] args) {
    int[] loop = {2, -1, 1, 2, 2};
    int[] noloop = {-1, 2};
    System.out.println(circularArrayLoop(loop));
    System.out.println(circularArrayLoop(noloop));
}

static int nextIndex(int[] nums, int cur) {
  // Get next index based on value taking into account wrapping around
}

static boolean circularArrayLoop(int[] nums) {
    int fast = 0;
    int slow = 0;
    do {
      fast+=2;
      slow++;
      // advance slow cursor once
    } while (fast != slow);
    int next = nextIndex(nums, fast);
    // return if the loop has more than a single element
}
 */

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        boolean found = false;

        for ( int n=0; n<nums.length; n++ ) {
            Integer ps = n;
            Integer pf = next(nums, 0, n);
            int dir = nums[n];

            while ( ps != null && pf != null && ps != pf ) {
                ps = next(nums, dir, ps);
                pf = next(nums, dir, next(nums, dir, pf));
            }

            if ( ps != null && ps == pf ) {
                found = true;
                break;
            }
        }

        return found;
    }

    Integer next(int[] nums, int dir, Integer pos) {
        if ( pos == null ) return null; // null, return null
        if ( dir * nums[pos] < 0 ) return null; // change in direction, return null

        Integer next = (pos + nums[pos]) % nums.length;
        if ( next < 0 ) next += nums.length; // wrap negative

        if ( next == pos ) next = null; // self-pointer, return null
        return next;
    }
}








