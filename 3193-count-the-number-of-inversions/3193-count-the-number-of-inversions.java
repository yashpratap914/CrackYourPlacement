class Solution {
    static int mod = 1_000_000_007;
    static Integer[][] dp;
    public int numberOfPermutations(int n, int[][] requirements) {
        dp = new Integer[n + 1][n * (n - 1) / 2 + 1];
        Arrays.sort(requirements, (a, b) -> a[0] - b[0]);
        for (int[] r : requirements) {
            if (count(r[0], r[1]) == 0) {
                return 0;
            }
            // enforce the current req
            for (int i = 0; i < dp[r[0]].length; i++) {
                if (i != r[1]) {
                    dp[r[0]][i] = 0;
                }
            }
        }
        int[] last = requirements[requirements.length - 1];
        return dp[last[0]][last[1]];
    }
    
    static int count(int pos, int inv) {
        if (inv < 0) {
            return 0;
        }
        if (pos == 0) {
            return inv == 0 ? 1 : 0;
        }
        if (dp[pos][inv] != null) {
            return dp[pos][inv];
        }
        int res = 0;
        for (int i = 0; i <= pos; i++) {
            res = (res + count(pos - 1, inv - i)) % mod;
        }
        return dp[pos][inv] = res;
        
    }
}