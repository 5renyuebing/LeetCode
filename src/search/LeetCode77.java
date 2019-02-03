package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * @author lcl
 */

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        addResult(result,n,new ArrayList<>(),k,1);
        return result;
    }
    private static void addResult(List<List<Integer>> result, int n, List<Integer> currentNum,int k,int position){
        if(currentNum.size() == k){
            result.add(currentNum);
        }
        else if(position <= n){
            List<Integer> newCurrentNumWithAddPosition = new ArrayList<>(currentNum);
            List<Integer> newCurrentNumWithoutAddPosition = new ArrayList<>(currentNum);
            newCurrentNumWithAddPosition.add(position);
            addResult(result, n, newCurrentNumWithAddPosition ,k,position+1);
            addResult(result,n , newCurrentNumWithoutAddPosition, k, position+1);
        }
    }
    public static void main(String[] args){
        LeetCode77 leetCode77 = new LeetCode77();
        leetCode77.combine(2,4);
    }
}
