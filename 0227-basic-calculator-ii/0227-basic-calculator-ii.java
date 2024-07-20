class Solution {
    // Method to evaluate the arithmetic expression given in string 's'
    public int calculate(String s) {
        // If the input string is null or empty, return 0 as the result
        if(s == null || s.length() == 0) return 0;
        
        // Create a Stack to store intermediate results and manage operations
        Stack<Integer> st = new Stack<>();
        
        // Initialize the current number being processed and the last operation
        int curr = 0;
        char op = '+';
        
        // Convert the input string to a character array for easy processing
        char[] ch = s.toCharArray();
        
        // Iterate over each character in the character array
        for(int i = 0; i < ch.length; i++){
            // If the character is a digit, update the current number
            if(Character.isDigit(ch[i])){
                curr = curr * 10 + ch[i] - '0';  // Construct the full number from multiple digits
            }
            
            // If the character is not a digit or it's the end of the string, process the current number
            if(!Character.isDigit(ch[i]) && ch[i] != ' ' || i == ch.length - 1){
                // Depending on the last operation, perform the corresponding arithmetic
                if(op == '+'){
                    st.push(curr);  // Add the current number to the stack
                }
                else if(op == '-'){
                    st.push(-curr); // Subtract the current number (by pushing its negative value)
                }
                else if(op == '*'){
                    // Pop the last number from the stack, multiply it by the current number, and push the result back
                    st.push(st.pop() * curr);
                }
                else if(op == '/'){
                    // Pop the last number from the stack, divide it by the current number, and push the result back
                    st.push(st.pop() / curr);
                }
                
                // Update the operation to the current character (which should be an operator)
                op = ch[i];
                // Reset the current number to zero for the next number
                curr = 0;
            }
        }
        
        // Initialize a variable to accumulate the final result
        int sum = 0;
        
        // Sum up all values left in the stack
        while(!st.isEmpty()){
            sum += st.pop();
        }
        
        // Return the final computed result
        return sum;
    }
}
