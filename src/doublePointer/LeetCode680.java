package doublePointer;

/**
 * 680. Valid Palindrome II
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * @author lcl
 */

public class LeetCode680 {
    public boolean validPalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        int leftMark = 0;
        int lp = 0;
        int rp = s.length() - 1;
        int deleted = 0;
        while (lp <= rp){
            if(s.charAt(lp) == s.charAt(rp)){
                lp++;
                rp--;
            }
            else {
                if(deleted == 1){
                    leftMark = 1;
                    break;
                }
                else {
                    if(s.charAt(lp + 1) == s.charAt(rp)){
                        deleted = 1;
                        lp += 2;
                        rp--;
                    }
                    else {
                        leftMark = 1;
                        break;
                    }
                }
            }
        }
        if(leftMark == 0){
            return true;
        }
        else {
            lp = 0;
            rp = s.length() - 1;
            deleted = 0;
            while (lp <= rp){
                if(s.charAt(lp) == s.charAt(rp)){
                    lp++;
                    rp--;
                }
                else {
                    if(deleted == 1){
                        return false;
                    }
                    else {
                        if(s.charAt(lp) == s.charAt(rp - 1)){
                            deleted = 1;
                            lp++;
                            rp -= 2;
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
