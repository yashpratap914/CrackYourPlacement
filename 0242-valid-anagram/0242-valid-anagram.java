class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch,0)+1);
        }    
        for(int j=0; j<t.length(); j++){
            char ch1 = t.charAt(j);
            if(!mp.containsKey(ch1)){
                return false;
            }
            else if(mp.get(ch1)==1){
                mp.remove(ch1);
            }
            else{
                mp.put(ch1, mp.get(ch1)-1);
            }
        }
        return mp.size()==0;
    }
}