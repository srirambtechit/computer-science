package com.datastructure.graph;

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
	TopologicalSort ts = new TopologicalSort(g);
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

    public static void main(String[] args) {

    }

}
