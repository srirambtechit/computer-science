package com.datastructure.graph;

import com.datastructure.Bucket;
import com.datastructure.Stack;

public class DFSGraphPath {

    private boolean[] visited;
    private Integer[] edgeTo;
    private int src;

    public DFSGraphPath(AdjacencyListGraph graph, int src) {
	super();
	this.src = src;
	this.visited = new boolean[graph.V()];
	this.edgeTo = new Integer[graph.V()];
	dfs(graph, src);
    }

    public int getSource() {
	return src;
    }

    private void dfs(AdjacencyListGraph g, int v) {
	visited[v] = true;
	for (Integer w : g.adj(v)) {
	    if (!visited[w]) {
		dfs(g, w);
		edgeTo[w] = v;
	    }
	}
    }

    public boolean hasPath(int v) {
	if (v >= visited.length)
	    return false;
	return visited[v];
    }

    public Iterable<Integer> path(int v) {
	if (!hasPath(v))
	    return null;
	Stack<Integer> s = new Stack<>();
	for (; edgeTo[v] != null; v = edgeTo[v])
	    s.push(v);
	s.push(src);
	Bucket<Integer> b = new Bucket<>();
	while (!s.isEmpty()) {
	    b.add(s.pop());
	}
	return b;
    }

    public static void main(String[] args) {
	AdjacencyListGraph g = new AdjacencyListGraph(7);
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(0, 3);
	g.addEdge(0, 5);
	g.addEdge(1, 4);
	g.addEdge(4, 5);
	g.addEdge(3, 5);
	g.addEdge(5, 6);
	g.addEdge(0, 6);

	for (int i = 0; i < g.V(); i++) {
	    System.out.printf("%d - ", i);
	    for (Integer element : g.adj(i)) {
		System.out.printf("%d ", element);
	    }
	    System.out.println();
	}

	new DFSGraphTraversal(g, 3);
	DFSGraphPath gp = new DFSGraphPath(g, 3);
	System.out.println(gp.hasPath(4));
	System.out.println(gp.hasPath(14));
	System.out.println(gp.hasPath(6));
	System.out.println(gp.path(4));
	System.out.println(gp.path(3));
	System.out.println(gp.path(13));
    }

}
