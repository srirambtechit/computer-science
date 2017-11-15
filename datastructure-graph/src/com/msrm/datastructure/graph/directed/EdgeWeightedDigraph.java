package com.msrm.datastructure.graph.directed;

import java.util.Iterator;

import com.msrm.datastructure.Bag;
import com.msrm.datastructure.Queue;

import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedDigraph {

	private Bag<DirectedEdge>[] adj;
	private int V;
	private int E;

	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		adj = new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public int E(int v) {
		return adj[v].size();
	}

	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		Queue<DirectedEdge> allEdges = new Queue<>();
		for (Bag<DirectedEdge> bag : adj) {
			Iterator<DirectedEdge> itr = bag.iterator();
			while (itr.hasNext()) {
				allEdges.enqueue(itr.next());
			}
		}
		return allEdges;
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
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(6);
		g.addEdge(new DirectedEdge(0, 3, 0.2));
		g.addEdge(new DirectedEdge(0, 1, 0.6));
		g.addEdge(new DirectedEdge(0, 5, 0.1));
		g.addEdge(new DirectedEdge(1, 2, 0.2));
		g.addEdge(new DirectedEdge(2, 3, 0.7));
		g.addEdge(new DirectedEdge(3, 4, 0.2));
		g.addEdge(new DirectedEdge(4, 2, 0.5));
		g.addEdge(new DirectedEdge(4, 5, 0.3));
		g.addEdge(new DirectedEdge(5, 1, 0.3));

		for (int i = 0; i < g.V(); i++) {
			StdOut.println(i + " -> " + g.adj[i]);
		}
	}

}
