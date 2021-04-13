package com.williansoares.aedsiii;

public class Vertex {
	private int id;

	public Vertex() {
		super();
	}

	public Vertex(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vertex)
			return (((Vertex) obj).id == this.id);

		if (obj instanceof Integer)
			return (((Integer) obj == this.id));

		return false;
	}
}
