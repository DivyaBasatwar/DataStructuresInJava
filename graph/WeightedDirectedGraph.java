/*
 * Dijkshtra algorithm is the way to find out the shortest path between two points in terms of weights 
 * whereas DFS can be used to find out the shortest path between two points in terms of edges*/
package graph;

import java.util.*;

public class WeightedDirectedGraph {
	
	class Edge{
		int source, destination, weight;
		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
	private LinkedList<Edge> adj[];        //array of linked list
	
	WeightedDirectedGraph(int v){
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination, int weight) {
		Edge e = new Edge(source, destination, weight);
		adj[source].add(e);
	}
	
	public void printGraph() {
		for(int i=0;i<adj.length;i++) {
			LinkedList<Edge> ll = adj[i];
			for(int j=0;j<ll.size();j++) {
				System.out.println("Vertex "+i+" is conneted to "+ll.get(j).destination+" with weight "+ll.get(j).weight);
			}
		}
	}
	
 	public static void main(String[] args) {
 		Scanner sc =new Scanner(System.in);
 		System.out.println("Enter the number of vertices and edges");
 		int v = sc.nextInt();
 		int e = sc.nextInt();
 		WeightedDirectedGraph wdg = new WeightedDirectedGraph(v);
 		System.out.println("Enter the "+e+" number of edges");
 		for(int i=0;i<e;i++) {
 			System.out.println("Enter source, destination and weight of an edge "+(i+1)+"--> ");
 			int source = sc.nextInt();
 			int destination = sc.nextInt();
 			int weight = sc.nextInt();
 			wdg.addEdge(source, destination, weight);
 		}
 		
 		System.out.println("Priting the graph,,,");
 		wdg.printGraph();

	}

}
