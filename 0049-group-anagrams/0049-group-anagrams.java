class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //multiple anagram based groups
        // sort the string in groups
        Map<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            HashMap<Character, Integer> fmap = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
            }
            if(!map.containsKey(fmap)){
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(fmap, list);
            }
            else{
                ArrayList<String> list = map.get(fmap);
                list.add(s);
            }
        }
        return new ArrayList<>(map.values());  
        
        
    }
}