class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //multiple anagram based groups
        // sort the string in groups
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            //Sorting: we cannot directly sort the string but we can make char array
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray); // sorted
            String sorted = new String(charArray); // comparator of string class -> key
            if(!map.containsKey(sorted)){
                map.put(sorted, new LinkedList<String>()); // put new sorted key in map
            }
            map.get(sorted).add(s); //LL mei add krdiya if key is same
            
        }
        return new LinkedList<>(map.values());  
        
        
    }
}