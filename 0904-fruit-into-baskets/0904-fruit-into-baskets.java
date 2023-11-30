class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int end = 0;
        int maxFruits = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        
        for (end = 0; end < fruits.length; end++) {
            fruitCount.put(fruits[end], fruitCount.getOrDefault(fruits[end], 0) + 1);
            
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[start], fruitCount.get(fruits[start]) - 1);
                if (fruitCount.get(fruits[start]) == 0) {
                    fruitCount.remove(fruits[start]);
                }
                start++;
            }
            
            maxFruits = Math.max(maxFruits, end - start + 1);
        }
        
        return maxFruits;
        
    }
}