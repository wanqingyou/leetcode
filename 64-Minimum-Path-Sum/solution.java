public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        
        int [][] step=new int[row][col];
        step[0][0]=grid[0][0];
        for(int i=1;i<col;i++){
            step[0][i] = step[0][i-1] + grid[0][i];
        }
        for(int j=1;j<row;j++){
            step[j][0] = step[j-1][0] + grid[j][0];
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                step[i][j] = Math.min(step[i-1][j], step[i][j-1]) + grid[i][j];
            }
        }
        return step[row-1][col-1];
    }
}