package datastructure.tree;

import datastructure.linked.Node;
import datastructure.list.Strategy;

/**
 * @author Jay
 * @description
 * @date Created in 2019/6/23 14:32
 */
public class BinTree {

    protected BinTreeNode root;
    /**
     * 平衡节点
     */
    protected BinTreeNode startBN;
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
     * <p>
     * 算法分析:
     * 1.若被删除节点无左右子树,直接删除
     * 2.若被删除节点有右子树或者左子树,删除节点,子树节点代替其位置.
     * 3.若被删除节点有右子树并且有左子树,找到其前驱元素,代替节点位置,
     * 其前驱元素继续根据1,2,3步骤判断,直到结束.
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

    /**
     * 输入：失衡的结点 z
     * 输出：平衡后子树的根结点
     * <p>
     * 四种原因:
     * 1.  失衡是由于 g 的左孩子的左子树过高造成的；
     * 2.  失衡是由于 g 的右孩子的右子树过高造成的；
     * 3.  失衡是由于 g 的左孩子的右子树过高造成的；
     * 4.  失衡是由于 g 的右孩子的左子树过高造成的。
     * <p>
     * 旋转操作的统一实现方法
     *
     * @param z
     * @return
     */
    protected BinTreeNode rotate(BinTreeNode z) {
        // 取 y 为 z 更高的孩子
        BinTreeNode y = higherSubT(z);
        // x 为 y 更高的孩子
        BinTreeNode x = higherSubT(y);
        // 记录: z 是否左孩子
        boolean isLeft = z.isLChild();
        // p为z的父节点
        BinTreeNode p = z.getParent();
        // 自左向右，三个节点
        BinTreeNode a, b, c;
        // 自左向右，四棵子树
        BinTreeNode t0, t1, t2, t3;

        // 以下分四种情况重命名
        // 若y是左节点
        if (y.isLChild()) {
            c = z;
            t3 = z.getrChild();
            // 若x是左节点
            if (x.isLChild()) {
                b = y;
                t2 = y.getrChild();
                a = x;
                t1 = x.getrChild();
                t0 = x.getlChild();
            }
            // 若x是右节点
            else {
                a = y;
                t0 = y.getlChild();
                b = x;
                t1 = x.getlChild();
                t2 = x.getrChild();
            }
        }
        // 若y是右节点
        else {
            a = z;
            t0 = z.getlChild();
            // 若 x 是右孩子(右右失衡)
            if (x.isRChild()) {
                b = y;
                t1 = y.getlChild();
                c = x;
                t2 = x.getlChild();
                t3 = x.getrChild();
            }
            // 若 x 是左孩子(右左失衡)
            else {
                c = y;
                t3 = y.getrChild();
                b = x;
                t1 = x.getlChild();
                t2 = x.getrChild();
            }
        }
        // 摘下三个节点
        z.sever();
        y.sever();
        x.sever();
        // 摘下四棵子树
        if (t0 != null) {
            t0.sever();
        }
        if (t1 != null) {
            t1.sever();
        }
        if (t2 != null) {
            t2.sever();
        }
        if (t3 != null) {
            t3.sever();
        }

        // 重新链接
        a.setLChild(t0);
        a.setRChild(t1);
        c.setLChild(t2);
        c.setRChild(t3);
        b.setLChild(a);
        b.setRChild(c);
        //子 树重新接入原树
        if (p != null) {
            if (isLeft) {
                p.setLChild(b);
            } else {
                p.setRChild(b);
            }
        }
        // 返回新的子树根
        return b;
    }

    /**
     * 返回结点 v 较高的子树
     *
     * @param v
     * @return
     */
    private BinTreeNode higherSubT(BinTreeNode v) {
        if (v == null) {
            return null;
        }
        int lH = (v.hasLChild()) ? (v.getlChild().getHeight()) : -1;
        int rH = (v.hasRChild()) ? (v.getrChild().getHeight()) : -1;
        if (lH > rH) {
            return v.getlChild();
        }
        if (rH > lH) {
            return v.getrChild();
        }
        if (v.isLChild()) {
            return v.getlChild();

        } else {
            return v.getrChild();
        }
    }


}
