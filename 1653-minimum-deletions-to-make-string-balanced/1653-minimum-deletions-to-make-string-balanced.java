class Solution {
    public int minimumDeletions(String s) {
        int a=0, b=0;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='b'){
                b++;
            }
            else if(s.charAt(i)=='a' && b>a){
                a++;
            }
        }
        return a;
    }
}