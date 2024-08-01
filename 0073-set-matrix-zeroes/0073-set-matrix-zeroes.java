class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] row = new int[rows]; // new 1 d arrays to mark row with zero
        int[] column = new int[columns];
        for(int i =0; i < rows; i++) {
            for(int j=0; j < columns; j++) {
                if(matrix[i][j] == 0) { // marked box with 0 as ele // 1, 1
                    row[i] = -1; // row[1]
                    column[j] = -1; // col[1]
                }
            }
        }
        for(int i =0; i < rows; i++) {
            for(int j =0; j< columns; j++) {
                if(row[i]==-1 || column[j]==-1){//traverse again and mark those with negative ele as 0 while traversing
                    matrix[i][j] = 0;
                }
            }
        }
    }
}