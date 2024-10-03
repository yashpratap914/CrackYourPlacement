class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // If the combination is done (i.e., we've picked k numbers)
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));  // Add a copy of the current combination to the result list
            return;
        }
        
        // Try all numbers from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            tempList.add(i);  // Pick the number
            backtrack(result, tempList, i + 1, n, k);  // Recursively pick the next number
            tempList.remove(tempList.size() - 1);  // Remove the last picked number to try another possibility
        }
    }
}