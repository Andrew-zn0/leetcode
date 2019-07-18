package leetcodeexercise.esay;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


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
class _Solution7Test {
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

/**
 * 35. 给定一个排序数组和一个目标值，在数组中找到目标值，
 * 并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
class Solution35Test {

    public static void main(String[] args) {

        int[] ints = {1, 2, 4, 6, 10};

        int i = searchInsert(ints, 0);
        System.out.println("插入位置：" + i);
        Arrays.stream(ints).forEach(x -> System.out.println(x));
    }

    /**
     * 循环遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                return i;
            }
            if (i == nums.length - 1) {
                return nums.length;
            }

            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        int l = 0;
        int r = len - l;
        while (l <= r) {
            // 防止溢出 (l+r)/2
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

/**
 * 38.报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
 */
class Solution38Test {
    public static void main(String[] args) {
        String s = countAndSay(20);
        System.out.println(s);
    }

    /**
     * 解题思路:
     * 本题的难点在于：报数的概念理解，但是感觉像是个递推式
     * 从4->5分析，将4个每一位拆开看（个数+数字），4=1211 => 1=11，2=12，11=21，所以5=111221
     * 所以解题用循环，从1->n可求解出来
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {

            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }
        return str;
    }
}

/**
 * 53.给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 */
class Solution53Test {
    public static void main(String[] args) {
        //int[] ints = {-2, 1};
        int[] ints = {-2, 2, -1, 6, -2};
        long l = System.currentTimeMillis();
        int i = maxSubArray3(ints);
        System.out.println("最大和：" + i + "所用时间:" + (System.currentTimeMillis() - l));
    }

    /**
     * 算法效率太低
     * <p>
     * 时间复杂度: O(N3)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int j = 1; j <= nums.length; j++) {
            for (int i = 0; i <= nums.length - j; i++) {
                for (int k = i; k <= nums.length - j; k++) {
                    sum += nums[k];
                }
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * <p>
     * 算法思路:
     * <p>
     * 既然一个连续子数组一定要以一个数作为结尾，那么我们就将状态定义成：
     * dp[i] 表示以 nums[i] 结尾的连续子数组的最大和。
     * <p>
     * 1、定义状态：dp[i] 表示以 nums[i] 结尾的连续子数组的最大和。
     * 2、状态转移方程：dp[i] = max{num[i], dp[i - 1] + num[i]}。
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            // 状态方程
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 改进空间复杂度
     * <p>
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int s = nums[0];
        int res = nums[0];
        for (int i = 0; i < len; i++) {
            s = Math.max(nums[i], s + nums[i]);
            // 每次将最大值提取
            res = Math.max(res, s);
        }
        return res;
    }

    /**
     * 分治法
     * <p>
     * 即将整个数组分为三部分，左半部分、右半部分以及中间部分，
     * 最大子序和必定存在于这三个区间之一，
     * 递归求解三部分分别的最大子序和，最后，取三者中较大的一个即可。
     * <p>
     * <p>
     * nlog(n)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    private static int maxCrossingSum(int[] nums, int l, int m, int r) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private static int maxSubArraySum(int[] nums, int l, int r) {
        if (l == r) {
            return nums[1];
        }
        int mid = l + (r - l) / 2;
        return max3(maxSubArraySum(nums, l, mid),
                maxSubArraySum(nums, mid + 1, r),
                maxCrossingSum(nums, l, mid, r));
    }

    private static int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}

/**
 * 58, 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0
 */
class Solution58Test {
    public static void main(String[] args) {
        int i = lengthOfLastWord("");
        System.out.println("单词长度:" + i);

    }

    public static int lengthOfLastWord(String s) {

        try {
            String[] split = s.split(" ");
            return split[split.length - 1].length();
        } catch (Exception e) {
            return 0;
        }
    }
}

/**
 * 66. 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 这个整数不会以零开头!
 */
class Solution66Test {
    public static void main(String[] args) {
        int[] ints = {0, 0, 9, 9};
        int[] ints1 = plusOne(ints);
        Arrays.stream(ints1).forEach(System.out::println);
    }

    /**
     * 该解法在数据长度很大的情况下会造成溢出
     *
     * @param digits
     * @return
     */
    public static int[] plusOne1(int[] digits) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0 && !flag) {
                flag = true;
            }
            if (flag) {
                sb.append(digits[i]);
            }
        }
        Long integer;
        if ("".equals(sb.toString())) {
            integer = 1L;
        } else {
            integer = Long.valueOf(sb.toString()) + 1;
        }
        String s = String.valueOf(integer);
        int[] ints = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ints[i] = Integer.valueOf(s.charAt(i) + "");
        }
        return ints;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}

/**
 * 67. 给定两个二进制字符串，返回他们的和（用二进制表示）。
 */
class Solution67Test {
    public static void main(String[] args) {
        String s = addBinary("10", "11");
        System.out.println(s);
        //        int power = power(4, 3);
        //        System.out.println(power);
    }

    /**
     * 解题思路:
     * <p>
     * 整体思路是将两个字符串较短的用0补齐，使得两个字符串长度一致，
     * 然后从末尾进行遍历计算，得到最终结果。
     * <p>
     * 但由于字符串操作原因，不确定最后的结果是否会多出一位进位，
     * 所以会有2种处理方式：
     * <p>
     * 1.在进行计算时直接拼接字符串，会得到一个反向字符，需要最后再进行翻转
     * 2.按照位置给结果字符赋值，最后如果有进位，则在前方进行字符串拼接添加进位
     * <p>
     * 时间复杂度:
     * <p>
     * O(n)
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        //        int i = Integer.parseInt(a, 2);
        //        int i1 = Integer.parseInt(b, 2);
        //
        //        return  Integer.toBinaryString(i+i1);

        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            // 判断j>=0的含义是有可能两个数字长度不一致，
            // 如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            // sum%2是在做二进制取模运算，比如sum=2，这时候将sum%2=0放入结果集中
            ans.append(sum % 2);
            // 这里是计算进位，比如sum=2，ca = 1，ca表示进位的意思，满2进1
            ca = sum / 2;
        }
        // 这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();

    }

    /**
     * 递归实现
     *
     * @param x
     * @param n
     * @return
     */
    private static int power(int x, int n) {
        int y;
        if (n == 0) {
            y = 1;
        } else {
            y = power(x, n / 2);
            y = y * y;
            if (n % 2 == 1) {
                y = y * x;
            }
        }
        return y;
    }

}

/**
 * 69 .实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
class Solution69Test {

    public static void main(String[] args) {
        int i = mySqrt(4);
        System.out.println("平方根为:" + i);

    }

    /**
     * /极限情况会越界
     *
     * @param x
     * @return
     */
    private static int mySqrt1(int x) {
        for (long i = 0; true; i++) {

            if (x < i * i) {
                return (int) i - 1;
            }
        }
    }

    /**
     * 二分查找法
     * <p>
     * 时间复杂度：O(\log N)O(logN)，二分法的时间复杂度是对数级别的。
     * 空间复杂度：O(1)O(1)，使用了常数个数的辅助空间用于存储和比较。
     *
     * @param x
     * @return
     */
    private static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码可能会进入死循环
            long mid = left + (right - left + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    /**
     * 牛顿法
     * <p>
     * 在迭代过程中，以直线代替曲线，用一阶泰勒展式（即在当前点的切线）代替原曲线，
     * 求直线与 xx轴的交点，重复这个过程直到收敛。
     *
     * @param a
     * @return
     */
    private static int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }

        return (int) x;
    }
}

/**
 * 70.假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶
 */
class Solution70Test {

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println("共有" + i + "种方法");
    }


    /**
     * 暴力法:2
     * <p>
     * 递归实现
     * <p>
     * 空间复杂度：O(n)，递归树的深度可以达到n 。
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {

        return climbStairsTest(0, n);
    }

    /**
     * i表示倒数第几层
     * 每一层表示前边两层相加
     * i==n 则表示第一层
     *
     * @param i
     * @param n
     * @return
     */
    private static int climbStairsTest(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairsTest(i + 1, n) + climbStairsTest(i + 2, n);
    }

    /**
     * 动态规划
     * 这个问题可以被分解为一些包含最优子结构的子问题，
     * 即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * <p>
     * 第 ii 阶可以由以下两种方法得到：
     * <p>
     * 在第 (i-1) 阶后向上爬一阶。
     * <p>
     * 在第 (i-2)阶后向上爬俩阶。
     * <p>
     * 所以到达第 ii 阶的方法总数就是到第 (i-1)(i−1) 阶和第 (i-2)(i−2) 阶的方法数之和。
     * <p>
     * 令 dp[i]dp[i] 表示能到达第 ii 阶的方法总数：
     * <p>
     * dp[i]=dp[i-1]+dp[i-2]
     * dp[i]=dp[i−1]+dp[i−2]
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {

            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }
}

