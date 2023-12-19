class Solution {
    public int[][] imageSmoother(int[][] img) {
              int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;
                
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < rows && l >= 0 && l < cols) {
                            sum += img[k][l];
                            count++;
                        }
                    }
                }
                
                result[i][j] = sum / count;
            }
        }
        
        return result;
        
    }
}