package com.msrm.datastructure.graph;

import com.msrm.datastructure.Bag;
import com.msrm.datastructure.graph.util.DSUtil;

import edu.princeton.cs.algs4.StdOut;

public class Graph {

	private int V;
	private int E;
	private Bag<Edge>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int n) {
		this.V = n;
		adj = new Bag[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new Bag<>();
		}
	}

	// returns no. of vertices in Graph
	public int V() {
		return V;
	}

	// returns no. of neighbors for given vertex
	public int E() {
		return E;
	}

	// connect to vertices
	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	// returns neighbor edges
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	// returns all edges in Graph
	public Iterable<Edge> edges() {
		Bag<Edge> edges = new Bag<>();
		for (int v = 0; v < V; v++) {
			int selfEdge = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					edges.add(e);
				} else if (e.other(v) == v) {
					if (selfEdge % 2 == 0)
						edges.add(e);
					selfEdge++;
				}
			}
		}
		return edges;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("# of Vertices : " + V + "\n");

		sb.append("# of Edges : " + E + "\n");

		for (int i = 0; i < V(); i++) {
			sb.append(i + " -> " + adj(i) + "\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Graph g = DSUtil.createEdgeWeightedGraph("/home/sriram/git/computer-science/datastructure-graph/data/EWG.txt");
		StdOut.println("Graph: ");
		StdOut.println(g);
		StdOut.println(g.edges());
	}

}
