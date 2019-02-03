package dynamicProgramming;

import java.util.*;

/**
 * 646. Maximum Length of Pair Chain
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * @author lcl
 */

public class LeetCode646 {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0){
            return 0;
        }
        Arrays.sort(pairs,new ArrayComparator());
        int[] length = new int[pairs.length];
        for(int i = 0;i< pairs.length;i++){
            List<Integer> list = new ArrayList<>();
            for(int j= i-1;j>-1;j--){
                if(pairs[i][0] > pairs[j][1]){
                    list.add(length[j] + 1);
                }
            }
            if(list.isEmpty()){
                length[i] = 1;
            }
            else {
                Collections.sort(list);
                length[i] = list.get(list.size() - 1);
            }
        }
        Arrays.sort(length);
        return length[length.length - 1];
    }
}

class ArrayComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        int[] array1 = (int[]) o1;
        int[] array2 = (int[]) o2;
        return Integer.compare(array1[1], array2[1]);
    }
}