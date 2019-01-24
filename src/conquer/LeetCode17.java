package conquer;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * @author lcl
 *
 * 思路： 递归 由小至大
 */

public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        return letterCombination(digits);
    }
    private static List<String> letterCombination(String digits){
        Map<Character,String[]> letterMap = new HashMap<>(8);
        letterMap.put('2',new String[]{"a","b","c"});
        letterMap.put('3',new String[]{"d","e","f"});
        letterMap.put('4',new String[]{"g","h","i"});
        letterMap.put('5',new String[]{"j","k","l"});
        letterMap.put('6',new String[]{"m","n","o"});
        letterMap.put('7',new String[]{"p","q","r","s"});
        letterMap.put('8',new String[]{"t","u","v"});
        letterMap.put('9',new String[]{"w","x","y","z"});
        if(digits.length() == 1){
            return Arrays.asList(letterMap.get(digits.charAt(0)));
        }
        else {
            List<String> subLetter = letterCombination(digits.substring(1));
            List<String> headLetter = Arrays.asList(letterMap.get(digits.charAt(0)));
            List<String> result = new ArrayList<>();
            for(String head: headLetter){
                for(String body : subLetter){
                    result.add(head + body);
                }
            }
         return result;
        }
    }
}
