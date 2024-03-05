import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        
        merged.add(currentInterval);
        
        return merged.toArray(new int[merged.size()][]);
        
    }
}