class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int st = Integer.MIN_VALUE;
        int end = 0;
        for(int i =0; i<weights.length; i++){
            end += weights[i];
            if(st<weights[i]){
                st=weights[i];
            }
        }
        int ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(isloadpos(weights, mid, days)){
                ans = mid;
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }
    boolean isloadpos(int[] weights, int maxweight, int days){
        int currday=1;
        int weight =0;
        
        for(int i=0; i<weights.length; i++){
            weight+=weights[i];
            if(weight>maxweight){
                currday+=1;
                weight = weights[i];
            }
            if(currday> days){
                return false;
            }
        }
        return true;    
    }
}