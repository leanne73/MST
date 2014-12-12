package prim;

import java.util.HashMap;

public class Vertex implements Comparable<Vertex> {
	Vertex p;
	int id;
	int key;
	HashMap<Vertex, Integer> adjs; //Stores the vertices adjacent to this vertex and the weight of the respective edge
	
	Vertex(int id){
		this.id = id;
		p = null;
		key = Integer.MAX_VALUE;
		adjs = new HashMap<Vertex, Integer>();
	}

	@Override
	public int compareTo(Vertex v) {
		return this.key - v.key;
	}
	
	public String toString(){
		return this.id + "";
	}

}
