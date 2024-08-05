class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Initialize the chessboard with false (no queens placed)
        boolean[][] board = new boolean[n][n];
        
        // List to store the current board configuration as strings
        List<String> ll = new ArrayList<>();
        
        // List to store all the possible solutions
        List<List<String>> ans = new ArrayList<>();

        // Call the recursive function to place queens
        queens(board, n, 0, ll, ans);
        
        // Return the list of all solutions
        return ans;
    }

    public static void queens(boolean[][] board, int Q, int row, List<String> ll, List<List<String>> ans) {
        // Base case: If all queens are placed
        if (Q == 0) {
            // Convert the current board configuration to a list of strings
            for (int i = 0; i < board.length; i++) {
                String s = "";
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j])
                        s = s + 'Q';
                    else
                        s += '.';
                }
                ll.add(s);
            }
            
            // Add the current configuration to the list of solutions
            ans.add(new ArrayList<>(ll));
            
            // Clear the current configuration list for the next solution
            ll.clear();
            return;
        }

        // Try placing the queen in all columns of the current row
        for (int col = 0; col < board.length; col++) {
            if (possible(board, row, col)) {
                // Place the queen at board[row][col]
                board[row][col] = true;
                
                // Recursively place the rest of the queens
                queens(board, Q - 1, row + 1, ll, ans);
                
                // Backtrack: Remove the queen and try the next column
                board[row][col] = false;
            }
        }
    }

    public static boolean possible(boolean[][] board, int row, int col) {
        int r = row;
        
        // Check the column for another queen
        while (r >= 0) {
            if (board[r][col])
                return false;
            r--;
        }

        r = row;
        int c = col;

        // Check the upper left diagonal for another queen
        while (r >= 0 && c >= 0) {
            if (board[r][c])
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        // Check the upper right diagonal for another queen
        while (r >= 0 && c < board.length) {
            if (board[r][c])
                return false;
            r--;
            c++;
        }

        // If no queens are found in the same column, upper left diagonal, or upper right diagonal, return true
        return true;
    }
}
