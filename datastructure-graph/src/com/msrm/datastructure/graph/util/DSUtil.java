package com.msrm.datastructure.graph.util;

import com.msrm.datastructure.Bag;
import com.msrm.datastructure.graph.Edge;
import com.msrm.datastructure.graph.Graph;
import com.msrm.datastructure.graph.directed.Digraph;

import edu.princeton.cs.algs4.In;

public class DSUtil {

    public static Bag<Edge> query = new Bag<>();

    public static Graph createGraph(String file) {
	In in = new In(file);
	int V = in.readInt();
	int E = in.readInt();
	Graph g = new Graph(V);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    Edge e = new Edge(v, w);
	    g.addEdge(e);
	}
	if (!in.isEmpty()) {
	    int N = in.readInt();
	    for (int i = 0; i < N; i++) {
		int v = in.readInt();
		int w = in.readInt();
		Edge e = new Edge(v, w);
		query.add(e);
	    }
	}
	return g;
    }

    public static Graph createEdgeWeightedGraph(String file) {
	In in = new In(file);
	int V = in.readInt();
	int E = in.readInt();
	Graph g = new Graph(V);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    double wt = in.readDouble();
	    Edge e = new Edge(wt, v, w);
	    g.addEdge(e);
	}
	if (!in.isEmpty()) {
	    int N = in.readInt();
	    for (int i = 0; i < N; i++) {
		int v = in.readInt();
		int w = in.readInt();
		Edge e = new Edge(v, w);
		query.add(e);
	    }
	}
	return g;
    }

    public static Digraph createDigraph(String file) {
	In in = new In(file);
	int V = in.readInt();
	int E = in.readInt();
	Digraph g = new Digraph(V);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}
	if (!in.isEmpty()) {
	    int N = in.readInt();
	    for (int i = 0; i < N; i++) {
		Edge e = new Edge(in.readInt(), in.readInt());
		query.add(e);
	    }
	}
	return g;
    }

}
