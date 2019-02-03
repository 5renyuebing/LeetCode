package dynamicProgramming;

/**
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below)
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * @author lcl
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] pathArray = new int[m][n];
        int left = 0;
        int up = 0;
        for(int i = 0;i< m;i++){
            for(int j = 0;j< n; j++){
                if(i == 0 || j == 0){
                    pathArray[i][j] = 1;
                    continue;
                }
                if(i - 1> -1){
                    up = pathArray[i-1][j];
                }
                if(j - 1 > -1){
                    left = pathArray[i][j-1];
                }
                pathArray[i][j] = left + up;
                left = 0;
                up = 0;
            }
        }
        return pathArray[m-1][n-1];
    }
}
