package com.datastructure.graph.directed;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * <pre>
 * Def: Vertices v and w are strongly connected components when there is a
 * directed path from v to w and directed path from w to v
 * 
 * Kosaraju Sharir Algorithm:-
 * Phase 1: Perform reverse post order on Digraph (nothing but Topological ordering)
 * Phase 2: Do DFS on Reversed Digraph
 * </pre>
 * 
 * @author sriram
 *
 */
public class KosarajuSharirSCC {

    private int count;
    private Integer[] id;
    private boolean[] visited;

    public KosarajuSharirSCC(Digraph g) {
	id = new Integer[g.V()];
	visited = new boolean[g.V()];
	Digraph r = g.reverse();
	TopologicalSort ts = new TopologicalSort(r);
	for (int i : ts.order()) {
	    if (!visited[i]) {
		dfs(g, i);
		count++;
	    }
	}
    }

    private void dfs(Digraph g, int v) {
	visited[v] = true;
	id[v] = count;
	for (int w : g.adj(v)) {
	    if (!visited[w]) {
		dfs(g, w);
	    }
	}
    }

    public boolean connected(int u, int v) {
	return id[u] == id[v];
    }

    public int count() {
	return count;
    }

    public static void main(String[] args) {
	for (String arg : args) {
	    StdOut.println("Input : " + arg);
	    In in = new In(arg);
	    int n = in.readInt();
	    System.out.println("# of Edges : " + n);
	    Digraph g = new Digraph(n);
	    for (int i = 0; i < n; i++) {
		int v = in.readInt();
		int w = in.readInt();
		g.addEdge(v, w);
	    }

	    KosarajuSharirSCC cc = new KosarajuSharirSCC(g);
	    StdOut.println("# of connected components : " + cc.count());

	    // No. of queries
	    int q = in.readInt();
	    for (int i = 0; i < q; i++) {
		int v = in.readInt();
		int w = in.readInt();
		StdOut.printf("connected(%d, %d) : %b%n", v, w, cc.connected(v, w));
	    }
	    StdOut.println();
	}
    }

}
