package dynamicProgramming;

/**
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which
 * minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * @author lcl
 */

public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int[][] minPathTOCurrentPosition = new int[grid.length][grid[0].length];
        int minPathUp = -1;
        int minPathLeft = -1;
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i - 1 > -1){
                    minPathUp = minPathTOCurrentPosition[i-1][j];
                }
                if(j - 1 > -1){
                    minPathLeft = minPathTOCurrentPosition[i][j-1];
                }
                if(minPathUp == -1 && minPathLeft == -1){
                    minPathTOCurrentPosition[i][j] = grid[i][j];
                }
                else if(minPathUp == -1){
                    minPathTOCurrentPosition[i][j] = grid[i][j] + minPathLeft;
                }
                else if(minPathLeft == -1){
                    minPathTOCurrentPosition[i][j] = grid[i][j] + minPathUp;
                }
                else {
                    minPathTOCurrentPosition[i][j] = Math.min(minPathLeft, minPathUp) + grid[i][j];
                }
                minPathUp = -1;
                minPathLeft = -1;
            }
        }
        return minPathTOCurrentPosition[grid.length -1][grid[0].length -1];
    }
}
