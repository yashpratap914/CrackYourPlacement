class Solution {
    // Using Depth-First-Search
    private void solveRec(int start, int n, List<Integer> list) {
        // Base Case
        if (start > n) {
            return;
        }

        // solve the number as it allways increase by (start*10+i) 
        list.add(start);
        for (int i = 0; i < 10; i++) {
            int temp = start * 10 + i;
            if (temp > n)
                return;
            else
                solveRec(temp, n, list);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            solveRec(i, n, list);
        }
        return list;
    }
}