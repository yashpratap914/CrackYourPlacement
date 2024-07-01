class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
         int n = arr.length;
        int count = 0;
        int k = 3;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {  // Check if the element is odd
                count++;
                if (count >= k) {  // Check if we have found three consecutive odd numbers
                    return true;  // Return true immediately
                }
            } else {
                count = 0;  // Reset the count if the element is not odd
            }
        }
        
        return false;
        
    }
}