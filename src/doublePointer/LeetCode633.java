package doublePointer;

/**
 * 633. Sum of Square Numbers
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * @author lcl
 */

public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        int lp = 0;
        int rp = (int)Math.sqrt(c);
        while (lp <= rp){
            if(lp * lp + rp * rp == c){
                return true;
            }
            else if(lp * lp + rp * rp < c){
                lp++;
            }
            else {
                rp--;
            }
        }
        return false;
    }
}
