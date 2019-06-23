package datastructure.tree;

/**
 * @author Jay
 * @date 2019/6/23 23:00
 * @description。 AVL树与一般二叉查找树不同的是，在插入和删除结点之后需要重新进行平衡。
 */
public class AVLTree extends BinTree {
    /**
     * 输入：待插元素 ele
     * <p>
     * 输出：在 AVL 树中插入 ele
     *
     * @param ele
     */
    @Override
    public void insert(Object ele) {
        super.insert(ele);
        root = reBalance(startBN);
    }

    /**
     * 从 v 开始重新平衡 AVL 树
     *
     * @param v
     * @return
     */
    private BinTreeNode reBalance(BinTreeNode v) {
        if (v == null) {
            return root;
        }
        BinTreeNode c = v;
        // 从 v 开始，向上逐一检查 z 的祖先
        while (v != null) {
            // 若 v 失衡，则旋转使之重新平衡
            if (!isBalance(v)) {
                v = rotate(v);
            }
            c = v;
            // 继续检查其父亲
            v = v.getParent();
        }
        return c;
    }

    private boolean isBalance(BinTreeNode v) {
        if (v == null) {
            return true;
        }
        int lH = (v.hasLChild()) ? v.getlChild().getHeight() : -1;
        int rH = (v.hasRChild()) ? v.getrChild().getHeight() : -1;
        return (Math.abs(lH - rH) <= 1);
    }

    /**
     * 输入：待删元素 ele
     * 输出：在 AVL 树中删除 ele
     *
     * @param ele
     * @return
     */
    @Override
    public Object remove(Object ele) {
        Object obj = super.remove(ele);
        root = reBalance(startBN);
        return obj;
    }
}
