class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(); // created map with all key nd val
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(s.length() - 1)); // last character read
        for (int i = s.length() - 2; i >= 0; i--) {  // loop from second last character
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) { // if val(character) on left is less than val(character) on right then subtract it from char on right
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i)); // add val(character) on i th index
            }
        }
        return result;
        
    }
}