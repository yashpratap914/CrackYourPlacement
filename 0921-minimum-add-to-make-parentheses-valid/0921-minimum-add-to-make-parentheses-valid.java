class Solution {
    public int minAddToMakeValid(String s) {
        int set = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> set += 1;
                case ')' -> set -= 1;
            }
            if (set == -1) {
                set += 1;
                res += 1;
            }
        }
        return res + set;
        
    }
}