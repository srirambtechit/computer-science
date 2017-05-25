package com.msrm.datastructure.graph.directed;

import com.msrm.datastructure.Queue;
import com.msrm.datastructure.Stack;
import com.msrm.datastructure.graph.util.DSUtil;

import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearch {

    private boolean[] visited;
    private Queue<Integer> preorder;
    private Queue<Integer> postorder;

    public DepthFirstSearch(Digraph g) {
	visited = new boolean[g.V()];
	preorder = new Queue<>();
	postorder = new Queue<>();
	for (int i = 0; i < g.V(); i++) {
	    if (!visited[i]) {
		dfs(g, i);
	    }
	}
    }

    private void dfs(Digraph g, int v) {
	visited[v] = true;
	preorder.enqueue(v);
	for (Integer w : g.adj(v)) {
	    if (!visited[w]) {
		dfs(g, w);
	    }
	}
	postorder.enqueue(v);
    }

    public Iterable<Integer> reversePost() {
	Stack<Integer> stack = new Stack<>();
	for (Integer v : post()) {
	    stack.push(v);
	}
	return stack;
    }

    public Iterable<Integer> pre() {
	return preorder;
    }

    public Iterable<Integer> post() {
	return postorder;
    }

    public static void main(String[] args) {
	Digraph g = DSUtil.createDigraph("/home/sriram/git/computer-science/datastructure-graph/data/dfs.txt");
	System.out.println("Graph: ");
	System.out.println(g);
	DepthFirstSearch dfs = new DepthFirstSearch(g);
	StdOut.println("Preorder  : " + dfs.pre());
	StdOut.println("Postorder : " + dfs.post());
	StdOut.println("RPO : " + dfs.reversePost());
    }

}
