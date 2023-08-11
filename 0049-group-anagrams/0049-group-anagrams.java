class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs){
            char[] ca = word.toCharArray();
            Arrays.sort(ca);
            String str = new String(ca);
            if(!map.containsKey(str))
                map.put(str, new ArrayList<>());
            map.get(str).add(word);
            
        }
        return new ArrayList<>(map.values());
    //TC - O(n klogk) SC- O(nk)   
    }
}