public class NumMatrix {

    private int[][]f;
    public NumMatrix(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix.length > 0 ? matrix[0].length : 0;
        
        f=new int [n+1][m+1];
        
        for(int i=1;i<=n;i++){
            int rowSum=0;
            for(int j=1;j<=m;j++){
                f[i][j]+= rowSum+matrix[i-1][j-1];
                if(i>1){
                    f[i][j]+=f[i-1][j];
                }
                rowSum+=matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return f[row2 + 1][col2 + 1] + f[row1][col1] -f[row1][col2 + 1] - f[row2 + 1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);