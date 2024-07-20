class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // min between row sum(i) and col sum(j)
        // rowsum = [5(i->0), 7(1), 10(2)]
        // colsum = [ 8(j->0), 6(1), 8(2)]
        // (0,0) -> found min(out of the two(i,j))put 5 and deduct from col sum and row sum and move i ahead
        // rowsum = [0(0), 7(i->1), 10(2)]
        // colsum = [ 3(j->0), 6(1), 8(2)]   min(7(i),3(j))
         // (1,0) -> found min(out of the two(i,j))put 3 and deduct from col sum and row sum
        // rowsum = [(0), 4(1), 10(2)]
        // colsum = [ 0(0), 6(1), 8(2)]
        int[][] matrix = new int[rowSum.length][colSum.length];
        int i=0, j=0;
        while(i<rowSum.length && j<colSum.length){
            int minval = Math.min(rowSum[i],colSum[j]);
            matrix[i][j] = minval;
            rowSum[i]-=minval;
            colSum[j]-=minval;
            if(rowSum[i]==0){
                i++;
            }if(colSum[j]==0){
                j++;
            }
            
        }
        return matrix;
    }
}