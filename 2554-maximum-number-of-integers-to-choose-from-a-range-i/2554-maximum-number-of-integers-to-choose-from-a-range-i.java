class Solution {
    public int maxCount(int[] arr, int n, int maxSum) {
         int k = arr.length;
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<k;i++){
            st.add(arr[i]);
        }
        int sum = 0;
        int count=0;
        for(int i=1;i<=n && sum<=maxSum;i++){
            if(!st.contains(i)){
                sum += i;
                count++;
                if(sum>maxSum){
                    sum -= i;
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}