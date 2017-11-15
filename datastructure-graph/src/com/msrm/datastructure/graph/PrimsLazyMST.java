package com.msrm.datastructure.graph;

import com.msrm.datastructure.MinPQ;
import com.msrm.datastructure.Queue;
import com.msrm.datastructure.graph.util.DSUtil;

import edu.princeton.cs.algs4.StdOut;

public class PrimsLazyMST {

	private double wt;
	private Queue<Edge> edges;
	private boolean[] marked;
	private MinPQ<Edge> pq;

	public PrimsLazyMST(Graph g) {
		edges = new Queue<>();
		marked = new boolean[g.V()];
		pq = new MinPQ<>(g.E());

		// visit any vertex in the Graph
		visit(g, 0);

		while (!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (marked[v] && marked[w])
				continue;
			edges.enqueue(e);
			wt += e.weight();
			if (!marked[v])
				visit(g, v);
			if (!marked[w])
				visit(g, w);
		}
	}

	private void visit(Graph g, int v) {
		marked[v] = true;
		for (Edge e : g.adj(v)) {
			if (!marked[e.other(v)])
				pq.insert(e);
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

		PrimsLazyMST mst = new PrimsLazyMST(g);
		StdOut.println("MST Edges : " + mst.edges());
		StdOut.println("Cost : " + mst.weight());
	}

}
