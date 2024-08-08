class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on the start time (first element of each interval)
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        
        // Step 2: Initialize an ArrayList to store the merged intervals
        ArrayList<int[]> ans = new ArrayList<>();
        
        // Step 3: Initialize the start and end of the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        // Step 4: Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0]; // Start of the current interval
            int e = intervals[i][1]; // End of the current interval
            
            // Step 5: Check if the current interval overlaps with the previous one
            if (s <= end) {
                // If it overlaps, merge the intervals by updating the end to the maximum end value
                end = Math.max(end, e);
            } else {
                // If it doesn't overlap, add the previous interval to the list
                ans.add(new int[]{start, end});
                // Update start and end to the current interval
                start = s;
                end = e;
            }
        }
        
        // Step 6: Add the last interval to the list after exiting the loop
        ans.add(new int[]{start, end});
        
        // Step 7: Convert the ArrayList to a 2D array and return it
        return ans.toArray(new int[0][]);
    }
}
