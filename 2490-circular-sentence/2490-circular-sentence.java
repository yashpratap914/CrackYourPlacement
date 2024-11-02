class Solution {
    public boolean isCircularSentence(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            while (i + 1 < n && s.charAt(i + 1) != ' ') {
                i++;
            }
            if (i + 1 >= n) {
                break;
            }
            if (s.charAt(i) != s.charAt(i + 2)) {
                return false;
            }
            i += 2;
        }

        return s.charAt(0) == s.charAt(n - 1);
        
    }
}