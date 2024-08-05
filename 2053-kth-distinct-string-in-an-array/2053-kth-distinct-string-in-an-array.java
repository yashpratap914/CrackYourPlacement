class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashSet<String> distinct = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        
        for(int i = 0; i<arr.length; i++){
            if(distinct.contains(arr[i])){
                duplicate.add(arr[i]);
            }
            distinct.add(arr[i]);
        }
        
        for(int i=0; i<arr.length; i++){
            if(!duplicate.contains(arr[i])){
                k-=1;
            }
            if(k==0){
                return arr[i]; 
            }
        }
        return "";
        
    }
}