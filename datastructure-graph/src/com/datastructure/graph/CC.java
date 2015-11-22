package com.datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CC {

    private int[] id;
    private boolean[] visited;
    private int count;

    public CC(Graph g) {
	id = new int[g.V()];
	visited = new boolean[g.V()];
	for (int i = 0; i < g.V(); i++) {
	    if (!visited[i]) {
		dfs(g, i);
		count++;
	    }
	}
    }

    private void dfs(Graph g, int v) {
	visited[v] = true;
	id[v] = count;
	for (int w : g.adj(v)) {
	    if (!visited[w]) {
		dfs(g, w);
	    }
	}
    }

    public boolean connected(int v, int w) {
	return id[v] == id[w];
    }

    public int count() {
	return count;
    }

    public static void main(String[] args) {
	In in = new In(args[0]);
	int n = in.readInt();
	System.out.println("# of vertices : " + n);
	Graph g = new AdjacencyListGraph(n);
	for (int i = 0; i < n; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}

	CC cc = new CC(g);
	StdOut.println("# of connected components : " + cc.count());

	// No. of queries
	int q = in.readInt();
	for (int i = 0; i < q; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    StdOut.printf("connected(%d, %d) : %b%n", v, w, cc.connected(v, w));
	}

    }
}