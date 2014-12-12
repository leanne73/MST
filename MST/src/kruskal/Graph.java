package kruskal;

import java.util.ArrayList;

public class Graph {
	Vertex[] vertices;
	ArrayList<Edge> edges;
	
	Graph(int numVerticies) {
		vertices = new Vertex[numVerticies];
		edges = new ArrayList<Edge>();
	}
	
	public static Graph defaultGraph(){
		return parseGraph("4 1,2,3 2,3,5 0,2,7 3,0,4 0,1,1");
	}
	
	public static Graph defaultGraph2(){
		return parseGraph("8 0,1,1 1,2,3 2,6,4 6,7,10 7,5,2 5,4,11 4,0,8 0,3,9 1,3,6 2,3,5 6,3,2 5,3,4 4,3,7 6,5,6");
	}

	/** Expects: Num of Vertices followed by a list of edges and their respective weights in the form v1,v2,w (meaning that w(v1, v2) = w).
	  * Graph should be undirected.
	  * ex: "4 1,2,3 2,3,5 3 3,0,4" would be a graph with 4 vertices [0..3] and edges where w(1,2)=3 ; w(2,3)=5 ; w(3,0)=4
	  **/
	public static Graph parseGraph(String graph) {
		String[] g = graph.split(" ");
		Graph G = new Graph(Integer.parseInt(g[0])); //num vertices
		
		for(int i = 0; i < G.vertices.length; i++){
			G.vertices[i] = new Vertex(i);
		}
		for(int i = 1; i < g.length; i++){
			String e[] = g[i].split(",");
			G.edges.add(new Edge(G.vertices[Integer.parseInt(e[0])], G.vertices[Integer.parseInt(e[1])], Integer.parseInt(e[2])));
		}

		return G;
	}
	
	public String toString(){
		System.out.println();
		String toReturn = vertices.length + " ";
		
		for(int i = 0; i < edges.size(); i++){
			toReturn += edges.get(i) + "," + edges.get(i).w + " ";
		}

		return toReturn;
	}

}
