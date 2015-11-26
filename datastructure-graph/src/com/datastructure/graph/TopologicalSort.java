package com.datastructure.graph;

import com.datastructure.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TopologicalSort {

    private boolean[] visited;
    private Stack<Integer> stack;

    public TopologicalSort(Graph g) {
	visited = new boolean[g.V()];
	stack = new Stack<>();
	for (int v = 0; v < g.V(); v++) {
	    if (!visited[v]) {
		dfs(g, v);
	    }
	}
    }

    private void dfs(Graph g, int v) {
	visited[v] = true;
	for (int w : g.adj(v)) {
	    if (!visited[w])
		dfs(g, w);
	}
	// since performing DFS, stack gets added with element
	// in reverse order
	stack.push(v);
    }

    public Iterable<Integer> order() {
	return stack;
    }

    public static void main(String[] args) {
	In in = new In(args[0]);
	int n = in.readInt();
	Digraph g = new Digraph(n);
	while (!in.isEmpty()) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}

	System.out.println(g);
	System.out.println("Topological sort: ");
	TopologicalSort t = new TopologicalSort(g);
	for (Integer v : t.order()) {
	    StdOut.printf("%d\t", v);
	}
	StdOut.println();
    }

}
