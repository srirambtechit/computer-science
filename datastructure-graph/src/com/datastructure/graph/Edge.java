package com.datastructure.graph;

public class Edge {

    private double weight;
    private int v;
    private int w;

    public Edge(double weight, int v, int w) {
	super();
	this.weight = weight;
	this.v = v;
	this.w = w;
    }

    public double getWeight() {
	return weight;
    }
    
    public int edge() {
	return v;
    }
    
    public int other(int v) {
	if(this.v == v)return w;
	return this.v;
    }

}
