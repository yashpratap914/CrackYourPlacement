class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        var ans = 0L;
    Arrays.sort(happiness);

    for (var i=0; i<k; i++)
      ans += Math.max(happiness[happiness.length - 1 - i] - i, 0);
    
    return ans;
        
    }
}