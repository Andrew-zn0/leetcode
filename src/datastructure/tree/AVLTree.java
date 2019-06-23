package datastructure.tree;

import datastructure.linked.Node;
import datastructure.list.Strategy;

/**
 * @author Jay
 * @description
 * @date Created in 2019/6/23 14:32
 */
public class AVLTree {

    private BinTreeNode root;
    /**
     * 平衡节点
     */
    private BinTreeNode startBN;
    private Strategy strategy;

    /**
     * 输入：待查元素 ele
     * 输出：对应元素在二叉查找树中的结点位置
     * 递归算法
     *
     * @param ele
     * @return
     */
    public Node search(Object ele) {
        return binTSearchRe(root, ele);
    }

    private Node binTSearchRe(BinTreeNode root, Object ele) {
        if (root == null) {
            return null;
        }
        switch (strategy.compare(ele, root.getData())) {
            // 等于
            case 0:
                return root;
            // 小于
            case -1:
                return binTSearchRe(root.getlChild(), ele);
            // 大于
            default:
                return binTSearchRe(root.getrChild(), ele);
        }
    }

    /**
     * 输入：根结点 rt，待查元素 ele
     * 输出：对应元素在 rt 为根的二叉查找树中的结点位置
     * 非递归算法
     *
     * @param rt
     * @param ele
     * @return
     */
    private Node binTSearch(BinTreeNode rt, Object ele) {

        while (rt != null) {
            switch (strategy.compare(ele, rt.getData())) {
                // 等于
                case 0:
                    return rt;
                // 小于
                case -1:
                    rt = rt.getlChild();
                    break;
                // 大于
                default:
                    rt = rt.getrChild();
            }
        }
        return null;
    }

    /**
     * 输入：根结点 v
     * 输出：在 v 为根的二叉查找树中最小元素的位置
     *
     * @param v
     * @return
     */
    public Node min(BinTreeNode v) {

        if (v != null) {
            while (v.hasLChild()) {
                v = v.getlChild();
            }
        }
        return v;
    }

    /**
     * 输入：根结点 v
     * 输出：在 v 为根的二叉查找树中最大元素的位置
     *
     * @param v
     * @return
     */
    public Node max(BinTreeNode v) {

        if (v != null) {
            while (v.hasRChild()) {
                v = v.getrChild();
            }
        }
        return v;
    }

    /**
     * 输入：根结点 v
     * 输出：返回 v 在中序遍历序列中的后续结点
     *
     * @param v
     * @return
     */
    private BinTreeNode getSuccessor(BinTreeNode v) {
        if (v == null) {
            return null;
        }
        if (v.hasRChild()) {
            return (BinTreeNode) min(v.getrChild());
        }
        while (v.isRChild()) {
            v = v.getParent();
        }
        return v.getParent();
    }


    /**
     * 输入：根结点 v
     * 输出：返回 v 在中序遍历序列中的前驱结点
     *
     * @param v
     * @return
     */
    private BinTreeNode getPredecessor(BinTreeNode v) {
        if (v == null) {
            return null;
        }
        if (v.hasLChild()) {
            return (BinTreeNode) max(v.getlChild());
        }

        while (v.isLChild()) {
            v = v.getParent();
        }
        return v.getParent();
    }

    /**
     * 输入：待插元素 ele
     * 输出：在二叉查找树中插入 ele
     *
     * @param ele
     */
    public void insert(Object ele) {
        BinTreeNode p = null;
        BinTreeNode current = root;
        // 找到待插入位置
        while (current != null) {
            p = current;
            if (strategy.compare(ele, current.getData()) < 0) {
                current = current.getlChild();

            } else {
                current = current.getrChild();
            }
        }
        // 待平衡点
        startBN = p;
        if (p == null) {
            // 树为空
            root = new BinTreeNode();
        } else if (strategy.compare(ele, p.getData()) < 0) {
            p.setLChild(new BinTreeNode(ele));
        } else {
            p.setrChild(new BinTreeNode(ele));
        }

    }

    /**
     * 输入：待删除元素 ele
     * 输出：在二叉查找树中删除 ele
     *
     * @param ele
     * @return
     */
    public Object remove(Object ele) {
        BinTreeNode v = (BinTreeNode) binTSearch(root, ele);
        // 查找失败
        if (v == null) {
            return null;
        }
        // 待删结点
        BinTreeNode del = null;
        // 待删结点的子树
        BinTreeNode subT = null;
        // 确定待删结点
        if (!v.hasLChild() || !v.hasRChild()) {
            del = v;
        } else {

            del = getPredecessor(v);
            Object old = v.getData();
            v.setData(del.getData());
            del.setData(old);
        }
        // 待平衡出发点 ＊
        startBN = del.getParent();
        // 此时待删结点只有左子树或右子树
        if (del.hasLChild()) {
            subT = del.getlChild();
        } else {
            subT = del.getrChild();
        }
        // 若待删结点为根
        if (del == root) {
            if (subT != null) {
                subT.sever();
            }
            root = subT;
        } else {
            if (subT != null) {
                // del 为非叶子结点
                if (del.isLChild()) {
                    del.getParent().setLChild(subT);
                } else {
                    del.getParent().setrChild(subT);
                }
                //  为叶子结点
            } else {
                del.sever();
            }
        }
        return del.getData();
    }

}
