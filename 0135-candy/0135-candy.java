import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 0;
        List<Integer> left = new ArrayList<>(n);
        List<Integer> right = new ArrayList<>(n);
        
        // Initialize left and right lists with 1 candy for each
        for (int i = 0; i < n; i++) {
            left.add(1);
            right.add(1);
        }
        
        // Fill left list
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left.set(i, left.get(i - 1) + 1);
            }
        }
        
        // Fill right list
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right.set(i, right.get(i + 1) + 1);
            }
        }
        
        // Calculate the total number of candies
        for (int i = 0; i < n; i++) {
            int maxCandies = Math.max(left.get(i), right.get(i));
            sum += maxCandies;
        }
        
        return sum;
    }
}
