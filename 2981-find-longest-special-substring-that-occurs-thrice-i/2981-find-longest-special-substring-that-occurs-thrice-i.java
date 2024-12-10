class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) { 
                String str = s.substring(i, j);
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
        int len = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String str = e.getKey();
            int val = e.getValue();
            if (val >= 3) {
                HashSet<Character> set = new HashSet<>();
                for (int j = 0; j < str.length(); j++) {
                    set.add(str.charAt(j));
                }
                if (set.size() == 1) { // Corrected condition
                    len = Math.max(len, str.length());
                }
            }
        }
        return (len == 0) ? -1 : len;
    }
}