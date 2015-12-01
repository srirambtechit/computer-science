package com.datastructure.graph;

public class Edge {

    private double weight;
    private int v;
    private int w;

    public Edge(int v, int w) {
	super();
	this.v = v;
	this.w = w;
    }

    public Edge(double weight, int v, int w) {
	super();
	this.weight = weight;
	this.v = v;
	this.w = w;
    }

    public double weight() {
	return weight;
    }

    public int either() {
	return v;
    }

    public int other(int v) {
	if (this.v == v)
	    return w;
	return this.v;
    }

}
