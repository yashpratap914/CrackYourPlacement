class Solution {
    public boolean isHappy(int n) {
        // Create a set to keep track of the numbers that have already been seen
        Set<Integer> seen = new HashSet<>();
        // Loop until either n becomes 1 (in which case n is a happy number) 
        //                         OR
        //n is seen again (in which case n is not a happy number)

        while (n != 1 && !seen.contains(n)) {
            // Add n to the set of seen numbers
            seen.add(n);
            // Compute the sum of the squares of the digits of n
            int sum = 0;
            while (n != 0) {
                int digit = n % 10; // last dig
                sum += digit * digit; // square of dig
                n /= 10;  // rest dig
            }
            // Update n with the sum of the squares of its digits
            n = sum;
        }
        
        // If n is 1, it is a happy number; otherwise, it is not
        return n == 1;
        
    }
}