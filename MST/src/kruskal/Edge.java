package kruskal;

public class Edge implements Comparable<Edge> {
	Vertex v1;
	Vertex v2;
	int w;
	
	Edge(Vertex v1, Vertex v2, int w){
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}
	
	public String toString(){
		return v1.id + "," + v2.id;
	}
	
	@Override
	public int compareTo(Edge e){
		return this.w - e.w;
	}

}
