class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

       double max = Integer.MIN_VALUE;
       double pre=1,post=1;

       for(int i=0;i<n;i++)
       {
            if(pre == 0) pre =1;
            if(post==0) post =1;

            pre *= nums[i];
            post *= nums[n-i-1];
            max = Math.max(max, Math.max(pre,post));
       }

       return (int)max;
        
    }
}