package com.msrm.datastructure;

public class UFQuickUnion {

    private int[] id;

    public UFQuickUnion(int n) {
	id = new int[n];
	for (int i = 0; i < n; i++)
	    id[i] = i;
    }

    public boolean connected(int p, int q) {
	return find(p) == find(q);
    }

    public void union(int p, int q) {
	int proot = find(p);
	int qroot = find(q);

	if (proot == qroot)
	    return;
	id[qroot] = proot;
    }

    private int find(int p) {
	while (p != id[p]) {
	    p = id[p];
	}
	return p;
    }

    public static void main(String[] args) {
	UFQuickUnion uf = new UFQuickUnion(10);
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
