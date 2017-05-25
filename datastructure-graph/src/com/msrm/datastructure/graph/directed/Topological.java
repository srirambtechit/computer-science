package com.msrm.datastructure.graph.directed;

import com.msrm.datastructure.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Topological {

    private Stack<Integer> stack;
    private boolean[] marked;

    public Topological(Digraph g) {
    }

    public Topological(EdgeWeightedDigraph g) {
	stack = new Stack<>();
	marked = new boolean[g.V()];
	for (int v = 0; v < g.V() - 1; v++) {
	    if (!marked[v])
		dfs(g, v);
	}
    }

    private void dfs(EdgeWeightedDigraph g, int v) {
	marked[v] = true;
	for (DirectedEdge e : g.adj(v)) {
	    int w = e.to();
	    if (!marked[w]) {
		dfs(g, w);
	    }
	}
	stack.push(v);
    }

    public Iterable<Integer> order() {
	return stack;
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
	    // StdOut.printf("%d - %d  %.2f%n", v, w, wt);
	    DirectedEdge e = new DirectedEdge(v, w, wt);
	    g.addEdge(e);
	}
	// StdOut.println(g);
	Topological t = new Topological(g);
	Iterable<Integer> order = t.order();
	StdOut.println(order);
    }

}
