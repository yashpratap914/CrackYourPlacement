class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        else if(n==1) return 1;
        int fterm = 0;
        int secterm = 1;
        
        for (int i =1; i<n; i++){
            int thirdterm = fterm + secterm;
            fterm = secterm;
            secterm = thirdterm;
        }
        return secterm;
        
    }
}