package datastructure.tree;

/**
 * @author Jay
 * @description 哈夫曼树的实现
 * @date Created in 2019/6/5 15:17
 */
public class HuffmanTreeNode extends BinTreeNode {
    /**
     * 权值
     */
    private int weight;
    /**
     * 编码
     */
    private String coding = "";

    public HuffmanTreeNode(int weight) {
        this(weight, null);
    }

    public HuffmanTreeNode(int weight, Object e) {
        super(e);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    @Override
    public HuffmanTreeNode getParent() {
        return (HuffmanTreeNode) super.getParent();
    }

    @Override
    public HuffmanTreeNode getlChild() {
        return (HuffmanTreeNode) super.getlChild();
    }

    @Override
    public HuffmanTreeNode getrChild() {
        return (HuffmanTreeNode) super.getrChild();
    }

}
