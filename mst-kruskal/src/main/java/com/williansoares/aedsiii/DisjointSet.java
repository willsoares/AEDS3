package com.williansoares.aedsiii;

public class DisjointSet {
	int[] roots;

	public DisjointSet(int numberOfVertices) {
		int numberOfNodes = numberOfVertices + 1;
		this.roots = new int[numberOfNodes];
		for (int i = 0; i < roots.length; i++) {
			this.roots[i] = -1;
		}
	}
	public boolean sameRoots(Vertex v1, Vertex v2) {
		return rootOf(v1) == rootOf(v2);
	}
	
	public void union(Vertex v1, Vertex v2) {
		union(rootOf(v1), rootOf(v2));
	}
	private void union(int vertexRoot1, int vertexRoot2) {
		if (roots[vertexRoot2] < roots[vertexRoot1]) {
			roots[vertexRoot1] = vertexRoot2;
		} else {
			if (roots[vertexRoot1] == roots[vertexRoot2]) {
				roots[vertexRoot1]--;
			}
			roots[vertexRoot2] = vertexRoot1;
		}
	}

	private int rootOf(Vertex v) {
		return rootOf(v.getId());
	}
	private int rootOf(int x) {
		if (roots[x] < 0) {
			return x;
		}
		int next = x;
		while (roots[next] > 0) {
			next = roots[next];
		}
		return next;
	}
}