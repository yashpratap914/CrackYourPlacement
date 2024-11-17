class Pair
{
    int index;
    long value;
    Pair(int index, long value)
    {
        this.index = index;
        this.value = value;
    }
}
class Solution 
{
    public int shortestSubarray(int[] nums, int k) 
    {
        int n = nums.length;
        Deque<Pair> dq = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        long sum = 0;

        for(int i = 0; i < n; i++)
        {
            sum += nums[i];

            // Keep dq in incrementing order
            while(!dq.isEmpty() && sum <= dq.peekLast().value) dq.removeLast();

            // Add current sum and index
            dq.add(new Pair(i,sum));

            // Calculate your answer here
            if(sum >= k) ans = Math.min(ans, i + 1);

            // Check if Contraction is possible or not
            while(!dq.isEmpty() && sum - dq.peekFirst().value >= k)
            {
                ans = Math.min(ans, i - dq.peekFirst().index);
                dq.removeFirst();
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}