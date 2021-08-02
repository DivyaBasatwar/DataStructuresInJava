/*
 * This graph is weighted graph with no direction
 * */

package graph;

import java.util.*;

public class WeightedGraph {
	
	public class Edge{
		int source;
		int destination;
		int weight;
		
		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	private LinkedList<Edge> adj[];
	
	public WeightedGraph(int v) {
		adj = new LinkedList[v]; 
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination, int weight) {
		Edge e1 = new Edge(source, destination, weight);
		adj[source].add(e1);
		
		Edge e2 = new Edge(destination, source, weight);
		adj[destination].add(e2);
	}
	
	public void printGraph() {
		for(int i=0;i<adj.length;i++) {
			LinkedList<Edge> ll = adj[i];
			for(int j=0;j<ll.size();j++) {
				System.out.println("Vertex "+i+" is conneted to "+ll.get(j).destination+" with weight "+ll.get(j).weight);
			}
		}
	}
	
	
	//-------------------------------------------------------------------------------
	public class Pair implements Comparable<Pair>{   //we are implementing Comparable interface to compare the Pair.. so that we should get the pair with least wsf
		int v;
		String psf;    //path so far
		int wsf;       //weight so far
		
		public Pair(int v, String psf, int wsf) {
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}
		
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}
	
	
	//below we are going to implement Dijkstra algorithm to find the shortest path from source vertex to all other vertices
	public void dijkstraAlgo(int source) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[adj.length];
		
		pq.add(new Pair(source, source+"", 0));
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			
			if(vis[curr.v] == true) {    //if vertex is already visited then we don not relax that vertex
				continue;
			}
			
			vis[curr.v] = true;   //marking visited as we do in algorithm
			System.out.println(curr.v+" via "+curr.psf+" @ "+curr.wsf);
			
			for(Edge e : adj[curr.v]) {     //relaxing all neighbors which are unvisited
				if(vis[e.destination] == false){
					pq.add(new Pair(e.destination, curr.psf+e.destination+"", curr.wsf+e.weight));
				}
			}	
			
		}
		
	}
	
	//-------------------------------------------------------------------------------
	
	
	
	
	
	
	//---------------------------------------------------------------------------------
	
	public class Pair1 implements Comparable<Pair1>{
		int v;
		int av;    //acquiring vertex means who is calling the current vertex
		int weight;
		public Pair1(int v, int av, int weight) {
			this.v = v;
			this.av = av;
			this.weight = weight;
		}
		
		public int compareTo(Pair1 o) {
			return this.weight - o.weight;
		}
	}
	//now we are going to implement prim's  algorithm in order to find the minimum spanning tree
		public void primsAlgo(int source) {    //in prims we can start from any edge
			PriorityQueue<Pair1> pq = new PriorityQueue<>();
			boolean[] vis = new boolean[adj.length];
			
			pq.add(new Pair1(source, -1, 0));
			
			while(!pq.isEmpty()) {
				Pair1 curr = pq.poll();
				if(vis[curr.v] == true) {
					continue;
				}
				
				vis[curr.v] = true;
				if(curr.av!=-1) {
					System.out.println("["+curr.av+" - "+curr.v+"]");
				}
				
				for(Edge e : adj[curr.v]) {
					if(vis[e.destination]==false) {
						pq.add(new Pair1(e.destination, curr.v, e.weight));
					}
				}
				
			}
		}
		
	//-----------------------------------------------------------------------------------	
		
	
		
		

	//------------------------------------------------------------------------------------
	//now we are going to implement krushkals algorithm
		
	/*we are taking Edge1 class which is just like Edge class because here we want 
	 *to use Edge1 to add into the priority queue and so that it was required to implements 
	 *Comparable interface in order to determine the priority of the edge according to its weight	
	 **/
		
	public boolean isCyclic(int source) {
		
		Queue<Integer> q = new LinkedList<>();
		
		int[] vis = new int[adj.length];
		for(int i=0;i<vis.length;i++) {
			vis[i] = -1;
		}
		
		/*
		 * Unvisited --> -1
		 * Added to queue --->0
		 * Printed ---> 1*/
		
		q.add(source);
		vis[source] = 0;      
		
		
		int flag = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			vis[curr] = 1;
			for(Edge neighbor : adj[curr]) {
				if(vis[neighbor.source]==0) {
					flag = 1;
					break;
				}
				if(vis[neighbor.source]==-1) {
					vis[neighbor.source] = 0;
					q.add(neighbor.source);
				}
			}
		}
			
		if(flag==1) {
			return true;
		}
		else {
			return false;
		}
	}	
	
	
	public class Edge1 implements Comparable<Edge1>{
		int source;
		int destination;
		int weight;
		public Edge1(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
		public int compareTo(Edge1 o) {
			return this.weight - o.weight;
		}
	}
		
	public void krushkalsAlgo() {
		WeightedGraph spannedGrpah = new WeightedGraph(adj.length);
		PriorityQueue<Edge1> pq = new PriorityQueue<>();
		
		for(int i=0;i<adj.length;i++) {
			LinkedList<Edge> ll = adj[i];
			for(Edge e : ll) {
				pq.add(new Edge1(e.source, e.destination, e.weight));
			}
		}
				
		boolean[] vis = new boolean[adj.length];
		for(int i=0;i<adj.length-1;i++) {
			Edge1 curr = pq.poll();
			Edge1 curr2 = pq.poll();
			
			spannedGrpah.addEdge(curr.source, curr.destination, curr.weight);
			
			boolean flag = isCyclic(curr.source);
			
			if(flag==true) {
				continue;
			}
			else {
				
			}
		}
	}
		
		
		
		
	//-----------------------------------------------------------------------------------	
		
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of vertices and edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		WeightedGraph wg = new WeightedGraph(v);
		
		System.out.println("Enter "+e+" number of edges");
		for(int i=0;i<e;i++) {
			System.out.println("Enter edge no. --> "+(i+1));
			System.out.println("Enter source, destination and weight of that edge");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = sc.nextInt();
			wg.addEdge(source, destination, weight);
		}
		
		//calling print graph function
		System.out.println("\n---------------------------------------");
		wg.printGraph();
		System.out.println("\n---------------------------------------");
		
		//calling diskstra algorithm
		System.out.println("\n--------------------------------------\nEnter the source for Dijkstra's Algorithm");
		int source = sc.nextInt();
		wg.dijkstraAlgo(source);
		System.out.println("\n---------------------------------------\n");
		
		//calling prims algorithm
		System.out.println("\n---------------------------------------\nResult of Prims algorithm");
		wg.primsAlgo(0);
		System.out.println("\n---------------------------------------\n");
		
		//calling krushkals algorithm
		System.out.println("\n---------------------------------------\nResult of Krushkals  algorithm\n");
		wg.krushkalsAlgo();
		System.out.println("\n---------------------------------------\n");
		

	}

}
