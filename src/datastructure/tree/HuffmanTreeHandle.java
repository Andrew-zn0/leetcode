package datastructure.tree;

import datastructure.list.MyArrayList;
import datastructure.list.MyList;

/**
 * @author Jay
 * @description 哈夫曼树相关操作
 * @date Created in 2019/6/5 15:21
 */
public class HuffmanTreeHandle {
    /**
     * 通过结点数组生成 Huffman 树
     *
     * @param nodes
     * @return
     */
    private static HuffmanTreeNode buildHuffmanTree(HuffmanTreeNode[] nodes) {
        int n = nodes.length;
        if (n < 2) {
            return nodes[0];
        }
        // 根结点线性表，按 weight 从大到小有序
        MyList l = new MyArrayList();
        for (int i = 0; i < n; i++) {
            insertToList(l, nodes[i]);
        }
        // 选则weight最小的俩棵树合并,循环n-1次
        for (int i = 0; i < n; i++) {
            HuffmanTreeNode min1 = (HuffmanTreeNode) l.remove(l.getSize() - 1);
            HuffmanTreeNode min2 = (HuffmanTreeNode) l.remove(l.getSize() - 1);
            HuffmanTreeNode newRoot = new HuffmanTreeNode(min1.getWeight() + min2.getWeight());
            newRoot.setLChild(min1);
            newRoot.setRChild(min2);
            // 重新放入线性表
            insertToList(l, newRoot);
        }
        // 返回 Huffman 树的根
        return (HuffmanTreeNode) l.get(0);
    }

    /**
     * 将结点按照 weight 从大到小的顺序插入线性表
     *
     * @param l
     * @param node
     */
    private static void insertToList(MyList l, HuffmanTreeNode node) {

        for (int j = 0; j < l.getSize(); j++) {
            if (node.getWeight() > ((HuffmanTreeNode) l.get(j)).getWeight()) {
                l.insert(j, node);
                return;
            }
        }
        l.insert(l.getSize(), node);
    }

    /**
     * 递归生成 Huffman 编码
     *
     * @param root
     */
    private static void generateHuffmanCode(HuffmanTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.hasParent()) {

            if (root.isLChild()) {
                root.setCoding(root.getParent().getCoding() + "0");
            } else {
                root.setCoding(root.getParent().getCoding() + "1");
            }
        }
        generateHuffmanCode(root.getlChild());
        generateHuffmanCode(root.getrChild());
    }
}
