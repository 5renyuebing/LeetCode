package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * @author lcl
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
     List<List<String>> result = new ArrayList<>();
     if(s.length() != 0){
     addResult(s,0,result, new ArrayList<>());
     }
     return result;
    }
    private static void addResult(String s, int position, List<List<String>> result, List<String> currentResult){
        if(position == s.length()){
            result.add(currentResult);
            return;
        }
        for(int i = position;i<s.length();i++){
            int mark = 0;
            for(int j = position; j<= i; j++){
                if(s.charAt(j) != s.charAt(i - (j - position))){
                    mark = 1;
                }
            }
            if(mark == 0){
                List<String> newResult = new ArrayList<>(currentResult);
                newResult.add(s.substring(position,i+1));
                addResult(s, i + 1, result,newResult);
            }
        }
    }
    public static void main(String[] args){
        LeetCode131 leetCode131 = new LeetCode131();
        List<List<String>> result = leetCode131.partition("bibiiytfy");
        for(List<String> r : result){
            System.out.println(r);
        }
    }
}
