class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int m=n-k+1;
        int[] arr=new int[m];
        
        // Doing sum of k-1 elements
        int preSum=0;
        for(int l=0; l<k-1; l++){
            preSum +=nums[l];
        }

        int idx=0;
        int prev=0;
        for(int i=0, j=k-1; j<n; i++, j++, idx++){   
            preSum += nums[j]; // Doing sum of new element   
            if( (k*(nums[i]+nums[i]+k-1)/2) == preSum && nums[i]<=nums[j]){
                arr[idx]=nums[j];
            }
            else{
                arr[idx]=-1;
            }                        
            preSum -= nums[i]; // Removing the i'th element for next iteration
        }

        return arr;
        
    }
}