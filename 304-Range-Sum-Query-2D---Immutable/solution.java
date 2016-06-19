public class NumMatrix {
    // // Time Complexity: O(n*m), Space Complexity: O(1)
    // public NumMatrix(int[][] matrix) {
    //     final int m = matrix.length;
    //     final int n = matrix.length > 0 ? matrix[0].length : 0;
    //     this.f = new int[m + 1][n + 1];

    //     for (int i = 1; i < m + 1; ++i) {
    //         int rowSum = 0;
    //         for (int j = 1; j < n + 1; ++j) {
    //             f[i][j] += rowSum + matrix[i-1][j-1];
    //             if (i > 1) {
    //                 f[i][j] += f[i-1][j];
    //             }
    //             rowSum += matrix[i-1][j-1];
    //         }
    //     }
    // }

    // // Time Complexity: O(1), Space Complexity: O(1)
    // public int sumRegion(int row1, int col1, int row2, int col2) {
    //     return f[row2 + 1][col2 + 1] + f[row1][col1] -
    //             f[row1][col2 + 1] - f[row2 + 1][col1];
    // }
    // private final int[][] f;
    
    public int[][] matrix;
public NumMatrix(int[][] matrix) {
    for(int i=0;i<matrix.length;i++)
        for(int j=1;j<matrix[0].length;j++)
            matrix[i][j]+=matrix[i][j-1];
    this.matrix=matrix;
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    int n=0;
    if(col1==0) for(int i=row1;i<=row2;i++) n+=matrix[i][col2];
    else for(int i=row1;i<=row2;i++) n+=matrix[i][col2]-matrix[i][col1-1];
    return n;
}
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);