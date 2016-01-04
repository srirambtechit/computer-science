package com.datastructure.graph.directed;

import com.datastructure.IndexMinPQ;
import com.datastructure.Stack;

import edu.princeton.cs.algs4.StdOut;

public class DijkstraSP {

    private IndexMinPQ<Double> pq;
    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public DijkstraSP(EdgeWeightedDigraph g, int s) {
	pq = new IndexMinPQ<>(g.V());
	edgeTo = new DirectedEdge[g.V()];
	distTo = new double[g.V()];

	for (int i = 0; i < distTo.length; i++) {
	    distTo[i] = Double.POSITIVE_INFINITY;
	}

	distTo[s] = 0.0;
	pq.insert(s, distTo[s]);

	while (!pq.isEmpty()) {
	    int v = pq.delMin();
	    for (DirectedEdge e : g.adj(v)) {
		relax(e);
	    }
	}
    }

    private void relax(DirectedEdge e) {
	int v = e.from();
	int w = e.to();
	if (distTo[w] > distTo[v] + e.weight()) {
	    distTo[w] = distTo[v] + e.weight();
	    edgeTo[w] = e;
	    if (pq.contains(w)) {
		pq.decreaseKey(w, distTo[w]);
	    } else {
		pq.insert(w, distTo[w]);
	    }
	}
    }

    public double distTo(int v) {
	return distTo[v];
    }

    public boolean hasPathTo(int v) {
	return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
	if (!hasPathTo(v))
	    return null;

	Stack<DirectedEdge> path = new Stack<>();
	DirectedEdge e = edgeTo[v];
	while (e != null) {
	    path.push(e);
	    e = edgeTo[e.from()];
	}
	return path;
    }

    public static void main(String[] args) {
	EdgeWeightedDigraph g = new EdgeWeightedDigraph(6);
	g.addEdge(new DirectedEdge(0, 3, 0.2));
	g.addEdge(new DirectedEdge(0, 1, 0.6));
	g.addEdge(new DirectedEdge(0, 5, 0.1));
	g.addEdge(new DirectedEdge(1, 2, 0.2));
	g.addEdge(new DirectedEdge(2, 3, 0.7));
	g.addEdge(new DirectedEdge(3, 4, 0.2));
	g.addEdge(new DirectedEdge(4, 2, 0.5));
	g.addEdge(new DirectedEdge(4, 5, 0.3));
	g.addEdge(new DirectedEdge(5, 1, 0.3));

	System.out.println(g);

	DijkstraSP sp = new DijkstraSP(g, 0);
	System.out.println(sp.pathTo(4));
	System.out.println(sp.distTo(4));

	System.out.println(sp.pathTo(3));
	System.out.println(sp.distTo(3));

	System.out.println(sp.pathTo(1));
	System.out.println(sp.distTo(1));

    }

}
