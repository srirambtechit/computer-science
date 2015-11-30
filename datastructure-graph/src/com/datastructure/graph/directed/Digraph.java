package com.datastructure.graph.directed;

import com.datastructure.Bucket;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph {

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

    public int V() {
	return V;
    }

    public int E(int v) {
	return adj[v].size();
    }

    public void addEdge(int v, int w) {
	adj[v].add(w);
    }

    public Digraph reverse() {
	Digraph R = new Digraph(V);
	for (int v = 0; v < V; v++) {
	    for (int w : adj(v)) {
		R.addEdge(w, v);
	    }
	}
	return R;
    }

    public Iterable<Integer> adj(int v) {
	return adj[v];
    }

    public boolean hasEdge(int v) {
	return !adj[v].isEmpty();
    }

    public static void main(String[] args) {
	Digraph g = new Digraph(4);
	g.addEdge(1, 2);
	g.addEdge(2, 3);
	g.addEdge(1, 3);

	for (int i = 0; i < g.V(); i++) {
	    StdOut.println(i + " -> " + g.adj[i]);
	}

	StdOut.println();

	Digraph r = g.reverse();
	for (int i = 0; i < r.V(); i++) {
	    StdOut.println(i + " -> " + r.adj[i]);
	}

	StdOut.println();

	test(args);
    }

    private static void test(String[] args) {
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
