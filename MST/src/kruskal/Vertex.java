package kruskal;

public class Vertex {
	Vertex p;
	int rank;
	int id;
	
	Vertex(int id){
		this.id = id;
		p = this;
		rank = 0;
	}
	
	//Methods for supporting the disjoint set data structure using ch 21.3 in CLRS as a reference
	public static Vertex findSet(Vertex v){
		if(!v.equals(v.p)){
			v.p = findSet(v.p);
		}
		return v.p;
	}
	
	public static void link(Vertex v, Vertex u){
		if(v.rank > u.rank){
			u.p = v;
		}else{
			v.p = u.p;
			if(v.rank == u.rank){
				u.rank +=1;
			}
		}
	}
	
	public static void union(Vertex v, Vertex u){
		link(findSet(v), findSet(u));
	}
	
}
