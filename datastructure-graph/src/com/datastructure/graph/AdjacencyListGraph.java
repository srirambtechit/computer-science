package com.datastructure.graph;

import java.util.Arrays;

public class AdjacencyListGraph {

    private int V;
    private Bucket<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int v) {
	this.V = v + 1;
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
	AdjacencyListGraph alg = new AdjacencyListGraph(6);
	System.out.println("No of edage : " + alg.E(3));
	alg.addEdge(1, 3);
	alg.addEdge(1, 2);
	alg.addEdge(2, 4);
	alg.addEdge(2, 5);
	alg.addEdge(2, 3);
	alg.addEdge(4, 5);
	alg.addEdge(4, 3);
	alg.addEdge(3, 6);

	System.out.println("No of edage : " + alg.E(3));
	Iterable<Integer> i = alg.adj(2);
	for (Integer element : i) {
	    System.out.println(element);
	}
	System.out.println(alg);
    }

}
