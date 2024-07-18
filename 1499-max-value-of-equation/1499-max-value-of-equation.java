class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // The function takes an array of points (each point is an array of two integers) and an integer k.
        // It returns the maximum value of the equation yi + yj + |xi - xj| such that |xi - xj| <= k and j > i.

        int ans = Integer.MIN_VALUE;
        // Initialize the answer to the smallest possible integer value.

        int i = 0;
        // Start with the first point in the array.

        int f = 1;
        // Initialize a variable f to be 1, which will be used to track the next point to consider for the equation.

        while(i < points.length) {
            // Loop through each point in the array using the variable i.

            if(f < i + 1)
                f = i + 1;
            // Ensure f is always ahead of i by at least 1. This ensures j > i.

            for (int j = f; j <= points.length - 1; j++) {
                // Loop through the points starting from f to the end of the array.

                if(points[j][0] > (points[i][0] + k))
                    break;
                // If the x-coordinate of point j is greater than the x-coordinate of point i plus k, break the loop.
                // This means |xi - xj| > k, and we can't use this pair.

                if((points[i][1] + points[j][1] + points[j][0] - points[i][0]) > ans) {
                    ans = points[i][1] + points[j][1] + points[j][0] - points[i][0];
                    // Calculate the value of the equation yi + yj + |xi - xj| (since xi <= xj, |xi - xj| = xj - xi).
                    // If this value is greater than the current answer, update the answer.

                    f = j - 1;
                    // Update f to j - 1. This is to optimize the inner loop by reducing the number of comparisons.
                }
            }
            i++;
            // Move to the next point in the array.
        }

        return ans;
        // Return the maximum value found.
    }
}
