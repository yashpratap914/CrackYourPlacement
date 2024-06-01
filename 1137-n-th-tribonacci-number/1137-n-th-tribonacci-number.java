class Solution {
    public int tribonacci(int n) {
        if (n < 2) return n;
        else if(n==2) return 1;
        int fterm = 0;
        int sterm = 1;
        int tterm = 1;
        
        for(int i=1; i<n; i++){
            int foterm = fterm + sterm + tterm;
            fterm = sterm;
            sterm = tterm;
            tterm = foterm;
        }
        return sterm;
        
        
        
    }
}