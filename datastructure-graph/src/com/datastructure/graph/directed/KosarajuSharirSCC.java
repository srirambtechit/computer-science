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
	Digraph g = DSUtil.createDigraph(args[0]);
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
    }

}
