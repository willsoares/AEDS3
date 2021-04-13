package com.williansoares.aedsiii;

import java.util.List;

/**
 * Hello world!
 */
public final class App {
	private App() {
	}

	/**
	 * Says hello to the world.
	 * 
	 * @param args The arguments of the program.
	 */
	public static void main(String[] args) {
		String path = "graph";
		AdjacencyMatrix graph = FileParser.readGraph(path);
		if (graph != null) {
			// System.out.println(graph.printGraph());

			List<Edge> edges = Kruskal.solve(graph);
			for (Edge e : edges) {
				System.out.println(e);
			}
		}
	}
}
