package com.datastructure.graph;

import java.util.Arrays;

import com.datastructure.util.Queue;

public class BFSGraphTraversal {

    private boolean[] visited;
    private Integer[] edgeTo;

    public BFSGraphTraversal(Graph g, Integer src) {
	this.visited = new boolean[g.V()];
	this.edgeTo = new Integer[g.V()];
	bfs(g, src);
	System.out.println(Arrays.toString(visited));
	System.out.println(Arrays.toString(edgeTo));
    }

    private void bfs(Graph g, Integer v) {
	visited[v] = true;
	Queue<Integer> q = new Queue<>();
	q.enqueue(v);
	while (!q.isEmpty()) {
	    v = q.dequeue();
	    for (Integer w : g.adj(v)) {
		if (!visited[w]) {
		    visited[w] = true;
		    edgeTo[w] = v;
		    q.enqueue(w);
		}
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
	new BFSGraphTraversal(g, 3);
    }
}
