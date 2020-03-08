package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jay
 * @description 相交链表
 * @date Created in 2020/3/8 6:25 下午
 */
public class Solution160Test {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l3.next = l4;

        l2.next = l3;
        l4.next = l5;
        ListNode intersectionNode = getIntersectionNode(l1, l4);
        System.out.println();
    }

    /**
     * 哈希表
     * <p>
     * 也可以双循环暴力破解
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {

            return null;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(headA);
        if (set.contains(headB)) {
            return headB;
        }
        set.add(headB);
        while (!(headA == null && headB == null)) {
            if (headA != null) {
                headA = headA.next;
                if (set.contains(headA)) {
                    return headA;
                }
                set.add(headA);
            }
            if (headB != null) {
                headB = headB.next;
                if (set.contains(headB)) {
                    return headB;
                }
                set.add(headB);
            }
        }
        return null;
    }

    /**
     * 双指针法
     *
     * 链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a +b = b+a 。因此相遇处是NULL
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
        }
        return ha;
    }

}
