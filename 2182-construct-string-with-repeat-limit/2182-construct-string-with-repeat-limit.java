class Solution {
    public String repeatLimitedString(String s, int k) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 25; i >= 0; i--) {
            int freq = a[i]; 
            int count = 0;   

            while (count < freq) {
                int itr = 0;

                // Add the character up to 'k' times or until its remaining frequency is used
                while (itr < k && itr + count < freq) {
                    sb.append((char) (i + 'a'));
                    itr++;
                }

                count += itr; 

                if (count != freq) {
                    int j = i - 1; // Find the next available smaller character
                    while (j >= 0 && a[j] == 0) {
                        j--; 
                    }

                    if (j >= 0) {
                        sb.append((char) (j + 'a'));
                        a[j]--; 
                    } else {
                        // No smaller character available, stop the process
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}