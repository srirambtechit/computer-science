package com.datastructure.graph;

import java.util.Arrays;

import com.datastructure.Queue;

public class BFSGraphDistanceTracker {

    private Integer[] edgeTo;
    private Integer[] distTo;

    public BFSGraphDistanceTracker(AdjacencyListGraph g, int src) {
	this.edgeTo = new Integer[g.V()];
	this.distTo = new Integer[g.V()];
	bfs(g, src);
	System.out.println(Arrays.toString(edgeTo));
	System.out.println(Arrays.toString(distTo));
    }

    public void bfs(AdjacencyListGraph g, Integer v) {
	int dist = 0;
	Queue<Integer> q = new Queue<>();
	q.enqueue(v);
	distTo[v] = dist;
	while (!q.isEmpty()) {
	    v = q.dequeue();
	    dist++;
	    for (Integer w : g.adj(v)) {
		if (distTo[w] == null) {
		    q.enqueue(w);
		    edgeTo[w] = v;
		    distTo[w] = dist;
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

	new BFSGraphDistanceTracker(g, 3);
    }
}
