package prim;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimMST {
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

		//Prim's algorithm from ch 23.2 of CLRS:
		//Lines 1-4 are done implicitly in the construction of the graph
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(Arrays.asList(G.vertices));
		while(!Q.isEmpty()){
			Vertex u = Q.remove();
			for(Vertex v : u.adjs.keySet()){
				if(Q.contains(v) && u.adjs.get(v) < v.key){
					Q.remove(v);
					v.p = u;
					v.key = u.adjs.get(v);
					Q.add(v);
				}
			}
		}
		System.out.println("MST:");
		for(Vertex v : G.vertices){
			if(!v.equals(G.root)){
				System.out.println(v + "," + v.p);
			}
		}
		s.close();
	}

}
