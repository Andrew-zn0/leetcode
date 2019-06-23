package datastructure.tree;

import datastructure.linked.Iterator;
import datastructure.linked.LinkedList;
import datastructure.linked.MyDoubleNodeLinkedList;
import datastructure.linked.Node;
import datastructure.list.Strategy;
import datastructure.queue.Queue;
import datastructure.queue.QueueArray;
import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;

/**
 * @author Jay
 * @description 遍历二叉树
 * @date Created in 2019/6/3 13:52
 */
public class Order {
    private BinTreeNode root;
    private Strategy strategy;

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
     * 中序遍历二叉树
     *
     * @return
     */
    public Iterator inOrder() {
        LinkedList list = new MyDoubleNodeLinkedList();
        inOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 后序遍历二叉树
     *
     * @return
     */
    public Iterator postOrder() {
        LinkedList list = new MyDoubleNodeLinkedList();
        postOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 按层遍历二叉树
     *
     * @return
     */
    public Iterator levelOrder() {
        LinkedList list = new MyDoubleNodeLinkedList();
        levelOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 在树中查找元素 e，返回其所在结点
     *
     * @param e
     * @return
     */
    public BinTreeNode find(Object e) {
        return searchE(root, e);
    }

    /**
     * 递归查找元素 e
     *
     * @param root
     * @param e
     * @return
     */
    private BinTreeNode searchE(BinTreeNode root, Object e) {
        if (root == null) {
            return null;
        }
        // 如果是根节点,返回根
        if (strategy.equal(root.getData(), e)) {
            return root;
        }
        // 否则在左子树中找
        BinTreeNode v = searchE(root.getlChild(), e);
        // 如果没有找到,在右子树中找
        if (v == null) {
            v = searchE(root.getrChild(), e);
        }
        return v;
    }

    /**
     * 使用队列完成二叉树的按层遍历
     *
     * @param root
     * @param list
     */
    private void levelOrderTraverse(BinTreeNode root, LinkedList list) {
        if (root == null) {
            return;
        }
        Queue q = new QueueArray();
        // 根节点入队
        q.enqueue(q);
        while (!q.isEmpty()) {
            // 取出队首节点p并访问
            BinTreeNode p = (BinTreeNode) q.dequeue();
            list.insertLast(p);
            // 将 p 的非空左右孩子依次入队
            if (p.hasLChild()) {
                q.enqueue(p.getlChild());
            }
            if (p.hasRChild()) {
                q.enqueue(p.getrChild());
            }
        }
    }

    /**
     * 后续遍历的非递归算法
     *
     * @param root
     * @param list
     */
    private void postOrderTraverse(BinTreeNode root, LinkedList list) {
        if (root == null) {
            return;
        }
        BinTreeNode p = root;
        Stack s = new StackSingleLinked();

        while (p != null || !s.isEmpty()) {

            while (p != null) {
                // 将根节点入栈
                s.push(p);
                if (p.hasLChild()) {
                    p = p.getlChild();
                } else {
                    p = p.getrChild();
                }
            }
            if (!s.isEmpty()) {
                // 取出栈顶根结点访问之
                p = (BinTreeNode) s.pop();
                list.insertLast(p);
            }
            // 满足条件时，说明栈顶根节点右子树已访问，应出栈访问之
            while (!s.isEmpty() && ((BinTreeNode) s.peek()).getrChild() == p) {
                p = (BinTreeNode) s.pop();
                list.insertLast(p);
            }
            // 转向栈顶根结点的右子树继续后序遍历
            if (!s.isEmpty()) {
                p = ((BinTreeNode) s.peek()).getrChild();
            } else {
                p = null;
            }
        }

    }

    /**
     * 中序遍历的非递归算法
     *
     * @param root
     * @param list
     */
    private void inOrderTraverse(BinTreeNode root, LinkedList list) {
        if (root == null) {
            return;
        }
        BinTreeNode p = root;
        Stack s = new StackSingleLinked();
        while (p != null || !s.isEmpty()) {
            // 一直向左走
            while (p != null) {
                // 将根节点入栈
                s.push(p);
                p = p.getlChild();
            }
            if (!s.isEmpty()) {
                p = (BinTreeNode) s.pop();
                list.insertLast(p);
                // 转向根的右子节点遍历
                p = p.getrChild();
            }
        }
    }

    /**
     * 先序非递归算法
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
     * 前序递归算法
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
