package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 回溯法
 *
 * @author lcl
 */
public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        addResult(s,0,"",result,4);
        return result;
    }
    private static void addResult(String s, int position, String currentString, List<String> result, int segment){
        if(segment == 0 || position >= s.length() || segment * 3 < s.substring(position).length()){
            return;
        }
        if(segment == 1){
            if(s.charAt(position) == '0' && s.substring(position).length() > 1){
                return;
            }
            if(Integer.valueOf(s.substring(position))< 256){
                result.add(currentString + "." + s.substring(position));
            }
        }
        else if(segment == 4){
            addResult(s, 1, s.substring(0,1),result,3);
            if(s.charAt(position) != '0'){
                addResult(s,2,s.substring(0,2),result,3);
                if(Integer.valueOf(s.substring(0,3))< 256){
                addResult(s,3,s.substring(0,3),result,3);
                }
            }
        }
        else {
            addResult(s,position+1,currentString + "." + s.substring(position,position+1),result,segment -1);
            if(position+2 < s.length() && s.charAt(position) != '0'){
                addResult(s,position+2,currentString+"."+s.substring(position,position+2),result,segment-1);
                if(position + 3 < s.length() && Integer.valueOf(s.substring(position,position+3))< 256){
                addResult(s,position+3,currentString+"."+s.substring(position,position+3),result,segment-1);
                }
            }
        }
    }
    public static void main(String[] args){
        LeetCode93 leetCode93 = new LeetCode93();
        List<String> result = leetCode93.restoreIpAddresses("1111");
        for(String r : result){
            System.out.println(r);
        }
    }
}
