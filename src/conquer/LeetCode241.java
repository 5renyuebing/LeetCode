package conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 * Given a string of numbers and operators, return all possible results from computing all the
 * different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * @author lcl
 *
 * 思路： 无操作符（直接Integer.valueOf） -> 一个操作符（转化为两个无操作符的结果） -> 两个操作符（无操作符和一个操作符的结果，返回一个List）
 *        -> 三个操作符（转化为无操作符和两个操作符的结果，两个操作符返回List） -> 多个操作符（两个List或一个int及一个List）
 *
 * 返回值： int -> int + int -> int + List -> List + List
 */
public class LeetCode241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                            default:
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
    public static void main(String[] args){
        LeetCode241 leetCode241 = new LeetCode241();
        System.out.println(leetCode241.diffWaysToCompute("2*3-4*5"));
    }
}
