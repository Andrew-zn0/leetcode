package leetcodeexercise.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Jay
 * @description 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @date Created in 2020/3/16 9:21 上午
 */
public class Solution19Test {

    @Test
    public void test() {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(removeNthFromEnd(l3, 2));
    }

    /**
     * 放入链表全部遍历
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        if (listNodes.size() == n) {
            return listNodes.get(0).next;
        }
        ListNode listNode = listNodes.get(listNodes.size() - n - 1);
        listNode.next = listNodes.get(listNodes.size() - n).next;
        return listNodes.get(0);
    }

    /**
     * 俩次遍历
     * <p>
     * 1.计算出链表总长度length
     * <p>
     * 2.计算出 length-n
     * <p>
     * 3.将 length-n-1 处节点 的元素去掉
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 辅助节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 一次遍历实现
     * <p>
     * 双指针
     * <p>
     * 1.将第一个指针移动n 位
     * <p>
     * 2.第一个指针与第二个指针同时遍历，直到第一个到末尾
     * <p>
     * 3. 则此时第二个指针遍历 到（l-n）个元素处，及倒数的第n+1元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
