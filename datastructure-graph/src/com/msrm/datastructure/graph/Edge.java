package com.msrm.datastructure.graph;

public class Edge implements Comparable<Edge> {

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

	@Override
	public String toString() {
		return String.format("(%2d-%-2d %.2f)", v, w, weight);
	}

	@Override
	public int compareTo(Edge e) {
		if (weight == e.weight)
			return 0;
		else if (weight > e.weight)
			return 1;
		return -1;
	}

}
