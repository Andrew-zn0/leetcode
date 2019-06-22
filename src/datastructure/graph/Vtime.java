package datastructure.graph;

/**
 * @author Jay
 * @description AOE 关键路径
 * @date Created in 2019/6/22 13:13
 */
public class Vtime {
    /**
     * 最早发生时间
     */
    private int ve;
    /**
     * 最迟发生时间
     */
    private int vl;

    public int getVE() {
        return ve;
    }

    public int getVL() {
        return vl;
    }

    public void setVE(int t) {
        ve = t;
    }

    public void setVL(int t) {
        vl = t;
    }

    public Vtime() {
        this(0, Integer.MAX_VALUE);
    }

    public Vtime(int ve, int vl) {
        this.ve = ve;
        this.vl = vl;
    }
}
