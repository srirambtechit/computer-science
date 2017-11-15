package com.msrm.datastructure.graph.directed;

public class DirectedDFS {

	private boolean[] marked;

	public DirectedDFS(Digraph g, Integer src) {
		marked = new boolean[g.V()];
		dfs(g, src);
	}

	private void dfs(Digraph g, Integer v) {
		marked[v] = true;
		for (Integer w : g.adj(v)) {
			if (!marked[w])
				dfs(g, w);
		}
	}

	// Checks given vertex is reachable from source
	public boolean visited(int v) {
		return marked[v];
	}

}
