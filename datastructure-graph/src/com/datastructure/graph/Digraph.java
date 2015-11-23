package com.datastructure.graph;

import com.datastructure.Bucket;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph implements Graph {

    private int V;
    private Bucket<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int n) {
	this.V = n;
	adj = new Bucket[V];
	for (int i = 0; i < V; i++) {
	    adj[i] = new Bucket<>();
	}
    }

    @Override
    public int V() {
	return V;
    }

    @Override
    public int E(int v) {
	return adj[v].size();
    }

    @Override
    public void addEdge(int v, int w) {
	adj[v].add(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

    public boolean hasEdge(int v) {
	return !adj[v].isEmpty();
    }

    public static void main(String[] args) {
	In in = new In(args[0]);
	// reads # of vertices
	int V = in.readInt();

	// create Directed Graph for the given no of vertices
	Digraph g = new Digraph(V);

	// Fill the graph with edges
	while (!in.isEmpty()) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}

	// display DirectedGraph
	for (int i = 0; i < g.V(); i++) {
	    if (g.hasEdge(i)) {
		StdOut.printf("%d - %s%n", i, g.adj(i));
	    }
	}
    }

}
