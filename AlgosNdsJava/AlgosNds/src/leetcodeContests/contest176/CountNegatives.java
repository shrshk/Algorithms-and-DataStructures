package leetcodeContests.contest176;

class CountNegatives {
    public int countNegatives(int[][] grid) {
        // [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
        if (grid == null || grid.length==0)
            return 0;
        int m = grid.length;
        int count = 0;
        for (int i=0; i<m; i++) {
            int[] arr = grid[i];
            for (int j=arr.length-1; j>=0; j--) {
                if (arr[j]>=0)
                    break;
                else
                    count++;
            }
        }
        return count;
    }
}
