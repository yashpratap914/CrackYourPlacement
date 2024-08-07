class Solution {
    String[] lessThan_20 = { "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };
    String[] thousands = { "", "Thousand", "Million", "Billion" };

    private String helper(int n) {
        // Edge or Base Case
        if (n == 0)
            return "";

        if (n < 20)
            return lessThan_20[n] + " ";
        else if (n < 100)
            return tens[n / 10] + " " + helper(n % 10);
        else
            return lessThan_20[n / 100] + " Hundred " + helper(n % 100);
    }

    public String numberToWords(int num) {
        // Edge or Cornor Case
        if (num == 0)
            return "Zero";

        int i = 0;
        String word = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + thousands[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }
}