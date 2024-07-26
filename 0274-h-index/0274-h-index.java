class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;  // Length of the citations array, representing the total number of papers
        int[] arr = new int[n + 1];  // Create an auxiliary array to count citations; size is n+1 to handle cases where citations exceed the number of papers
        
        // Traverse through each citation count
        for (int c : citations) {
            if (c > n) {  // If the citation count is greater than the number of papers
                arr[n]++;  // Increment the count at the last index, as all such counts are treated as having 'n' citations
            } else {
                arr[c]++;  // Otherwise, increment the count at the index equal to the citation count
            }
        }
        
        int count = 0;  // Initialize a counter to accumulate the number of papers with at least 'i' citations
        
        // Iterate from the highest possible H-Index down to 0
        for (int i = n; i >= 0; i--) {
            count += arr[i];  // Add the number of papers with exactly 'i' citations to the counter
            
            // If the number of papers with at least 'i' citations is at least 'i', then 'i' is the H-Index
            if (count >= i) {
                return i;  // Return the current H-Index value
            }
        }
        
        return 0;  // If no valid H-Index is found, return 0
    }
}
