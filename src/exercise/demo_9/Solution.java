package exercise.demo_9;


import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        //System.out.println(isPalindrome(121));
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        //String dateString = formatter.format(new Date());
        //new java.sql.Date(new java.util.Date().getTime());
        System.out.println(new java.sql.Date(new java.util.Date().getTime()));


    }


    public boolean isPalindrome(int x) {

        //        if (x < 0) {
        //            return false;
        //        } else {
        //            int b = 0;
        //            try {
        //                StringBuffer a = new StringBuffer(String.valueOf(x));
        //
        //
        //                b = Integer.parseInt(a.reverse().toString());
        //            } catch (NumberFormatException e) {
        //
        //                return false;
        //            }
        //
        //
        //            if (b != x) {
        //                return false;
        //
        //            }
        //
        //            return true;
        //        }


        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }


        return x == revertedNumber || x == revertedNumber / 10;


    }

}
