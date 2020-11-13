package bloombergPractice;

public class WordSearch1 {
    public boolean exist(char[][] board, String word) {
        // steps
        // call dfs for every character in the board
        // with a boolean array for visited
        // word found return true else return false
        if (board == null || board.length == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (backtrack("", i, j, visited, board, word, m, n))
                    return true;
            }
        }


        return false;
    }

    private boolean backtrack(String tmp, int i, int j, boolean[][] visited, char[][] board, String word, int m, int n) {
        if (i<0 || j<0 || i>=m || j>=n || visited[i][j])
            return false;
        tmp+=board[i][j];
        if (!word.startsWith(tmp))
            return false;
        if (word.equals(tmp))
            return true;
        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

        visited[i][j] = true;

        for (int[] dir: dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (backtrack(tmp, x, y, visited, board, word, m, n))
                return true;
        }
        visited[i][j] = false;

        return false;
    }
}
