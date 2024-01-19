class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
        
    }
    private void generate(String s, int open, int close, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(s);
            return;
        }

        if (open > 0) {
            generate(s + "(", open - 1, close, result);
        }

        if (close > open) {
            generate(s + ")", open, close - 1, result);
        }
    }
}