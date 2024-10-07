class Solution {
    public String getPermutation(int n, int k) {
        int sum = 1;
        StringBuilder a = new StringBuilder();
        for(int i = 1; i<=n ; i++){
            sum = sum*i;  
            a.append(i+"");  
        }
        StringBuilder an = new StringBuilder();
        ans(an, a , k , sum);
        return  an.toString();
        
        
    }
    public static StringBuilder ans( StringBuilder an,StringBuilder a , int k , int sum  ){
        if(a.length()==1){
            return an.append(a.charAt(0));
        }
        if(k==0){
            return ans(an.append(a.charAt(a.length()-1)),a.deleteCharAt(a.length()-1) , 0 , sum );
        }
        sum = sum/a.length();
        int i;
        if(k>=sum){
            if(k%sum > 0){
                i = k/sum ;
            }
            else{
                i = k/sum - 1 ;
            }
        }
        else{
            i = 0;
        }
        return ans(an.append(a.charAt(i)),a.deleteCharAt(i) , k%sum , sum );

    }
}