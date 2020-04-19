package top.ljming.learning.indepth.dsa.lesson.geekbang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 极客时间: 王争-数据结构与算法之美.
 *
 * @author lijm
 */
public class Graph { // 无向图

    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    // 深度优先搜索需要这个变量，表示找到终点，就不在进行查找
    private boolean found = false;

    private Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int s, int t) { // 无向图的一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    // Breadth-First-Search 广度优先搜索 寻找最短路径
    private void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v]; // 记录顶点是否以访问
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>(); //队列存储已经访问、但相连的顶点还没有被访问的顶点。
        queue.add(s); // 先把起始顶点入队

        int[] prev = new int[v]; // 反向存储顶点路径，存储的是当前节点是从哪个节点过来的
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (!queue.isEmpty()) {
            int w = queue.poll(); // w表示当前处理的顶点
            for (int i = 0; i < adj[w].size(); i++) { // 循环和w顶点相连的顶点，用q表示
                int q = adj[w].get(i);
                if (!visited[q]) { // 判断q是否已经被访问过
                    prev[q] = w;
                    if (q == t) { // 如果q已经是终点，那么就直接返回
                        print(prev, s, t);
                        return;
                    }
                    visited[w] = true; // 更新w顶点已经被访问了
                    queue.add(q); // q还没被访问，入队
                }
            }
        }
    }

    // Depth-First-Search 深度优先搜索，走迷宫
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }


    private void print(int[] prev, int s, int t) { // 递归打印 s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "->");
    }





    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bfs(0, 7);

        System.out.println();
        graph.dfs(0, 7);

    }
}
