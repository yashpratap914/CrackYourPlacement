class Solution {
    int max = 0;

    private void solveBacktracking(Set<String> set, String s, int idx) {
        // Base Case
        if (idx >= s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        // BackTracking
        for (int i = idx + 1; i <= s.length(); i++) {
            String sub_str = s.substring(idx, i);
            // here we start adding the substring of string(s)
            // if we get success in adding it then we just
            // move the pointer to i for next sucess
            // while returning back just remove the last putted substring
            // from the Set
            if (set.add(sub_str)) {
                solveBacktracking(set, s, i);
                set.remove(sub_str);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        solveBacktracking(new HashSet<>(), s, 0);
        return max;
    }
}