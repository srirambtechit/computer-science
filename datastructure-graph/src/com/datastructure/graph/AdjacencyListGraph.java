package com.datastructure.graph;

import java.util.Arrays;

public class AdjacencyListGraph {

    private int V;
    private Bucket<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int v) {
	this.V = v;
	adj = new Bucket[V];
	for (int i = 0; i < V; i++) {
	    adj[i] = new Bucket<>();
	}
    }

    public void addEdge(int v, int w) {
	adj[v].add(w);
	adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

    public int V() {
	return V;
    }

    public int E(int v) {
	return adj[v].size();
    }

    public String toString() {
	return Arrays.deepToString(adj);
    }

    public static void main(String[] args) {
	AdjacencyListGraph g = new AdjacencyListGraph(6);
	System.out.println("No of edage : " + g.E(0));
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(0, 3);
	g.addEdge(0, 5);
	g.addEdge(1, 4);
	g.addEdge(4, 5);
	g.addEdge(3, 5);

	System.out.println("No of edage : " + g.E(0));
	Iterable<Integer> i = g.adj(0);
	for (Integer element : i) {
	    System.out.println(element);
	}
	System.out.println(g);
    }

}
