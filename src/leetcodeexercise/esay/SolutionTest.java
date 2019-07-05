package leetcodeexercise.esay;


import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Jay
 * @description 题目练习
 * @date Created in 2019/5/23 15:52
 */
public class SolutionTest {

}


/**
 * 7. 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
class Solution7Test {
    public void test() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            reverse(1234567890);
        }

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            reverse1(1234567890);
        }

        long l1 = System.currentTimeMillis();

        System.out.println("字符串处理:" + (l - start) + "\n数值处理:" + (l1 - l));
    }

    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }


    //}

    public int reverse(int x) {
        int y;
        if (x > 0) {
            if (x > Integer.MAX_VALUE) {
                return 0;
            } else {
                StringBuffer sb = new StringBuffer(String.valueOf(x));

                try {
                    y = Integer.valueOf(sb.reverse().toString());
                } catch (Exception e) {
                    return 0;
                }
                return y;
            }
        } else {
            if (x < Integer.MIN_VALUE) {
                return 0;
            } else {
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

/**
 * 9. 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
class Solution9Test {


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

/**
 * 13 .将罗马数字转为整数
 */
class Solution13Test {
    public static void main(String[] args) {
        int iii = romanToInt("III");
        System.out.println(iii);
    }

    public static int romanToInt(String s) {

        int n = s.length();
        int roman_int = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    roman_int = roman_int + 1;
                    break;
                case 'V':
                    roman_int = roman_int + 5;
                    break;
                case 'X':
                    roman_int = roman_int + 10;
                    break;
                case 'L':
                    roman_int = roman_int + 50;
                    break;
                case 'C':
                    roman_int = roman_int + 100;
                    break;
                case 'D':
                    roman_int = roman_int + 500;
                    break;
                case 'M':
                    roman_int = roman_int + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }

            if (i != 0) {
                if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I')) {
                    roman_int = roman_int - 1 * 2;
                }
                if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X')) {
                    roman_int = roman_int - 10 * 2;
                }
                if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C')) {
                    roman_int = roman_int - 100 * 2;
                }
            }
        }
        return roman_int;
    }

}

/**
 * 14.编写一个函数来查找字符串数组中的(所有)最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 */
class Solution14Test {

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"qwer", "qw", "qwe"});
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String temp = "";
        String tmp = "";
        for (int i = 0; i < strs[0].length(); i++) {
            tmp = strs[0].substring(0, i + 1);

            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(tmp)) {
                    return temp;
                }
            }
            temp = tmp;
        }
        return temp;
    }
}







