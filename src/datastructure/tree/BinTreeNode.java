package datastructure.tree;

import datastructure.linked.Node;

/**
 * @author Jay
 * @description 三叉链表实现二叉树
 * @date Created in 2019/6/1 12:13
 */
public class BinTreeNode implements Node {
    /**
     * 数据域
     */
    private Object data;
    /**
     * 父节点
     */
    private BinTreeNode parent;
    /**
     * 左子节点
     */
    private BinTreeNode lChild;
    /**
     * 右子节点
     */
    private BinTreeNode rChild;
    /**
     * 以该节点为根的子树的高度
     */
    private int height;
    /**
     * 该节点子孙数(包括该节点)
     */
    private int size;

    public BinTreeNode() {
        this(null);
    }

    public BinTreeNode getParent() {
        return parent;
    }

    public void setParent(BinTreeNode parent) {
        this.parent = parent;
    }

    public BinTreeNode getlChild() {
        return lChild;
    }

    public void setlChild(BinTreeNode lChild) {
        this.lChild = lChild;
    }

    public BinTreeNode getrChild() {
        return rChild;
    }

    public void setrChild(BinTreeNode rChild) {
        this.rChild = rChild;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BinTreeNode(Object e) {
        data = e;
        height = 0;
        size = 1;
        parent = lChild = rChild = null;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object obj) {
        data = obj;
    }
    /******前结点位置情况******/
    /**
     * 判断是否有父节点
     */
    public boolean hasParent() {

        return parent != null;
    }

    /**
     * 判断是否有左子节点
     */
    public boolean hasLChild() {

        return lChild != null;
    }

    /**
     * 判断是否有右子节点
     */
    public boolean hasRChild() {

        return rChild != null;
    }

    /**
     * 判断是否为叶子节点
     */
    public boolean isLeaf() {

        return !hasLChild() && !hasRChild();
    }

    /**
     * 判断是否为某结点的左子节点
     */
    public boolean isLChild() {
        return (hasParent() && this == parent.lChild);
    }

    /**
     * 判断是否为某结点的右子节点
     */
    public boolean isRChild() {
        return (hasParent() && this == parent.rChild);
    }

    /******与 height 相关的方法******/
    /**
     * 取结点的高度,即以该结点为根的树的高度
     */
    public int getHeight() {
        return height;
    }

    /**
     * 更新当前结点及其祖先的高度
     */
    public void updateHeight() {
        // 新高度初始化为 0,高度等于左右子树高度加 1 中的大者
        int newH = 0;
        if (hasLChild()) {
            newH = Math.max(newH, 1 + getlChild().getHeight());
        }
        if (hasRChild()) {
            newH = Math.max(newH, 1 + getrChild().getHeight());
        }
        if (newH == height) {
            return;
        }
        // 跟新高度
        height = newH;
        // 递归更新祖先高度
        if (hasParent()) {
            getParent().updateHeight();
        }
    }

    /******与 size 相关的方法******/
    /**
     * 更新当前结点及其祖先的子孙数
     */
    public void updateSize() {
        // 初始化节点本身
        size = 1;
        if (hasLChild()) {
            size += getlChild().getSize();
        }
        if (hasRChild()) {
            size += getrChild().getSize();
        }
        if (hasParent()) {
            size += getParent().getSize();
        }

    }

    /******与 parent 相关的方法******/
    /**
     * 断开与父节点的关系
     */
    public void sever() {
        if (!hasParent()) {
            return;
        }
        if (isLChild()) {
            parent.lChild = null;
        } else {
            parent.rChild = null;
        }
        // 更新父节点以及祖先高度
        parent.updateHeight();
        // 更新父节点以及祖先规模
        parent.updateSize();
        parent = null;
    }
    /******与 lChild 相关的方法******/
    /**
     * 设置当前结点的左孩子,返回原左孩子
     */

    public BinTreeNode setLChild(BinTreeNode lc) {
        BinTreeNode oldLC = this.lChild;
        // 断开当前左子节点与节点关系
        if (hasLChild()) {
            lChild.sever();
        }

        if (lc != null) {
            lc.sever();
            this.lChild = lc;
            lc.parent = this;
            this.updateSize();
            this.updateHeight();

        }
        return oldLC;
    }

    /******与 lChild 相关的方法******/
    /**
     * 设置当前结点的左孩子,返回原左孩子
     */

    public BinTreeNode setRChild(BinTreeNode rc) {
        BinTreeNode oldRC = this.lChild;
        // 断开当前右子节点与节点关系
        if (hasRChild()) {
            rChild.sever();
        }

        if (rc != null) {
            rc.sever();
            this.rChild = rc;
            rc.parent = this;
            this.updateSize();
            this.updateHeight();
        }
        return oldRC;
    }
}
