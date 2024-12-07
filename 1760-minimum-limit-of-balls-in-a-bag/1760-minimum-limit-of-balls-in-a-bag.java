class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int a=1,b=1_000_000_000;
        while(a<=b) {
            int mid=(a+b)>>1;
            if(check(mid,maxOperations,nums)) b=mid-1;
            else a=mid+1;
        }
        return a;
    }
    boolean check(int mid, int maxOperations, int[] nums) {
        int op=0;
        for(int i=nums.length-1;i>-1&&op<=maxOperations;i--) {
            int next=nums[i];
            if(next<=mid) return true;
            op+=(next-1)/mid;
        }
        return op<=maxOperations;
    }
}