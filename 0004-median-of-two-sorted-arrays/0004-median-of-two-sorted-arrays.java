class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //num1 -> smaller(assume)
        
        if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2, nums1);
        } //used recursion
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int N = n1+n2;
        int st =0;
        int end = n1;
        
        while(st<=end){
            int cut1 = st + (end - st)/2; //mid
            //cut2 = (total/2) - cut1 here we will be making it on second array as a result of our requirement
            int cut2 = (N/2) - cut1;
            //cut2 is cut in second array
            int l1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
            int r1 = (cut1 == n1)?Integer.MAX_VALUE:nums1[cut1];
            int r2 = (cut2 == n2)?Integer.MAX_VALUE:nums2[cut2];

            
            // valid cut or not
            if(l1<=r2 && l2<=r1){
                if(N%2==0){  // even number case median
                    return ((Math.max(l1,l2)+Math.min(r1,r2))/2.0);
                }else{  // odd number case median
                    return (double) Math.min(r1,r2);
                }
            }else if(l1>r2){
                end = cut1 -1;
            }else{
                st = cut1 + 1;
            }
            
            
        }
        return 0.0;
        
    }
}