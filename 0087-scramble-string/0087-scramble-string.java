class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length() )
        return false;
        if(s1 == s2 )
        return true;
        HashMap<String,Boolean> hm = new HashMap<>();
        boolean ans = f(s1,s2,hm);
        return ans;
    }
    
    public boolean f(String a, String b,HashMap<String,Boolean> hm)
    {
        if(a.equals(b))
        return true;
        if(a.length() <= 1)
        return false;
        boolean flag = false;
        int n = a.length();
        String s = a+"*"+b;
        if(hm.containsKey(s))
        return hm.get(s);
    
        for(int i = 1;i<n;i++)
        {
            boolean swap = f(a.substring(0,i),b.substring(n-i),hm) && f(a.substring(i),b.substring(0,n-i),hm);
            boolean unswap = f(a.substring(0,i),b.substring(0,i),hm) && f(a.substring(i),b.substring(i),hm);
            if(swap || unswap)
            {
               flag = true;
               break;
            }
        }
        hm.put(s,flag);
        return flag;
        
    }
}