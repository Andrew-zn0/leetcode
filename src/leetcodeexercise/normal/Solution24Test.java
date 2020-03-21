package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * @date Created in 2020/3/17 11:47 上午
 */
public class Solution24Test {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(swapPairs(l1));
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 递归终止条件
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 递归每次返回正确排列的链表，只需将其连接到1节点后边
        firstNode.next = swapPairs(secondNode.next);
        // 然后将1节点链接到2节点，完成交换
        secondNode.next = firstNode;

        return secondNode;
    }

    /**
     * 非递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        // 辅助节点
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (node != null && node.next != null) {
            // 将要交换节点放置在辅助节点上
            node.next = head.next;
            // 把第二个节点后数据移到第一节点上
            head.next = head.next.next;
            // 将完成后节点数据拼接到第二节点，完成交换
            node.next.next = head;

            // 坐标移动俩位开始下次交换
            node = node.next.next;
            // 由于已经交换一次，1节点直接绑定到3节点，所以位移一次就可以
            head = head.next;
        }
        return res.next;

    }
}
