class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circswt = 0;
        int sqswt = 0;
        for(int ch : students){  // freq of sandwiches needed 
            if(ch==0){
                circswt++;
            }else{
                sqswt++;
            }
        }
        for(int swt : sandwiches){
            if(swt == 0 && circswt ==0){  //circular ki chahat wale nhi hain
                return sqswt;
            }
            if(swt == 1 && sqswt ==0){  // square ki chahat wale nhi hain
                return circswt;
            }
            if(swt == 0){   // agar circular aaya toh 
                circswt--;
            }
            else{            // agar square aaya toh 
                sqswt--;
            }
        }
        return 0;
    }
}