package com.williansoares.aedsiii;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements Graph {
	private Integer[][] graph;
	private static final Integer EMPTY_EDGE_VALUE = null;

	public AdjacencyMatrix(int numberOfVertices) {
		graph = new Integer[numberOfVertices][numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++) {
			graph[i] = new Integer[numberOfVertices];
			for (int j = 0; j < numberOfVertices; j++) {
				graph[i][j] = null;
			}
		}
	}

	public void updateOrAddEdge(Edge edge) {
		int u = edge.getOrigin().getId();
		int v = edge.getDestination().getId();
		graph[u][v] = edge.getWeight();
	}

	// public boolean addEdge(Edge edge) {
	// 	if (getEdge(edge.getOrigin(), edge.getDestination()))
	// 		return false;
	// 	else {
	// 		updateOrAddEdge(edge);
	// 		return true;
	// 	}
	// }

	// public boolean updateEdge(Edge edge) {
	// 	if (!hasEdge(edge))
	// 		return false;
	// 	else {
	// 		updateOrAddEdge(edge);
	// 		return true;
	// 	}
	// }

	public List<Edge> listEdges() {
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (getEdge(i, j) != null)
					edges.add(getEdge(i, j));
			}
		}
		return edges;
	}

	public List<Edge> listEdges(Vertex vertex) {
		List<Edge> edges = new ArrayList<>();
		// for (int i = 0; i < graph.length; i++) {
		// 	if (hasEdge(vertex.getId(), i))
		// 		edges.add(getEdge(vertex.getId(), i));
		// 	if (hasEdge(i, vertex.getId()))
		// 		edges.add(getEdge(i, vertex.getId()));
		// }
		return edges;
	}

	public List<Vertex> listVertices() {
		List<Vertex> vertices = new ArrayList<>();
		for (int i = 0; i < graph.length; i++)
			vertices.add(new Vertex(i));

		return vertices;
	}

	public List<Vertex> listAdjacents(Vertex vertex) {
		ArrayList<Vertex> vertices = new ArrayList<>();
		// for (int i = 0; i < graph.length; i++) {
		// 	if (hasEdge(vertex.getId(), i))
		// 		vertices.add(new Vertex(i));
		// 	if (hasEdge(i, vertex.getId()))
		// 		if (!vertices.contains(new Vertex(i)))
		// 			vertices.add(new Vertex(i));
		// }
		return vertices;
	}

	public void removeVertex(int vertex) {
		for (int i = 0; i < graph.length; i++) {
			graph[vertex][i] = EMPTY_EDGE_VALUE;
			graph[i][vertex] = EMPTY_EDGE_VALUE;
		}
	}

	public void removeVertex(Vertex vertex) {
		removeVertex(vertex.getId());
	}

	public void removeEdge(int origin, int destination) {
		graph[origin][destination] = EMPTY_EDGE_VALUE;
	}

	public void removeEdge(Edge edge) {
		removeEdge(edge.getOrigin().getId(), edge.getDestination().getId());
	}

	public Edge getEdge(Vertex origin, Vertex destination) {
		return getEdge(origin.getId(), destination.getId());
	}

	public Edge getEdge(int origin, int destination) {
		if (graph[origin][destination] == EMPTY_EDGE_VALUE)
			return null;
		return new Edge(origin, destination, graph[origin][destination]);
	}

	@Override
	public int numberOfVertices() {
		return graph.length;
	}

	@Override
	public int numberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String printGraph() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				Integer x = graph[i][j];
				if (x == null)
					s.append("0 ");
				else
					s.append(x.toString()).append(" ");
			}
			s.append("\n");
		}
		s.append("\n\n");
		for (Edge e : listEdges())
			s.append(e.toString() + "\n");

		return s.toString();
	}

}