package demo_7;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        System.out.println(reverse(123));
    }


    //    public int reverse(int x) {
    //        int rev = 0;
    //        while (x != 0) {
    //            int pop = x % 10;
    //            x /= 10;
    //            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
    //            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
    //            rev = rev * 10 + pop;
    //        }
    //        return rev;
    //    }
    //}

    public int reverse(int x) {
        int y;
        if (x > 0) {
            if (x > Integer.MAX_VALUE)
                return 0;
            else {
                StringBuffer sb = new StringBuffer(String.valueOf(x));

                try {
                    y = Integer.valueOf(sb.reverse().toString());
                } catch (Exception e) {
                    return 0;
                }
                return y;
            }
        } else {
            if (x < Integer.MIN_VALUE)
                return 0;
            else {
                x = Math.abs(x);
                StringBuffer sb = new StringBuffer(String.valueOf(x));
                try {
                    y = Integer.valueOf(sb.reverse().toString());
                } catch (Exception e) {
                    return 0;
                }
                return 0 - y;

            }
        }
    }
}

