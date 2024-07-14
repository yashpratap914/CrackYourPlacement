
class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> count = new HashMap<>();
        int i = 0, n = formula.length();
        
        while (i < n) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                stack.push(count);
                count = new HashMap<>();
                i++;
            } else if (c == ')') {
                i++;
                int multiplier = 1;
                if (i < n && Character.isDigit(formula.charAt(i))) {
                    multiplier = parseNumber(formula, i);
                    i += String.valueOf(multiplier).length();
                }
                
                Map<String, Integer> currentCount = count;
                count = stack.pop();
                
                for (String key : currentCount.keySet()) {
                    count.put(key, count.getOrDefault(key, 0) + currentCount.get(key) * multiplier);
                }
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(start, i);
                
                int multiplier = 1;
                if (i < n && Character.isDigit(formula.charAt(i))) {
                    multiplier = parseNumber(formula, i);
                    i += String.valueOf(multiplier).length();
                }
                
                count.put(element, count.getOrDefault(element, 0) + multiplier);
            }
        }
        
        // Construct the result string
        List<String> elements = new ArrayList<>(count.keySet());
        Collections.sort(elements);
        
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element);
            if (count.get(element) > 1) {
                sb.append(count.get(element));
            }
        }
        
        return sb.toString();
    }
    
    private int parseNumber(String formula, int start) {
        int num = 0;
        while (start < formula.length() && Character.isDigit(formula.charAt(start))) {
            num = num * 10 + (formula.charAt(start) - '0');
            start++;
        }
        return num;
        
    }
}