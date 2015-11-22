package com.datastructure;

/**
 * Quick-Find algorithm
 * 
 * @author sriram
 *
 */
public class UF {

    private int[] id;

    private int N;

    public UF(int n) {
	this.N = n;
	id = new int[N];
	for (int i = 0; i < N; i++) {
	    this.id[i] = i;
	}
    }

    private int find(int p) {
	return id[p];
    }

    public void union(int p, int q) {
	int j = id[q];

	if (connected(p, q))
	    return;

	for (int i = 0; i < N; i++) {
	    if (id[i] == j) {
		id[i] = id[p];
	    }
	}
    }

    public boolean connected(int p, int q) {
	return find(p) == find(q);
    }

    public static void main(String[] args) {
	UF uf = new UF(10);
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
