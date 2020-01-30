package leetcodeContests.contest159;

public class StraightLine {
	 public boolean checkStraightLine(int[][] coordinates) {
	        float x1 = (float) coordinates[0][0];
	        float y1 = (float)coordinates[0][1];
	        float x2 = (float)coordinates[1][0];
	        float y2 = (float)coordinates[1][1];
	        float slope = (y2-y1) / (x2-x1);
	        
	        for (int i=1; i<coordinates.length-1; i++) {
	        	float a1 = (float)coordinates[i][0];
	        	float b1 = (float)coordinates[i][1];
	        	float a2 = (float)coordinates[i+1][0];
	        	float b2 = (float)coordinates[i+1][1];
	                float currentSlope = (b2-b1) / (a2-a1);
	                if (slope!=currentSlope)
	                    return false;
	        }
	        return true;
	        
	    }
	 public static void main(String[] args) {
		 //[[-3,-2],[],[2,-2],[-2,-2],[0,-2]]
		 // [[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]
		 int[][] coordinates = new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
		 System.out.println(new StraightLine().checkStraightLine(coordinates));
		// System.out.println(-2-(2);
	}
}
