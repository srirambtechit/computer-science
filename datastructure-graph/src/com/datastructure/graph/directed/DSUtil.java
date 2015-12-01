package com.datastructure.graph.directed;

import com.datastructure.Bucket;
import com.datastructure.graph.AdjacencyListGraph;
import com.datastructure.graph.Edge;
import com.datastructure.graph.Graph;

import edu.princeton.cs.algs4.In;

public class DSUtil {

    public static Bucket<Edge> data = new Bucket<>();

    public static Graph createGraph(String file) {
	In in = new In(file);
	int V = in.readInt();
	int E = in.readInt();
	Graph g = new AdjacencyListGraph(V);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}
	if (!in.isEmpty()) {
	    int N = in.readInt();
	    for (int i = 0; i < N; i++) {
		int v = in.readInt();
		int w = in.readInt();
		Edge e = new Edge(v, w);
		data.add(e);
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
		data.add(e);
	    }
	}
	return g;
    }

}
