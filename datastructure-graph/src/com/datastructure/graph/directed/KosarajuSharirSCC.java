package com.datastructure.graph.directed;

import java.util.Iterator;

import com.datastructure.graph.Edge;

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
	DepthFirstSearch dfs = new DepthFirstSearch(g.reverse());
	for (int i : dfs.reversePost()) {
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
	String file = "/home/sriram/git/computer-science/datastructure-graph/data/scc2.txt";
	Digraph g = DSUtil.createDigraph(file);
	StdOut.println(g);

	KosarajuSharirSCC cc = new KosarajuSharirSCC(g);
	StdOut.println("# of connected components : " + cc.count());

	StdOut.println("Querying graph");
	Iterator<Edge> itr = DSUtil.data.iterator();
	while (itr.hasNext()) {
	    Edge e = itr.next();
	    int v = e.either();
	    int w = e.other(v);
	    StdOut.printf("connected(%d, %d) : %b%n", v, w, cc.connected(v, w));
	}
	//
	// args = new String[1];
	// args[0] = new
	// String("/home/sriram/git/computer-science/datastructure-graph/data/scc2.txt");
	// for (String arg : args) {
	// StdOut.println("Input : " + arg);
	// In in = new In(arg);
	// int V = in.readInt();
	// int E = in.readInt();
	// System.out.println("Edge count : " + E);
	// Digraph g = new Digraph(V);
	// for (int i = 0; i < E; i++) {
	// int v = in.readInt();
	// int w = in.readInt();
	// g.addEdge(v, w);
	// }
	//
	// StdOut.println(g);
	//
	// KosarajuSharirSCC cc = new KosarajuSharirSCC(g);
	// StdOut.println("# of connected components : " + cc.count());
	//
	// // No. of queries
	// int q = in.readInt();
	// for (int i = 0; i < q; i++) {
	// int v = in.readInt();
	// int w = in.readInt();
	// StdOut.printf("connected(%d, %d) : %b%n", v, w, cc.connected(v, w));
	// }
	// StdOut.println();
	// }
    }

}
