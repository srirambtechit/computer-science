package com.datastructure.graph.directed;

public class DirectedEdge implements Comparable<DirectedEdge> {

    private double wt;
    private int v;
    private int w;

    public DirectedEdge(int v, int w, double wt) {
	this.wt = wt;
	this.v = v;
	this.w = w;
    }

    public int from() {
	return v;
    }

    public int to() {
	return w;
    }

    @Override
    public int compareTo(DirectedEdge o) {
	return (wt == o.wt) ? 0 : (wt > o.wt) ? 1 : -1;

    }

    @Override
    public String toString() {
	return "(" + wt + ", " + v + ", " + w + ")";
    }

}
