package com.williansoares.aedsiii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	/**
	 * Reads a file, parses into a AdjacencyMatrix graph and return it.
	 *
	 * Uses a file in the format
	 * 
	 * n (numberOfVertices) 1, 2, 1.0 (origin vertex, destination vertex, weight of
	 * the edge) ...
	 * 
	 * @param graph The graph to be returned
	 * @param path  Path to a file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static AdjacencyMatrix readGraph(String path) {
		File f = new File(path);
		AdjacencyMatrix graph;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			int n = 0;
			if ((line = br.readLine()) != null)
				n = Integer.parseInt(line);
			else
				return null;
			graph = new AdjacencyMatrix(n);
			while ((line = br.readLine()) != null) {
				String[] l = line.split(",");
				int o = Integer.parseInt(l[0]);
				int d = Integer.parseInt(l[1]);
				Edge e = new Edge(o, d);
				if (l.length == 3) {
					int w = Integer.parseInt(l[2]);
					e.setWeight(w);
				}
				graph.updateOrAddEdge(e);
			}
			return graph;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}