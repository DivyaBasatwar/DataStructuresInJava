package graph;
import java.util.*;
public class Graph {
	private LinkedList<Integer> adj[];    //this is the array of linked list
	
	public Graph(int v){
		adj = new LinkedList[v];   //here we are creating v number of linked list
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	
	//method to find the shortest path(in terms of edges) between two points using BFS
	public int shortestPathUsingBFS(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		int parent[] = new int[adj.length];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(source);
		parent[source] = -1;
		vis[source] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == destination) {
				break;
			}
			
			for(int neighbor : adj[cur]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					q.add(neighbor);
					parent[neighbor] = cur;
				}
			}
			
		}
		
		int cur = destination;
		int distance = 0;
		while(parent[cur]!=-1) {
			System.out.print(cur+" -> ");
			cur = parent[cur];
			distance++;
		}
		System.out.print(cur+" ");
		return distance;
	}
	
	//BFS graph traversal algorithm
	public void bfs(int source) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] vis = new boolean[adj.length];
		
		queue.add(source);
		vis[source] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			for(int neighbor : adj[curr]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
 	}
	
	//DFS graph traversal algorithm
	public void dfs(int source) {
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[adj.length];
		
		System.out.print(source+" -> ");
		stack.push(source);
		vis[source] = true;
		
		while(!stack.isEmpty()) {
			int curr = stack.peek();
			int flag = 1;
			for(int neighbor : adj[curr]) {
				if(!vis[neighbor]) {
					System.out.print(neighbor+" -> ");
					vis[neighbor] = true;
					stack.push(neighbor);
					flag = 0;
					break;
				}
			}
			if(flag==1) {
				stack.pop();
			}
			
		}
	}
	
	//method to check whether the graph is cyclic or not? using bfs
	public void isCyclic(int source) {
		
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
			for(int neighbor : adj[curr]) {
				if(vis[neighbor]==0) {
					flag = 1;
					break;
				}
				if(vis[neighbor]==-1) {
					vis[neighbor] = 0;
					q.add(neighbor);
				}
			}
		}
			
		if(flag==1) {
			System.out.println("Graph is cyclic");
		}
		else {
			System.out.println("Graph does not have any cyclic");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices and number of edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph g = new Graph(v);
		
		System.out.println("\nEnter the "+e+" number of edges");
		
		for(int i=0;i<e;i++) {
			System.out.println("Enter edge no. --> "+(i+1));
			int source = sc.nextInt();
			int destination = sc.nextInt();
			g.addEdge(source, destination);
		}
		
		
		//Breadth first traversal algorithm result
		System.out.println("\nEnter the root node or source node to start traversal(for bfs)");
		int startingPoint = sc.nextInt();
		g.bfs(startingPoint);
		
		
		//Depth first traversal algorithm result
		System.out.println("\n\nEnter the root node or source node to start traversal(for dfs)");
		int startingPointForDFS = sc.nextInt();
		g.dfs(startingPointForDFS);
		
		
		//find shortest path using bfs result
		System.out.println("\n\nEnter the source and destination(to find shortest path)");
		int source = sc.nextInt();
		int destination = sc.nextInt();
		int shortestDistance = g.shortestPathUsingBFS(source, destination);
		System.out.println("\nShortest distance between "+source+" and "+destination+" is "+shortestDistance);

		
		//calling a method to check whether the graph is cyclic or not
		System.out.print("\nEnter the source --> (to check whether the graph is cyclic or not?) ");
		int s = sc.nextInt();
		g.isCyclic(s);
		
	}

}
