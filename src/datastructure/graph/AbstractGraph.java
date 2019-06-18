package datastructure.graph;

import datastructure.linked.Iterator;
import datastructure.linked.LinkedList;
import datastructure.linked.MyDoubleNodeLinkedList;
import datastructure.queue.Queue;
import datastructure.queue.QueueSingleLinked;
import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;

/**
 * @author Jay
 * @date 2019/6/16 21:49
 * @description 抽象类
 */
public abstract class AbstractGraph implements Graph {
    /**
     * 图深度优先遍历结果
     *
     * @param v
     * @return
     */
    @Override
    public Iterator DFSTraverse(Vertex v) {
        // 遍历结果
        LinkedList traverseSeq = new MyDoubleNodeLinkedList();
        // 重置顶点状态
        resetVexStatus();
        // 从图未曾访问的其他顶点重新搜索
        Iterator it = getVertex();
        for (it.first(); !it.isDone(); it.next()) {
            Vertex u = (Vertex) it.currentItem();
            if (!u.isVisited()) {
                DFSRecursion(u, traverseSeq);
            }
        }
        return traverseSeq.elements();
    }

    protected void DFSRecursion(Vertex v, LinkedList list) {
        //  设置顶点 v 为已访问
        v.setToVisited();
        // 访问顶点
        list.insertLast(v);

        Iterator it = adjVertexs(v);
        for (it.first(); !it.isDone(); it.next()) {
            Vertex u = (Vertex) it.currentItem();
            if (!u.isVisited()) {
                DFSRecursion(u, list);
            }
        }
    }

    /**
     * 取得顶点 v 的所有邻接点
     *
     * @param v
     * @return
     */
    protected Iterator adjVertexs(Vertex v) {

        return null;
    }


    protected void resetVexStatus() {

    }

    protected void resetEdgeType() {

    }

    /**
     * 从顶点 v 出发深度优先搜索的非递归算法
     * <p>
     * ⑴ 首先将初始顶点 v 入栈；
     * ⑵ 当堆栈不为空时，重复以下处理
     * 栈顶元素出栈，若未访问，
     * 则访问之并设置访问标志，将其未曾访问的邻接点入栈；
     * ⑶ 如果图中还有未曾访问的邻接点，选择一个重复以上过程。
     *
     * @param v
     * @param list
     */
    private void DFS(Vertex v, LinkedList list) {
        Stack s = new StackSingleLinked();
        s.push(v);
        while (!s.isEmpty()) {
            // 取栈顶元素
            Vertex u = (Vertex) s.pop();
            // 判断元素是否访问过
            if (!u.isVisited()) {
                u.setToVisited();
                list.insertLast(u);
                // 未访问的邻接点入栈
                Iterator it = adjVertexs(u);
                for (it.first(); !it.isDone(); it.next()) {
                    Vertex adj = (Vertex) it.currentItem();
                    if (!adj.isVisited()) {
                        s.push(adj);
                    }
                }
            }
        }
    }

    /**
     * 队列实现广度优先搜索
     * <p>
     * ① 首先访问初始顶点 v 并入队；
     * ② 当队列不为空时，重复以下处理
     * 队首元素出队，访问其所有未曾访问的邻接点，并它们入队；
     * ③ 如果图中还有未曾访问的邻接点，选择一个重复以上过程
     *
     * @param v
     * @return
     */
    @Override
    public Iterator BFSTraverse(Vertex v) {
        // 遍历结果
        LinkedList traverseSeq = new MyDoubleNodeLinkedList();
        // 重置顶点状态
        resetVexStatus();
        // 广度搜索
        BFS(v, traverseSeq);
        // 从图中未访问的顶点重新搜索
        Iterator it = getVertex();
        for (it.first(); !it.isDone(); it.next()) {
            Vertex u = (Vertex) it.currentItem();
            if (!u.isVisited()) {
                DFSRecursion(u, traverseSeq);
            }
        }
        return traverseSeq.elements();
    }

    /**
     * 广度搜索
     *
     * @param v
     * @param list
     */
    protected void BFS(Vertex v, LinkedList list) {
        Queue q = new QueueSingleLinked();
        // 访问顶点v
        v.setToVisited();
        list.insertLast(v);
        // 顶点入队
        q.enqueue(v);
        while (!q.isEmpty()) {
            // 队首元素出队
            Vertex u = (Vertex) q.dequeue();
            // 访问其未曾访问的邻接点，并入队
            Iterator it = adjVertexs(u);

            for (it.first(); !it.isDone(); it.next()) {
                Vertex adj = (Vertex) it.currentItem();
                if (!adj.isVisited()) {
                    adj.setToVisited();
                    list.insertLast(adj);
                    q.enqueue(adj);
                }
            }
        }
    }

}
