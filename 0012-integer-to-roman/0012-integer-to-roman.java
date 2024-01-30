class Solution {
    public String intToRoman(int num) {
        // Create arrays to store the Roman numeral symbols and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        // Iterate through the values array
        for (int i = 0; i < values.length; i++) {
            // While the current value is less than or equal to the input number
            while (num >= values[i]) {
                // Append the corresponding symbol to the StringBuilder
                sb.append(symbols[i]);
                // Subtract the value from the input number
                num -= values[i];
            }
        }
        
        // Convert the StringBuilder to a String and return it
        return sb.toString();
        
    }
}