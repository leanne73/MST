package kruskal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KruskalMST {
	private static Graph G;
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter graph or 'default':");
		
		String graph = s.nextLine();
		if(graph.equals("default")){
			G = Graph.defaultGraph();
		}else if(graph.equals("default2")){
			G = Graph.defaultGraph2();
		}else{
			G = Graph.parseGraph(graph);
		}
		System.out.println("Graph is: \n" + G + "\n ");
		
		//Algorithm from ch 23.2 of CLRS:
		Set<Edge> A = new HashSet<Edge>();
		//MakeSet is implicitly called for each vertex during their construction
		Collections.sort(G.edges); 
		for(int i = 0; i < G.edges.size(); i++){
			Edge e = G.edges.get(i);
			if(!Vertex.findSet(e.v1).equals(Vertex.findSet(e.v2))){
				A.add(e);
				Vertex.union(e.v1, e.v2);
			}
		}
		System.out.println("MST:");
		for(Edge e : A){
			System.out.println(e);
		}
		s.close();
	}
}
