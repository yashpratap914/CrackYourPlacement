class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int mid = 1; mid<n-1; mid++){ //avoid last and first element
            int leftsmallercount =0;
            for(int i=0; i<mid; i++){
                if(rating[i]<rating[mid]){
                    leftsmallercount++;
                }
            }
            
            int rightgreatercount =0;
            for(int i=mid+1; i<n; i++){
                if(rating[i]>rating[mid]){
                    rightgreatercount++;
                }
            }
            // increasing element count :
            count+= leftsmallercount*rightgreatercount;
            
            // decreasing element count
            int leftgreatercount = mid - leftsmallercount;
            int rightsmallercount = n-mid-1 - rightgreatercount;
            
            count+= leftgreatercount*rightsmallercount;
        }
        return count;
    }
}