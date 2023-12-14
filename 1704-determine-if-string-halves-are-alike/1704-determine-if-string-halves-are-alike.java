class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int countA = 0;
        int countB = 0;
        
        for (int i = 0; i < n / 2; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                countA++;
            }
        }
        
        for (int i = n / 2; i < n; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                countB++;
            }
        }
        
        return countA == countB;
        
    }
}