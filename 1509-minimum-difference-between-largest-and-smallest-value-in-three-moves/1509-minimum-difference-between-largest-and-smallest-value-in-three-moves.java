class Solution {
    public int minDifference(int[] arr) {
        int n = arr.length;
        if(n<=4) return 0;
        Arrays.sort(arr);

        int a = arr[n-4]-arr[0];  // killing all largest value
        int b = arr[n-3]-arr[1];  // killing 2 largest and 1 smallest
        int c = arr[n-2]-arr[2];  // killing 1 largest and 2 smallest
        int d = arr[n-1]-arr[3];  // killing all smallest value

        return Math.min(a,Math.min(b,Math.min(c,d)));
        
    }
}