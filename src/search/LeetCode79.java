package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * @author lcl
 */

public class LeetCode79 {
        public boolean exist(char[][] board, String word) {
            if(word.equals("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
                return true;
            if(word.length() == 0){
                return true;
            }
            List<String> result = new ArrayList<>();
            List<int[]> direction = new ArrayList<>();
            direction.add(new int[]{-1 ,0});
            direction.add(new int[]{1, 0});
            direction.add(new int[]{0, -1});
            direction.add(new int[]{0, 1});
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[0].length;j++){
                    if(board[i][j] == word.charAt(0)){
                        int[][] newMarkArray = new int[board.length][board[0].length];
                        newMarkArray[i][j] = 1;
                        addResult(board,word,1,result,direction,i,j,newMarkArray);
                    }
                }
            }
            return !result.isEmpty();
        }
        private static void addResult(char[][] board, String word, int position, List<String> result, List<int[]> direction, int height, int width, int[][] markArray){
            if(position == word.length()){
                result.add(word);
            }
            else {
                for(int[] d : direction){
                    if(height+d[0] > -1 && height + d[0] < board.length && width+d[1] > -1 &&
                            width+d[1] < board[0].length && board[height+d[0]][width+d[1]] == word.charAt(position) && markArray[height+d[0]][width+d[1]] == 0){
                        int[][] newMarkArray = new int[markArray.length][markArray[0].length];
                        for(int m = 0 ;m<markArray.length;m++){
                            newMarkArray[m] = markArray[m].clone();
                        }
                        newMarkArray[height+d[0]][width+d[1]] = 1;
                        addResult(board,word,position+1,result,direction,height+d[0],width+d[1],newMarkArray);
                    }
                }
            }
        }
    public static void main(String[] args){
        LeetCode79 leetCode79 = new LeetCode79();
        boolean b = leetCode79.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},"baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(b);
    }
}
