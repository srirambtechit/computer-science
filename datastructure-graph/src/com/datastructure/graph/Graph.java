package com.datastructure.graph;

public interface Graph {

    public int V();

    public int E(int v);

    public void addEdge(int v, int w);

    public Iterable<Integer> adj(int v);

}
