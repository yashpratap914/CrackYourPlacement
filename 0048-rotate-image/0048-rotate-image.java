class Solution {
    public void rotate(int[][] matrix) {
        //TRANSPOSE -> REVERSE EVERY ROW
        transpose(matrix);
        reverserow(matrix); 
    }
    public void transpose(int[][] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
    }
    public void reverserow(int[][] arr){
        for(int r=0; r<arr.length; r++){
            int left =0;
            int right = arr.length-1;
            while(left<right){
                int temp = arr[r][left];
                arr[r][left] = arr[r][right];
                arr[r][right]= temp;
                left++;
                right--;
            }
        }
        
    }
}