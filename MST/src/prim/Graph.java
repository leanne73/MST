package prim;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	Vertex[] vertices;
	Vertex root;
	
	Graph(int numVerticies) {
		vertices = new Vertex[numVerticies];
	}
	
	public static Graph defaultGraph(){
		return parseGraph("4 1 1,2,3 2,3,5 0,2,7 3,0,4 0,1,1");
	}
	
	public static Graph defaultGraph2(){
		return parseGraph("8 3 0,1,1 1,2,3 2,6,4 6,7,10 7,5,2 5,4,11 4,0,8 0,3,9 1,3,6 2,3,5 6,3,2 5,3,4 4,3,7 6,5,6");
	}

	/** Expects: Num of Vertices followed by the root r and a list of edges and their respective weights in the form v1,v2,w (meaning that w(v1, v2) = w)
	  * Graph should be undirected
	  * ex: "4 1 1,2,3 2,3,5 3 3,0,4" would be a graph with 4 vertices [0..3] and edges where w(1,2)=3 ; w(2,3)=5 ; w(3,0)=4
	  **/
	public static Graph parseGraph(String graph) {
		String[] g = graph.split(" ");
		Graph G = new Graph(Integer.parseInt(g[0])); //num vertices
		
		for(int i = 0; i < G.vertices.length; i++){
			G.vertices[i] = new Vertex(i);
		}
		G.root = G.vertices[Integer.parseInt(g[1])];
		G.root.key = 0;
		
		for(int i = 2; i < g.length; i++){
			String e[] = g[i].split(",");
			Vertex v1 = G.vertices[Integer.parseInt(e[0])];
			Vertex v2 = G.vertices[Integer.parseInt(e[1])];
			int w = Integer.parseInt(e[2]);
			G.vertices[v1.id].adjs.put(v2, w);
			G.vertices[v2.id].adjs.put(v1, w);
		}

		return G;
	}
	
	public String toString(){
		System.out.println();
		String toReturn = vertices.length + " " + root.id + " ";
		
		//class to facilitate printing the edges
		class Edge {
			int v1, v2;
			Edge(int v1, int v2){
				this.v1 = v1;
				this.v2 = v2;
			}
		}
		Set<Edge> edges = new HashSet<Edge>();
		for(Vertex v : vertices){
			for(Vertex u : v.adjs.keySet()){
				Edge e = new Edge(u.id, v.id);
				boolean contains = false;
				for(Edge edge : edges){
					if(e.v1 == edge.v1 && e.v2 == edge.v2){
						contains = true;
					}
				}
				if(!contains){
					edges.add(e);
					edges.add(new Edge(e.v2, e.v1));
					toReturn += u + "," + v + "," + v.adjs.get(u) + " ";
				}
			}
		}

		return toReturn;
	}	
}

