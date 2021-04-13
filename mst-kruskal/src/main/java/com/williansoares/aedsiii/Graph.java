package com.williansoares.aedsiii;

import java.util.List;

public interface Graph {
	public String printGraph();

	public int numberOfVertices();
	public int numberOfEdges();

	// public boolean addEdge(Edge edge);
	// public boolean updateEdge(Edge edge);
	public void updateOrAddEdge(Edge edge);

	public List<Edge> listEdges();
	public List<Edge> listEdges(Vertex vertex);

	public List<Vertex> listVertices();
	/**
	 * Used to list all vertices that are adjacents to a vertex
	 * @param vertex the given vertex that will be searched adjacents for
	 * @return A list of adjacents vertices
	 */
	public List<Vertex> listAdjacents(Vertex vertex);

	public void removeVertex(int vertex);
	public void removeVertex(Vertex vertex);

	public void removeEdge(int origin, int destination);
	public void removeEdge(Edge edge);

	public Edge getEdge(Vertex origin, Vertex destination);
	public Edge getEdge(int origin, int destination);
}