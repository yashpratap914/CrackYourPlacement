class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> mp1 = new HashMap<>();
        for(int ele: target){
            mp1.put(ele, mp1.getOrDefault(ele,0)+1); 
        }
        
        HashMap<Integer,Integer> mp2 = new HashMap<>();
        for(int ele: arr){
            mp2.put(ele, mp2.getOrDefault(ele,0)+1); 
        }
        for(int key: mp1.keySet()){
            if(!mp2.containsKey(key)){
                return false;
                
            }
            if(mp1.get(key)!=mp2.get(key)){
                return false;
            }
        }
        return true;
        
    }
}