package doublePointer;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * @author lcl
 */


public class LeetCode345 {
    private static Character[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
    public String reverseVowels(String s) {
        if(s.length() <= 1 ){
            return s;
        }
        ArrayList<Character> vowelList = new ArrayList<>(Arrays.asList(vowels));
        StringBuilder stringBuilder = new StringBuilder(s);
        int lp = 0;
        int rp = s.length() - 1;
        while (lp <= rp){
            while (!vowelList.contains(s.charAt(lp)) && lp < s.length() -1){
                lp++;
            }
            while (!vowelList.contains(s.charAt(rp)) && rp > 0){
                rp--;
            }
            if(lp > rp){
                break;
            }
            stringBuilder.replace(lp,lp+1,String.valueOf(s.charAt(rp)));
            stringBuilder.replace(rp,rp+1,String.valueOf(s.charAt(lp)));
            lp++;
            rp--;
        }
        return stringBuilder.toString();
    }
}
