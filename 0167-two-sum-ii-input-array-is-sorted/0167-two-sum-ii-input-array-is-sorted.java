class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int st = 0;
        int end = numbers.length-1;
        int p = 0;
        int q = 0;
        
        while(end>st){
            int sum = numbers[st] + numbers[end];
            if(sum == target){
                p = st;
                q = end;
                break;
            }
            else if(sum < target){
                st++;
            }
            else{
                end--;
            }            
        }
        ans[0]=p+1;
        ans[1]= q+1;
        return ans;        
    }
}