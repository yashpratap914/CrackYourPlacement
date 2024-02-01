class Solution {
    private static final String[] LETTERS = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        generateCombinations(digits, 0, "", combinations);
        return combinations;
        
    }
    
    private void generateCombinations(String digits, int index, String current, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = LETTERS[digit - '0'];
        for (char letter : letters.toCharArray()) {
            generateCombinations(digits, index + 1, current + letter, combinations);
        }
    }
}