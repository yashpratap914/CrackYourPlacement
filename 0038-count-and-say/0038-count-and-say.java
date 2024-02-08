class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String previous = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        char digit = previous.charAt(0);
        
        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i) == digit) {
                count++;
            } else {
                sb.append(count);
                sb.append(digit);
                count = 1;
                digit = previous.charAt(i);
            }
        }
        
        sb.append(count);
        sb.append(digit);
        
        return sb.toString();
        
    }
}