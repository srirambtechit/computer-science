package com.msrm.datastructure.graph.directed;

import java.util.Arrays;

import com.msrm.datastructure.Stack;

import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedDirectedCycleDetector {

	private DirectedEdge[] edgeTo;
	private boolean[] marked;
	private boolean[] onStack;
	private Stack<DirectedEdge> cycle;

	public EdgeWeightedDirectedCycleDetector(EdgeWeightedDigraph g) {
		edgeTo = new DirectedEdge[g.V()];
		marked = new boolean[g.V()];
		onStack = new boolean[g.V()];

		for (int v = 0; v < g.V(); v++) {
			if (!marked[v])
				dfs(g, v);
		}
	}

	private void dfs(EdgeWeightedDigraph g, int v) {
		marked[v] = true;
		onStack[v] = true;
		for (DirectedEdge e : g.adj(v)) {
			int w = e.to();

			StdOut.println("e::" + e + "cycle::" + cycle + "	onStack::" + Arrays.toString(onStack));

			if (cycle != null)
				return;
			if (!marked[w]) {
				edgeTo[w] = e;
				dfs(g, w);
			} else if (onStack[w]) {
				cycle = new Stack<>();
				while (e.from() != w) {
					cycle.push(e);
					e = edgeTo[e.from()];
				}
				cycle.push(e);
				return;
			}
		}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<DirectedEdge> cycle() {
		return cycle;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(4);
		DirectedEdge e = new DirectedEdge(0, 1, 0);
		g.addEdge(e);
		e = new DirectedEdge(0, 2, 0);
		g.addEdge(e);
		e = new DirectedEdge(1, 2, 0);
		g.addEdge(e);
		e = new DirectedEdge(3, 1, 0);
		g.addEdge(e);
		e = new DirectedEdge(2, 3, 0);
		g.addEdge(e);
		System.out.println(g);
		EdgeWeightedDirectedCycleDetector d = new EdgeWeightedDirectedCycleDetector(g);
		if (d.hasCycle()) {
			System.out.print("\n\nCycle found :: ");
			System.out.println(d.cycle());
		} else {
			System.out.println("\n\nCycle not found");
		}
	}

}
