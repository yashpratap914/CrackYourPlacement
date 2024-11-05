class Solution {
    public int minChanges(String s) {
        // Two Sucessive character should to same
        // inoder to maintain the order to fulfill the result
        int res = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
        
    }
}