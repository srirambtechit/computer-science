package com.msrm.datastructure;

/**
 * Weighted Path Compression Quick Union Find algorithm
 * 
 * @author sriram
 *
 */
public class UFWeightedPathCompressionQuickUnion {

    private int[] id;
    private int[] sz;

    public UFWeightedPathCompressionQuickUnion(int N) {
	id = new int[N];
	sz = new int[N];
	for (int i = 0; i < N; i++) {
	    id[i] = i;
	    sz[i] = 1;
	}
    }

    public boolean connected(int p, int q) {
	return find(p) == find(q);
    }

    public void union(int p, int q) {
	int i = find(p);
	int j = find(q);

	if (i == j)
	    return;

	if (sz[i] > sz[j]) {
	    id[j] = i;
	    sz[i] += sz[j];
	} else {
	    id[i] = j;
	    sz[j] += sz[i];
	}
    }

    private int find(int p) {
	while (p != id[p]) {

	    // path compression
	    id[p] = id[id[p]];

	    p = id[p];
	}
	return p;
    }

    public static void main(String[] args) {
	UFWeightedPathCompressionQuickUnion uf = new UFWeightedPathCompressionQuickUnion(10);
	System.out.println(uf.connected(1, 8));
	uf.union(1, 8);
	System.out.println(uf.connected(1, 8));
	uf.union(0, 1);
	uf.union(4, 3);
	uf.union(5, 3);
	uf.union(6, 7);
	uf.union(7, 0);
	System.out.println(uf.connected(7, 8));
	System.out.println(uf.connected(8, 7));
    }

}
