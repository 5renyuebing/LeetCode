package conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * @author lcl
 *
 * 递归思路： 只有一段时判断该段可否成为ip地址（是否小于256）即可，多段时，ip地址由前一段+后几段组成。在段数非1时，直接递归调用求解正确形式
 * 核心：               String headLetterOne = String.valueOf(s.substring(0,1));
 *                      List<String> bodyLetterOne = addToResultList(s.substring(1),segment - 1);
 */

public class LeetCode93 {
    private static List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() >12){
            return new ArrayList<>();
        }
        List<String> subResult = addToResultList(s,4);
        for(String r : subResult){
            result.add(r);
        }
        return result;
    }
    private static List<String> addToResultList(String s, int segment){
        if(segment == 1 && s.length() != 0){
            if(Long.valueOf(s) < 256){
                return new ArrayList<>(Collections.singletonList(s));
            }
            else {
                return new ArrayList<>(Collections.singletonList("-1"));
            }
        }
        else if(s.length() != 0){
            List<String> subResult = new ArrayList<>();
            String headLetterOne = String.valueOf(s.substring(0,1));
            List<String> bodyLetterOne = addToResultList(s.substring(1),segment - 1);
            for (String body : bodyLetterOne){
                if(!body.contains("-1")){
                    subResult.add(headLetterOne + "." + body);
                }
            }
            if(s.length() >= 2) {
                String headLetterTwo = String.valueOf(s.substring(0, 2));
                List<String> bodyLetterTwo = addToResultList(s.substring(2), segment - 1);
                for (String body : bodyLetterTwo) {
                    if (!body.contains("-1")) {
                        subResult.add(headLetterTwo + "." + body);
                    }
                }
            }
            if(s.length() >= 3) {
                String headLetterThree = String.valueOf(s.substring(0, 3));
                if (Integer.valueOf(headLetterThree) < 256){
                    List<String> bodyLetterThree = addToResultList(s.substring(3), segment - 1);
                    for (String body : bodyLetterThree) {
                        if (!body.contains("-1")) {
                            subResult.add(headLetterThree + "." + body);
                        }
                    }
                }
            }
            return subResult;
        }
        return new ArrayList<>(Collections.singletonList("-1"));

    }
    public static void main(String[] args){
        LeetCode93 leetCode93 = new LeetCode93();
        System.out.println(leetCode93.restoreIpAddresses("0000"));
    }
}
