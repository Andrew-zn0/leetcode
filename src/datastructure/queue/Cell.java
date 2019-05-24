package datastructure.queue;

/**
 * @author Jay
 * @description 迷宫单元定义
 * @date Created in 2019/5/24 16:26
 */
public class Cell {
    /**
     * 单元所在行
     */
    int x;
    /**
     * 单元所在列
     */
    int y;
    /**
     * 是否访问过
     */
    boolean visited;
    /**
     * 是墙('1')、可通路('0')或起点到终点的路径('*')
     */
    char c;

    public Cell(int x, int y, char c, boolean visited) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.visited = visited;
    }
}
