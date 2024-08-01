class Solution {
    public void rotate(int[][] matrix) {
        //TRANSPOSE -> REVERSE EVERY ROW
        transpose(matrix);
        reverserow(matrix); 
    }
    public void transpose(int[][] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){ // rows : start -> end
            for(int j=0; j<i; j++){ // swap non equal(non diagnol) i and j(transpose)
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
    }
    public void reverserow(int[][] arr){
        for(int r=0; r<arr.length; r++){ // row
            int left =0;  
            int right = arr.length-1; // 2 pointer(left(first) and right(last))
            while(left<right){
                int temp = arr[r][left];
                arr[r][left] = arr[r][right];  // swap of first nd last until middle -> reverse
                arr[r][right]= temp;
                left++;
                right--;
            }
        }
        
    }
}