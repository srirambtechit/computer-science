package com.datastructure.graph;

import java.util.Arrays;

public class DFSGraphTraversal {

    private boolean[] visited;
    private Integer[] edgeTo;

    public DFSGraphTraversal(AdjacencyListGraph graph, int src) {
	this.visited = new boolean[graph.V()];
	this.edgeTo = new Integer[graph.V()];

	dfs(graph, src);

	System.out.println("visited vertices  : " + Arrays.toString(visited));
	System.out.println("edage of vertices : " + Arrays.toString(edgeTo));
    }

    public void dfs(AdjacencyListGraph graph, int v) {
	visited[v] = true;
	for (int w : graph.adj(v)) {
	    if (!visited[w]) {
		dfs(graph, w);
		edgeTo[w] = v;
	    }
	}
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
    }

}
