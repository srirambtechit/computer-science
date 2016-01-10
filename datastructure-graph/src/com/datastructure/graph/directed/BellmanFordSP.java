package com.datastructure.graph.directed;

import com.datastructure.Queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BellmanFordSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQueue;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph g, int s) {
	distTo = new double[g.V()];
	edgeTo = new DirectedEdge[g.V()];

	for (int i = 0; i < g.V(); i++) {
	    distTo[i] = Double.POSITIVE_INFINITY;
	}

	distTo[s] = 0.0;
	onQueue = new boolean[g.V()];
	queue = new Queue<>();
	queue.enqueue(s);
	while (!queue.isEmpty() && !hasNegativeCycle()) {
	    Integer v = queue.dequeue();
	    onQueue[v] = false;
	    relax(g, v);
	}
    }

    private void relax(EdgeWeightedDigraph g, int v) {
	for (DirectedEdge e : g.adj(v)) {
	    int w = e.to();
	    if (distTo[w] > distTo[v] + e.weight()) {
		distTo[w] = distTo[v] + e.weight();
		edgeTo[w] = e;
		if (!onQueue[w]) {
		    onQueue[w] = true;
		    queue.enqueue(w);
		}
	    }

	    if (cost++ % g.V() == 0) {
		findNegativeCycle();
		if (hasNegativeCycle())
		    return;
	    }
	}
    }

    public boolean hasNegativeCycle() {
	return cycle != null;
    }

    private void findNegativeCycle() {
	int V = edgeTo.length;
	EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
	for (int i = 0; i < V; i++) {
	    if (edgeTo[i] != null)
		spt.addEdge(edgeTo[i]);
	}

	EdgeWeightedDirectedCycleDetector finder = new EdgeWeightedDirectedCycleDetector(spt);
	cycle = finder.cycle();
    }

    public double distTo(int v) {
	return distTo[v];
    }

    private boolean hasPath(int v) {
	return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> negativeCycle() {
	return cycle;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
	if (!hasPath(v))
	    return null;
	Queue<DirectedEdge> queue = new Queue<>();
	for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
	    queue.enqueue(e);
	}
	return queue;
    }

    public static void main(String[] args) {
	In in = new In("/home/sriram/git/computer-science/datastructure-graph/data/sp.txt");
	int V = in.readInt();
	int E = in.readInt();
	EdgeWeightedDigraph g = new EdgeWeightedDigraph(V);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    double wt = in.readDouble();
	    // StdOut.printf("%d - %d  %.2f%n", v, w, wt);
	    DirectedEdge e = new DirectedEdge(v, w, wt);
	    g.addEdge(e);
	}
	// StdOut.println(g);

	BellmanFordSP sp = new BellmanFordSP(g, 0);
	StdOut.println(sp.pathTo(4));
	StdOut.println(sp.distTo(4));

	StdOut.println(sp.pathTo(3));
	StdOut.println(sp.distTo(3));

	StdOut.println(sp.pathTo(1));
	StdOut.println(sp.distTo(1));
    }

}
