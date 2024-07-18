class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums,0,nums.length-1,temp);
    }
    
    public int mergeSort(int[] nums, int low, int high, int[] temp) {
        int count = 0;
        if(low<high)
        {
            int mid = (low+high)/2;
            count += mergeSort(nums,low,mid,temp); // left portion
            count += mergeSort(nums,mid+1,high,temp); // right portion
            count += merge(nums,low,mid+1,high,temp);
        }
        return count;
    }
    
    public int merge(int[] nums, int low, int mid, int high, int[] temp) {
        int count = 0, x = mid;
        for(int i=low; i<mid; i++)
        {
            while((x<=high) && (nums[i]>2*(long)nums[x])) //checking condition between left array part nd right array part (each left element being checked with each right element)
                x++; // iterating until condition is false
            
            count += x-mid; // adding the number of ele suiting the condition
        }
        
        int i = low, j = mid, k = low;
        while((i<=mid-1) && (j<=high))
        {
            if(nums[i]<=nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        
        while(i<=mid-1)
            temp[k++] = nums[i++];
        
        while(j<=high)
            temp[k++] = nums[j++];
        
        for(i = low; i<=high; i++)
            nums[i] = temp[i];
        
        return count;
    }
}