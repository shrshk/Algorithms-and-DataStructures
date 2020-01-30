package leetcodeContests.contest165;

import java.util.Arrays;

public class TicTacToe {
	
    public String tictactoe(int[][] moves) {
    	// "A" "B" "Draw" "Pending"
    	int[][] grid = new int[3][3];
    	
    	for (int i=0; i<moves.length; i++) {
    		int[] move = moves[i];
    		if (i%2==0)
    			grid[move[0]][move[1]] = 1;
    		else
    			grid[move[0]][move[1]] = 2;
    	}
    	
    	for (int i=0; i<3; i++) {
    		int[] row = grid[i];
    		System.out.println(Arrays.toString(row));
    		int zeroCount = 0;
    		int oneCount = 0;
    		for (int x: row) {
    			if (x==1)
    				zeroCount++;
    			if (x==2)
    				oneCount++;
    		}
    		if (zeroCount==3)
    			return "A";
    		if (oneCount==3)
    			return "B";
    	}
    	
    	for (int i=0;i<3;i++) {
    		int zeroCount = 0;
    		int oneCount = 0;
    		for (int j=0; j<3; j++) {
    			if (grid[j][i]==1) {
    				zeroCount++;
    			}
    			if (grid[j][i]==2) {
    				oneCount++;
    			}
    		}
    		if (zeroCount==3)
    			return "A";
    		if (oneCount==3)
    			return "B";
    	}
    	
    	if (grid[0][0]==1 && grid[1][1]==1 && grid[2][2]==1)
    		return "A";
    	else if (grid[0][2]==1 && grid[1][1]==1 && grid[2][0]==1)
    		return "A";
    	
    	if (grid[0][0]==2 && grid[1][1]==2 && grid[2][2]==2)
    		return "B";
    	else if (grid[0][2]==2 && grid[1][1]==2 && grid[2][0]==2)
    		return "B";
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<3; j++) {
    			if (grid[i][j]==1 || grid[i][j]==2){
    				
    			} else {
    				return "Pending";
    			}
    		}
    	}
    	
    	
        return "Draw";
    }
    
	public static void main(String[] args) {
		// [[0,0],[2,0],[1,1],[2,1],[2,2]]
		// [0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
		int[][] moves = new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
		System.out.println(new TicTacToe().tictactoe(moves));
		
	}
}
