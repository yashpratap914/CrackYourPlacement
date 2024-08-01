class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Brute Force: each row:(1-9) -> no repetition
        // each column: each column:(1-9) -> no repetition
        // Each nine 3X3 sub boxes -> (1-9) -> no repetition
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char number = board[i][j];
                
                if(number != '.'){
                    String str1 = number + " in row " + i;
                    String str2 = number + " in column " + j;
                    String str3 = number + " in block " + i/3 + "-" + j/3;
                    
                    if(set.contains(str1) || set.contains(str2) || set.contains(str3)){
                        return false;
                    }else{
                        set.add(str1);
                        set.add(str2);
                        set.add(str3);
                    }
                    
                }
            }
        }
        
        return true;
    }
}