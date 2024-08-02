class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> mp = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        String[] arr = s.split(" "); //split word string into array
        int n = arr.length;
        if(n!=pattern.length()){ //word arrlength == string length 
            return false;
        }
        for(int i=0; i<n; i++){
            String word = arr[i];
            char ch = pattern.charAt(i);
            
            if(mp.containsKey(ch)){ //if char is already in map 
                if(!mp.get(ch).equals(word)){ //and current value not equal to value already present
                    return false;
                }
            }
            else{  //if char is not already in map 
                if(set.contains(word)){ //val associated with else
                    return false;
                }
                else{ // if totally new val-word pair add
                    mp.put(ch, word);
                    set.add(word);
                }
            }
        }
        return true;
    }
}