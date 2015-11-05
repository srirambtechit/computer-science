package com.datastructure.graph;

public class AdjacencyMatrixGraph {
    // Number of vertices
    private int V;

    // Matrix to define connections
    private boolean[][] adj;

    public AdjacencyMatrixGraph(int v) {
	// adding 1 to vertex to make starting index from 1
	this.V = v + 1;
	adj = new boolean[V][V];
    }

    /**
     * Establishes connection between two vertices.
     * i.e. creates edges between nodes
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
	Bucket<Integer> bucket = new Bucket<>();
	for (int i = 1; i < V; i++) {
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
	for (int i = 1; i < V; i++) {
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
	AdjacencyMatrixGraph amg = new AdjacencyMatrixGraph(6);
	System.out.println("No of edage : " + amg.E(3));
	amg.addEdge(1, 3);
	amg.addEdge(1, 2);
	amg.addEdge(2, 4);
	amg.addEdge(2, 5);
	amg.addEdge(2, 3);
	amg.addEdge(4, 5);
	amg.addEdge(4, 3);
	amg.addEdge(3, 6);

	System.out.println("No of edage : " + amg.E(3));
	Iterable<Integer> i = amg.adj(2);
	for (Integer element : i) {
	    System.out.println(element);
	}
	System.out.println(amg);
    }

}
