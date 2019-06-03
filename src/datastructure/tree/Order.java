package datastructure.tree;

import datastructure.linked.Iterator;
import datastructure.linked.LinkedList;
import datastructure.linked.MyDoubleNodeLinkedList;
import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;

/**
 * @author Jay
 * @description 遍历二叉树
 * @date Created in 2019/6/3 13:52
 */
public class Order {
    private BinTreeNode root;

    /**
     * 先序遍历二叉树
     *
     * @return
     */
    public Iterator preOrder() {
        LinkedList list = new MyDoubleNodeLinkedList();
        preOrderRecursion(this.root, list);
        preOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 非递归算法
     *
     * @param root
     * @param list
     */
    private void preOrderTraverse(BinTreeNode root, LinkedList list) {
        if (root == null) {
            return;
        }
        BinTreeNode p = root;
        Stack s = new StackSingleLinked();
        while (p != null) {
            // 向左走到尽头
            while (p != null) {
                // 访问根元素
                list.insertLast(p);
                // 右子节点入栈
                if (p.hasRChild()) {
                    s.push(p.getrChild());
                }
                p = p.getlChild();
            }
            // 右子根退栈遍历右子树
            if (!s.isEmpty()) {
                p = (BinTreeNode) s.pop();
            }

        }


    }

    /**
     * 递归算法
     *
     * @param root
     * @param list
     */
    private void preOrderRecursion(BinTreeNode root, LinkedList list) {
        if (root == null) {
            return;
        }
        list.insertLast(root);
        preOrderRecursion(root.getlChild(), list);
        preOrderRecursion(root.getrChild(), list);
    }

}
