class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int res = 0;
            int r = i;
            while (r > 0) {
                if ((r & 1) == 1) {
                    res++;
                }
                r = r >> 1;
            }
            arr[i] = res;
        }
        return arr;
    }
}