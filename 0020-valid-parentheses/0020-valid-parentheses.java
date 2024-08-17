class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){ //empty or odd length rejected
            return false;
        }
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i =0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch =='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.peek();
                if(ch == ')' && top !='('){
                    return false;
                }
                else if(ch == '}' && top !='{'){
                    return false;
                }
                else if(ch == ']' && top !='['){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return (st.size() == 0);
    }
}