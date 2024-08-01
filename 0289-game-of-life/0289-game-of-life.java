class Solution {
    public void gameOfLife(int[][] board) {
        int[][] clone =  new int[board.length][board[0].length]; // clone array
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                clone[i][j] = board[i][j];  // filled clone array
            }
        }  
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(clone[i][j]==1){
                    int life = findlive(i,j,clone);
                    if(life == 2 || life == 3){  // 2 or 3 live neighbors
                        board[i][j]=1;
                    }else{
                        board[i][j]=0;
                    }
                }
                else{
                    if(findlive(i,j,clone)==3){  // 3 live neighbors
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
            }
        }  
    }
    private int findlive(int i, int j, int[][] board){
        int live =0;
        if(i+1<board.length && board[i+1][j]==1) live++;  // right side
        if(j+1<board[0].length && board[i][j+1]==1) live++;  // below
        if(i-1>=0 && board[i-1][j]==1) live++;  // left side
        if(j-1>=0 && board[i][j-1]==1) live++;  // up
        if(i+1<board.length && j+1<board[0].length && board[i+1][j+1]==1) live++; // bottom diagonal right
        if(i-1>=0 && j+1<board[0].length && board[i-1][j+1]==1) live++;  // bottom diagonal left
        if(i+1<board.length && j-1>=0 && board[i+1][j-1]==1) live++; // up diagonal right
        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1) live++;  // up diagonal left
        return live;
    }
}