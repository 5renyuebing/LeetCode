package dynamicProgramming;

/**
 * 91. Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * @author lcl
 */

public class LeetCode91 {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] step = new int[s.length()];
        for(int i = 0;i<step.length; i++){
            if(i == 0){
                if(s.charAt(i) == '0'){
                    return 0;
                }
                else {
                    step[i] = 1;
                }
            }
            else {
                if(s.charAt(i) == '0'){
                    if(Integer.valueOf(String.valueOf(s.charAt(i-1))) > 2 || Integer.valueOf(String.valueOf(s.charAt(i-1))) == 0){
                        return 0;
                    }
                    else if(i - 2 < 0){
                        step[i] = 1;
                    }
                    else {
                        step[i] = step[i-2];
                    }
                }
                else {
                    if(Integer.valueOf(String.valueOf(s.charAt(i-1))) == 0){
                        step[i] = step[i-1];
                    }
                    else if(Integer.valueOf(s.substring(i-1, i+1)) <= 26){
                        if(i - 2 < 0){
                            step[i] = step[i-1] + 1;
                        }
                        else {
                            step[i] = step[i-1] + step[i-2];
                        }
                    }
                    else {
                        step[i] = step[i-1];
                    }
                }
            }
        }
        return step[step.length - 1];
    }
    public static void main(String[] args){
        LeetCode91 leetCode91 = new LeetCode91();
        leetCode91.numDecodings("110");
    }
}
