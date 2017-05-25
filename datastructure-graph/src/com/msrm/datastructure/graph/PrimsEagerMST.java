package com.msrm.datastructure.graph;

import com.msrm.datastructure.IndexMinPQ;
import com.msrm.datastructure.Queue;
import com.msrm.datastructure.graph.util.DSUtil;

import edu.princeton.cs.algs4.StdOut;

public class PrimsEagerMST {

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimsEagerMST(Graph g) {
	edgeTo = new Edge[g.V()];
	distTo = new double[g.V()];
	marked = new boolean[g.V()];
	pq = new IndexMinPQ<>(g.E());

	for (int v = 0; v < g.V(); v++)
	    distTo[v] = Double.POSITIVE_INFINITY;

	for (int v = 0; v < g.V(); v++) {
	    if (!marked[v])
		prim(g, v);
	}
    }

    private void prim(Graph g, int s) {
	distTo[s] = 0.0;
	pq.insert(s, distTo[s]);
	while (!pq.isEmpty()) {
	    int w = pq.delMin();
	    scan(g, w);
	}
    }

    private void scan(Graph g, int v) {
	marked[v] = true;
	for (Edge e : g.adj(v)) {
	    int w = e.other(v);
	    if (marked[w])
		continue;
	    if (e.weight() < distTo[w]) {
		distTo[w] = e.weight();
		edgeTo[w] = e;
		if (pq.contains(w)) {
		    pq.decreaseKey(w, distTo[w]);
		} else {
		    pq.insert(w, distTo[w]);
		}
	    }
	}
    }

    public double weight() {
	double wt = 0;
	for (Edge e : edgeTo) {
	    if (e != null)
		wt += e.weight();
	}
	return wt;
    }

    public Iterable<Edge> edges() {
	Queue<Edge> edges = new Queue<>();
	for (Edge e : edgeTo) {
	    if (e != null)
		edges.enqueue(e);
	}
	return edges;
    }

    public static void main(String[] args) {
	Graph g = DSUtil.createEdgeWeightedGraph("/home/sriram/git/computer-science/datastructure-graph/data/EWG.txt");
	StdOut.println("Graph: ");
	StdOut.println(g);
	StdOut.println("Edges : " + g.edges());

	PrimsEagerMST mst = new PrimsEagerMST(g);
	StdOut.println("MST Edges : " + mst.edges());
	StdOut.println("Cost : " + mst.weight());
    }

}
