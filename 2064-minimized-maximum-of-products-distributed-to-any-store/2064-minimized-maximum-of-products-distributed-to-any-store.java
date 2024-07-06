class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int st =1; //to avoid div by zero
        int end = Integer.MIN_VALUE;
        
        for(int i =0; i<quantities.length; i++){
            if(quantities[i]>end){
                end= quantities[i];
            }
        }
        int ans =-1;
        
        while(st<=end){
            int mid = st + (end-st)/2;
            if(isokay(quantities, mid, n)){
                ans = mid;
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }
    
    boolean isokay(int[] quantities, int maxprod, int n){
        
        int storecount =0;
        for(int i=0; i<quantities.length; i++){
            storecount += quantities[i]/maxprod;
            if(quantities[i]%maxprod!=0){
                storecount+=1;
            }
            if(storecount>n){
                return false;
            }
        }
        return true;
        
    }
}