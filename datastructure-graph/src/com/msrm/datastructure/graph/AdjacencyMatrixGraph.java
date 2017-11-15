package com.msrm.datastructure.graph;

import com.msrm.datastructure.Bag;

public class AdjacencyMatrixGraph {
	// Number of vertices
	private int V;

	// Matrix to define connections
	private boolean[][] adj;

	public AdjacencyMatrixGraph(int v) {
		this.V = v;
		adj = new boolean[V][V];
	}

	/**
	 * Establishes connection between two vertices. i.e. creates edges between
	 * nodes
	 * 
	 * @param v
	 *            Vertex one
	 * @param w
	 *            Vertex two
	 */
	public void addEdge(int v, int w) {
		adj[v][w] = true;
		adj[w][v] = true;
	}

	public Iterable<Integer> adj(int v) {
		Bag<Integer> bucket = new Bag<>();
		for (int i = 0; i < V; i++) {
			if (adj[v][i])
				bucket.add(i);
		}
		return bucket;
	}

	/**
	 * @return Number of vertices in Graph
	 */
	public int V() {
		return this.V;
	}

	/**
	 * 
	 * @param v
	 *            Vertex index in Graph
	 * @return Number of edges for given vertex
	 */
	public int E(int v) {
		int c = 0;
		for (int i = 0; i < V; i++) {
			if (adj[v][i])
				c++;
		}
		return c;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (boolean[] bs : adj) {
			sb.append("[");
			for (boolean b : bs) {
				sb.append(String.format(" %-6s", String.valueOf(b)));
			}
			sb.append("]\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(6);
		System.out.println("No of edage : " + g.E(0));
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 5);
		g.addEdge(1, 4);
		g.addEdge(4, 5);
		g.addEdge(3, 5);
		System.out.println("No of edage : " + g.E(0));

		for (int i = 0; i < g.V(); i++) {
			System.out.printf("%d - ", i);
			for (Integer element : g.adj(i)) {
				System.out.printf("%d ", element);
			}
			System.out.println();
		}

		System.out.println(g);
	}

}
