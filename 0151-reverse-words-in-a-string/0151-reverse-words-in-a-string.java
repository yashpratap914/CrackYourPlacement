class Solution {
    public String reverseWords(String s) {
        String[] w = s.split("\\s+"); // split on basis of spaces
        StringBuilder sb = new StringBuilder(""); // gain n again +
        
        for(int i = w.length-1; i>=0;i--){
            
            sb.append(w[i]+" ");
        }
        
        //trim func -> remove trailing nd leading spaces
        String ans = sb.toString();
        ans = ans.trim();
        
        return ans;
        
    }
}