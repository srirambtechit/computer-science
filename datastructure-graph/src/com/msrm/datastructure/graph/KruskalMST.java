package com.msrm.datastructure.graph;

import com.msrm.datastructure.MinPQ;
import com.msrm.datastructure.Queue;
import com.msrm.datastructure.UFQuickUnion;
import com.msrm.datastructure.graph.util.DSUtil;

import edu.princeton.cs.algs4.StdOut;

/**
 * <pre>
 * Spanning Tree: Spanning tree of a graph is a 
 * connected subgraph in which there are no cycle
 * 
 * Minimum Spanning Tree(MST):
 * 	A graph can have more than one MST 
 * If so sum of all edges in MST should be minimum
 * </pre>
 * 
 * @author sriram
 *
 */
public class KruskalMST {

    private Queue<Edge> edges;
    private double wt;

    public KruskalMST(Graph g) {
	edges = new Queue<>();

	// put all edges to PQ to sort
	MinPQ<Edge> pq = new MinPQ<>(g.E());
	for (Edge e : g.edges()) {
	    pq.insert(e);
	}

	// dynamic connectivity for already processed vertex
	UFQuickUnion uf = new UFQuickUnion(g.V());
	while (!pq.isEmpty() && edges.size() < g.V() - 1) {
	    Edge e = pq.delMin();
	    int v = e.either();
	    int w = e.other(v);
	    if (!uf.connected(v, w)) {
		uf.union(v, w);
		edges.enqueue(e);
		wt += e.weight();
	    }
	}
    }

    public Iterable<Edge> edges() {
	return edges;
    }

    public double weight() {
	return wt;
    }

    public static void main(String[] args) {
	Graph g = DSUtil.createEdgeWeightedGraph("/home/sriram/git/computer-science/datastructure-graph/data/EWG.txt");
	StdOut.println("Graph: ");
	StdOut.println(g);
	StdOut.println("Edges : " + g.edges());

	KruskalMST mst = new KruskalMST(g);
	StdOut.println("MST Edges : " + mst.edges());
	StdOut.println("Cost : " + mst.weight());
    }

}
