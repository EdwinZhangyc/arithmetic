package com.std.arithemic.geektime.datastruct;

import java.util.LinkedList;

/**
 * @author zyc
 * @date 2021/7/22 19:21
 * 无向图
 */
public class Graph {
    /**
     * 顶点个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
             adj[i] = new LinkedList<>();
        }
    }
    /**
     * 无向图一条边存两次
     */
    public void addEdge (int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t){
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s]=true;
        java.util.Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    /**
     * 全局变量或者类成员变量
     */
    boolean found = false;
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int s, int t, boolean[] visited, int[] prev) {
        if (found){
            return;
        }
        visited[s] = true;
        if (s == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[s].size(); ++i) {
            int q = adj[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}