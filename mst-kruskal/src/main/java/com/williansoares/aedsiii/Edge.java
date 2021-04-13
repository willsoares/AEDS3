package com.williansoares.aedsiii;

public class Edge implements Comparable<Edge>{
	public static final int DEFAULT_WEIGHT = 1;

	private Vertex origin, destination;
	private int weight;

	public Edge() {
		super();
	}

	public Edge(int origin, int destination, int weight) {
		this.origin = new Vertex(origin);
		this.destination = new Vertex(destination);
		this.weight = weight;
	}

	public Edge(int origin, int destination) {
		this(origin, destination, DEFAULT_WEIGHT);
	}

	public Edge(Vertex origin, Vertex destination, int weight) {
		this(origin.getId(), destination.getId(), weight);
	}

	public Edge(Vertex origin, Vertex destination) {
		this(origin.getId(), destination.getId(), DEFAULT_WEIGHT);
	}

	public Edge inverse() {
		return new Edge(this.destination, this.origin, this.weight);
	}

	@Override
	public int compareTo(Edge e) {
		return (int)(this.getWeight() - e.getWeight());
	}

	@Override
	public String toString() {
		return origin.getId() + "--" + destination.getId() + ": " + weight;
	}

	// #region Gets & Sets
	public Vertex getDestination() {
		return destination;
	}

	public Vertex getOrigin() {
		return origin;
	}

	public int getWeight() {
		return weight;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public void setOrigin(Vertex origin) {
		this.origin = origin;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	// #endregion

   
}