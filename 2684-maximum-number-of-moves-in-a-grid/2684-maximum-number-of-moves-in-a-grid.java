class Solution {
    public int maxMoves(int[][] g) {
        int[][] dp = new int[g.length][g[0].length];
        for(int i=0; i<g.length; i++)
            for(int j=0; j<g[0].length; j++)
                dp[i][j] = -1;
        for(int i=0; i<g.length; i++){
            dp[i][0] = find(g, i, 0, dp);
        }
        int ans = 0;
        for(int i=0; i<g.length; i++){
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
    public int find(int[][] g, int i, int j, int[][] dp){
        if(j==g[0].length-1)    return 0;
        if(dp[i][j] > 0)   return dp[i][j];
        dp[i][j] = 0;
        if(i>0 && j<g[0].length-1 && g[i][j]<g[i-1][j+1]){
            dp[i][j] = Math.max(dp[i][j], 1+find(g, i-1, j+1, dp));
        }
        if(j<g[0].length-1 && g[i][j]<g[i][j+1]){
            dp[i][j] = Math.max(dp[i][j], 1+find(g, i, j+1, dp));
        }
        if(i<g.length-1 && j<g[0].length-1 && g[i][j]<g[i+1][j+1]){
            dp[i][j] = Math.max(dp[i][j], 1+find(g, i+1, j+1, dp));
        }
        return dp[i][j] ;
    }
}