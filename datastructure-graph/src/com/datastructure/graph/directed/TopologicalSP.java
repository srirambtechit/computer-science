package com.datastructure.graph.directed;

import com.datastructure.Queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TopologicalSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public TopologicalSP(EdgeWeightedDigraph g, int s) {
	distTo = new double[g.V()];
	edgeTo = new DirectedEdge[g.V()];

	for (int i = 0; i < distTo.length; i++) {
	    distTo[i] = Double.POSITIVE_INFINITY;
	}

	distTo[s] = 0.0;
	Topological t = new Topological(g);
	System.out.println("Topo : " + t.order());
	for (Integer v : t.order()) {
	    for (DirectedEdge e : g.adj(v)) {
		relax(e);
	    }
	}
    }

    public void relax(DirectedEdge e) {
	int v = e.from();
	int w = e.to();
	if (distTo[w] > distTo[v] + e.weight()) {
	    edgeTo[w] = e;
	    distTo[w] = distTo[v] + e.weight();
	}
    }

    private Queue<DirectedEdge> edges() {
	Queue<DirectedEdge> queue = new Queue<>();
	for (DirectedEdge e : edgeTo) {
	    if (e != null) {
		queue.enqueue(e);
	    }
	}
	return queue;
    }

    public static void main(String[] args) {
	In in = new In("/home/sriram/git/computer-science/datastructure-graph/data/topo_sp.txt");
	int V = in.readInt();
	int E = in.readInt();
	EdgeWeightedDigraph g = new EdgeWeightedDigraph(V);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    double wt = in.readDouble();
	    StdOut.printf("%d - %d  %.2f%n", v, w, wt);
	    DirectedEdge e = new DirectedEdge(v, w, wt);
	    g.addEdge(e);
	}
	System.out.println(g);

	TopologicalSP sp = new TopologicalSP(g, 0);
	System.out.println(sp.edges());
    }

}
