package leetcodeexercise.esay;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
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

/**
 * 20. 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
class Solution20Test {

    public static void main(String[] args) {

        System.out.println(isValid("{}[]"));
    }

    public static boolean isValid(String s) {

        int a = 0, b = 0, c = 0;
        List<Character> strings = new ArrayList<>();

        if (s.length() % 2 == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index = 0;

        for (int i = 0; i < s.length(); i++) {

            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                strings.add(x);
                index++;
            }
            if (index == 0) {
                return false;
            }
            // 此处判断可以用map代替
            if (x == ')') {
                index--;
                Character ch = strings.get(index);
                if (ch != '(') {
                    return false;
                }
                strings.remove(index);
            } else if (x == ']') {
                index--;
                Character ch = strings.get(index);
                if (ch != '[') {
                    return false;
                }
                strings.remove(index);
            } else if (x == '}') {
                index--;
                Character ch = strings.get(index);
                if (ch != '{') {
                    return false;
                }
                strings.remove(index);
            }
        }
        if (index != 0) {
            return false;
        }
        return true;
    }

    /***
     * jdk自带栈 Stack
     * @param s
     * @return
     */
    public boolean isValidStack(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                // 匹配到反字符，如果栈为空，或栈顶字符与字符不匹配就不满足条件
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        // 执行到最后如果栈为空，表示匹配
        return stack.isEmpty();
    }

}

/**
 * 21.合并俩个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class Solution21Test {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l3;
        l2.next = l4;

        ListNode l = new ListNode(-1);
        ListNode min = l;
        min.next = l1;
        min = min.next;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        // ListNode listNode = mergeTwoLists1(l1, l2);
        System.out.println("-----------");

    }

    /**
     * 非递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode min = l;
        while (l1 != null && l2 != null) {
            if (l2.val <= l1.val) {
                min.next = l2;
                l2 = l2.next;
            } else {
                min.next = l1;
                l1 = l1.next;
            }
            min = min.next;
        }
        min.next = l1 == null ? l2 : l1;
        return l.next;
    }

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;

        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 26. 定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
class Solution26Test {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2};

        int i = removeDuplicates(ints);
        System.out.println("数组长度：" + i);
        Arrays.stream(ints).forEach(x -> System.out.println(x));
    }

    /**
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}

/**
 * 27. 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
class Solution27Test {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 4, 4, 6, 10};

        int i = removeElement(ints, 1);
        System.out.println("数组长度：" + i);
        Arrays.stream(ints).forEach(x -> System.out.println(x));
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }

        }
        return j;
    }
}

/**
 * 28. 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 */
class Solution28Test {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int i = strStr("mississippi", "pi");
        System.out.println(i + "\n时间：" + (System.currentTimeMillis() - l));
    }

    /**
     * 暴力破解
     * <p>
     * 时间 o(m*n)
     * <p>
     * kmp 算法简洁
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        if ("".equals(needle)) {
            return 0;
        }
        int j = 0;
        //        for (int i = 0; i < haystack.length(); i++) {
        //
        //            while (needle.charAt(j) == haystack.charAt(i)) {
        //                j++;
        //                i++;
        //                if (j == needle.length()) {
        //                    return i - j;
        //                }
        //                if (i == haystack.length()) {
        //                    return -1;
        //                }
        //
        //            }
        //            if (j != 0) {
        //                i = i - j;
        //                j = 0;
        //            }
        //
        //        }for (int i = 0; i < haystack.length(); i++) {
        int i = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 字符串
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle)) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}





