package amazonPractice;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheet {
	String[][] sheetGrid;
	SpreadSheet(int rows, int columns) {
		sheetGrid = new String[rows][columns];
	}
	
	void updateContents(String input, int[] location) {
		int x = location[0];
		int y = location[1];
		sheetGrid[x][y] = input;		
	}
	
	void printSheet() {
		int rows = sheetGrid.length;
		int columns = sheetGrid[0].length;
		for (int i=0; i<rows; i++) {			
			for (int j=0; j<columns; j++) {
				if (sheetGrid[i][j]==null) {					
					System.out.print("");
				}else{
					System.out.print(sheetGrid[i][j]);
				}
				if (j!=columns-1)
					System.out.print("|");
				
			}
			System.out.print("\n");
		}
	}
	
	void prettyPrint() {
		int rows = sheetGrid.length;
		int columns = sheetGrid[0].length;		
		for (int i=0; i<rows; i++) {
			int widestCellLen = 0;
			Map<Integer, Integer> widest = new HashMap<>();
			for (int j=0; j<columns; j++) {
				if (sheetGrid[i][j].length() > widestCellLen) {
					widestCellLen = sheetGrid[i][j].length();
					widest.put(i, widestCellLen);
				}				
			}
			
			System.out.print("\n");
		}
		
		// { 0: 5, 1:5}
//		for (int i=0; i<rows; i++) {			
//			Map<Integer, Integer> widest = new HashMap<>();
//			for (int j=0; j<columns; j++) {
//				if (sheetGrid[i][j].length() > widestCellLen) {
//					widestCellLen = sheetGrid[i][j].length();
//					widest.put(i, widestCellLen);
//				}				
//			}
//			
//			System.out.print("\n");
//		}
	}
	
	
	public static void main(String[] args) {
		SpreadSheet sheet = new SpreadSheet(4, 3);
		sheet.updateContents("bob", new int[]{0,0});
		sheet.updateContents("10", new int[]{0,1});
		sheet.updateContents("foo", new int[]{0,2});
		sheet.updateContents("alice", new int[]{1,0});
		sheet.updateContents("5", new int[]{1,1});
		sheet.printSheet();
//		sheet.updateContents("", new int[]{1,2});
//		sheet.updateContents("", new int[]{2,0});
//		sheet.updateContents("", new int[]{2,1});
//		sheet.updateContents("", new int[]{2,2});
//		sheet.updateContents("", new int[]{3,0});
//		sheet.updateContents("", new int[]{3,1});
//		sheet.updateContents("", new int[]{3,2});
	}
	
}
