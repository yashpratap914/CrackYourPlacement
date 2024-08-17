class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for(int i =0; i<word.length(); i++){
            char currch = word.charAt(i);
            st.push(currch);
            if(currch == ch){
                while(!st.isEmpty()){
                    res = res + st.pop();
                }
                res = res + word.substring(i+1, word.length());
                return res;
            }
        }
        return word;
    }
}