class Solution {
    static int[][] MOVES = {{1,0},{0,1}};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        Integer dp[][] = new Integer[row][col];
        if(isValid(row, col, row-1, col-1, obstacleGrid))
            dp[row-1][col-1] = 1;
        if(isValid(row, col, 0, 0, obstacleGrid)){
            return calculatePaths(row, col, dp, 0, 0, obstacleGrid);
        }
        
        return 0;
    }

    int calculatePaths(int m, int n, Integer[][] dp, int r, int c, int[][] obstacleGrid) {

        if (dp[r][c] != null)
            return dp[r][c];

        // if(r == m && c == n)
        //     return 1;

        int totalPath = 0;

        for (int[] mv : MOVES) {
            int nr = r + mv[0];
            int nc = c + mv[1];
            if (isValid(m, n, nr, nc, obstacleGrid)) {
                totalPath += calculatePaths(m, n, dp, nr, nc, obstacleGrid);
            }
        }
        return dp[r][c] = totalPath;
    }

    boolean isValid(int m, int n, int nr, int nc, int[][] obstacleGrid) {
        return nr >= 0 && nc >= 0 && nr < m && nc < n && obstacleGrid[nr][nc] == 0;
    }
}