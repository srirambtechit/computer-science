package com.msrm.datastructure.graph.directed;

import com.msrm.datastructure.Queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BellmanFordSPBrouteForce {

	private double[] distTo;
	private DirectedEdge[] edgeTo;

	public BellmanFordSPBrouteForce(EdgeWeightedDigraph g, int s) {
		distTo = new double[g.V()];
		edgeTo = new DirectedEdge[g.V()];

		for (int i = 0; i < g.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}

		distTo[s] = 0.0;
		for (int i = 0; i < g.V(); i++) {
			for (int v = 0; v < g.V(); v++) {
				for (DirectedEdge e : g.adj(v))
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
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	private boolean hasPath(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
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
			// StdOut.printf("%d - %d %.2f%n", v, w, wt);
			DirectedEdge e = new DirectedEdge(v, w, wt);
			g.addEdge(e);
		}
		// StdOut.println(g);

		BellmanFordSPBrouteForce sp = new BellmanFordSPBrouteForce(g, 0);
		StdOut.println(sp.pathTo(4));
		StdOut.println(sp.distTo(4));

		StdOut.println(sp.pathTo(3));
		StdOut.println(sp.distTo(3));

		StdOut.println(sp.pathTo(1));
		StdOut.println(sp.distTo(1));
	}

}
