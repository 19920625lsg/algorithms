/***********************************************************
 * @Description : 二分图检测
 * 原理：用两种颜色对图进行染色，如果最后每个顶点的所有邻接点和这个顶点的颜色都不同，说明当前图是个二分图
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2019-08-06 23:20
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter04DFSInAction.Section10BiPartitionDetect;

import Chapter02GraphExpress.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分图染色过程中用到的颜色枚举,用于给定点染色
 */
enum VertexColor {
    BLUE(0, "蓝色"), GREEN(1, "绿色");

    VertexColor(int num, String color) {
        this.num = num;
        this.color = color;
    }

    private int num;
    private String color;

    public int getNum() {
        return num;
    }
}

public class GraphDFSBiPartition {
    private Graph graph;

    /**
     * 存储顶点是否被访问的数组
     */
    private boolean[] visited;

    /**
     * 存放图的深度优先遍历的结果
     */
    private List<Integer> orderList = new ArrayList<>();

    /**
     * 颜色数组，存储每个节点的颜色
     */
    private int[] colors;

    /**
     * 是否是二分图,默认成是二分图
     */
    private boolean biPartition = true;

    public GraphDFSBiPartition(Graph graph) {
        this.graph = graph;
        // 初始化访问数组，用图的顶点个数来访问
        visited = new boolean[graph.V()];
        // 初始化颜色数组
        this.colors = new int[graph.V()];
        Arrays.fill(this.colors, -1);
        // 从dfs(0)改成下面的代码，可以支持非连通的图,不用考虑连通分量的时候直接用dfs(v)即可
        for (int v = 0; v < graph.V(); v++) {
            if (!visited[v]) {
                // 第一个节点染成蓝色(0)
                if (!dfs(v, VertexColor.BLUE.getNum())) {
                    biPartition = false;
                    // 一旦检测到二分图立马跳出，一定别忘
                    break;
                }
            }
        }
    }

    public Iterable<Integer> getOrderList() {
        return orderList;
    }

    /**
     * 是否是二分图
     */
    public boolean isBiPartition() {
        return biPartition;
    }

    /**
     * dfs过程中检测当前图是否是二分图
     *
     * @param v     当前的顶点
     * @param color v点的染色
     * @return 是否是二分图
     */
    private boolean dfs(int v, int color) {
        visited[v] = true;
        orderList.add(v);
        colors[v] = color;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                // 颜色只有蓝(0)、绿(1)两种，w是v的邻接点，根据二分图的检测原理，w、v的颜色必须相反，只能一蓝一绿，蓝+绿 = 0 + 1 = 1,所以1-v的颜色 = 1-color = w的颜色
                if (!dfs(w, 1 - color)) {
                    // 返回false表示不是二分图
                    return false;
                }
            } else if (colors[w] == colors[v]) {
                // 如果w已经访问过，但是w作为v的邻接点和v的颜色相同，说明有二分图
                return false;
            }
        }
        return true;
    }
}
