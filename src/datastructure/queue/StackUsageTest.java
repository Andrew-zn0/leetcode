package datastructure.queue;

import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;
import org.junit.Test;

/**
 * @author Jay
 * @description 堆栈的使用
 * @date Created in 2019/5/24 15:18
 */
public class StackUsageTest {

    @Test
    public void test() {

        //十进制转化为8进制
        baseConversion(10);
        System.out.println("\n========================");
        //检测表达式是否正确
        boolean b = bracketMatch("{[{}]([])}");
        System.out.println(b + "\n========================");

    }

    /**
     * 检测表达式是否合格
     *
     * @param str
     * @return
     */
    private boolean bracketMatch(String str) {
        Stack s = new StackSingleLinked();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    s.push(Integer.valueOf(c));
                    break;
                case '}':
                    if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '[') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (!s.isEmpty() && ((Integer) s.pop()).intValue() == '(') {
                        break;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 十进制转化为八进制
     *
     * @param i
     */
    private void baseConversion(int i) {
        Stack s = new StackSingleLinked();
        while (i > 0) {
            s.push(i % 8 + "");
            i = i / 8;
        }
        while (!s.isEmpty()) {
            System.out.print((String) s.pop());
        }
    }


}
