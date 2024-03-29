class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi=0,count=0;
        for(int i=0;i<nums.length;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }
        long ans=0;
        for(int i=0,j=0;i<nums.length;i++)
        {
            if(nums[i]==maxi)
            {
                count++;
            }
            while(count>=k)
            {
                ans=ans+(long)(nums.length-i);
                if(nums[j]==maxi)
                {
                    count--;
                }
                j++;
            }
        }
        return ans;
    }
}