package com.williansoares.aedsiii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

	public static List<Edge> solve(Graph g) {
		List<Edge> mstEdges = new ArrayList<>();
		List<Edge> edgesWeightSorted = g.listEdges();
		edgesWeightSorted.sort(Comparator.comparingInt(Edge::getWeight));

		DisjointSet nodes = new DisjointSet(g.numberOfVertices());
		
		for (int i = 0; i < edgesWeightSorted.size() && mstEdges.size() < g.numberOfVertices(); i++) {
			Edge e = edgesWeightSorted.get(i);

			if (!nodes.sameRoots(e.getOrigin(), e.getDestination())) {
				mstEdges.add(e);
				nodes.union(e.getOrigin(), e.getDestination());
			}
		}
		return mstEdges;
	}

}