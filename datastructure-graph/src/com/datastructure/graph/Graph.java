package com.datastructure.graph;

import com.datastructure.Bucket;
import com.datastructure.graph.util.DSUtil;

public class Graph {

    private int V;
    private Bucket<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
	this.V = n;
	adj = new Bucket[n];
	for (int i = 0; i < n; i++) {
	    adj[i] = new Bucket<>();
	}
    }

    public int V() {
	return V;
    }

    public int E(int v) {
	return adj[v].size();
    }

    public void addEdge(Edge e) {
	int v = e.either();
	int w = e.other(v);
	adj[v].add(e);
	adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
	return adj[v];
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("# of Vertices : " + V + "\n");

	int E = 0;
	for (int i = 0; i < V(); i++) {
	    E = E + adj[i].size();
	}
	sb.append("# of Edges : " + E / 2 + "\n");

	for (int i = 0; i < V(); i++) {
	    sb.append(i + " -> " + adj(i) + "\n");
	}
	return sb.toString();
    }

    public static void main(String[] args) {
	Graph g = DSUtil.createEdgeWeightedGraph("/home/sriram/git/computer-science/datastructure-graph/data/EWG.txt");
	System.out.println("Graph: ");
	System.out.println(g);
    }

}
