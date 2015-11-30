package com.datastructure.graph.directed;

import com.datastructure.Bucket;
import com.datastructure.graph.AdjacencyListGraph;
import com.datastructure.graph.Graph;

import edu.princeton.cs.algs4.In;

public class DSUtil {

    public static int N;

    public static Bucket<Integer> data = new Bucket<>();

    public static Graph createGraph(String file) {
	In in = new In(file);
	int V = in.readInt();
	int E = in.readInt();
	Graph g = new AdjacencyListGraph(V + 1);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}
	if (!in.isEmpty()) {
	    N = in.readInt();
	    for (int i = 0; i < N; i++) {
		data.add(in.readInt());
	    }
	}
	return g;
    }

    public static Digraph createDigraph(String file) {
	In in = new In(file);
	int V = in.readInt();
	int E = in.readInt();
	Digraph g = new Digraph(V + 1);
	for (int i = 0; i < E; i++) {
	    int v = in.readInt();
	    int w = in.readInt();
	    g.addEdge(v, w);
	}
	if (!in.isEmpty()) {
	    N = in.readInt();
	    for (int i = 0; i < N; i++) {
		data.add(in.readInt());
	    }
	}
	return g;
    }

}
