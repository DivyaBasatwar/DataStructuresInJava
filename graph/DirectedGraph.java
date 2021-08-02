/**
 * Here I have implemented a directed graph with no weights assigned to the edges 
 */

package graph;

import java.util.*;

public class DirectedGraph {

	private LinkedList<Integer> adj[];
	
	public DirectedGraph(int v) {
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
	}
	
	
	//Breadth first search graph traversal algorithm
	public void bfs(int source) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[adj.length];
		
		q.add(source);
		vis[source] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+" -> ");
			for(int neighbor : adj[curr]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					q.add(neighbor);
				}
			}
		}
	}
	
	//depth first search
	public void dfs(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] vis = new boolean[adj.length];
		
		
		System.out.print(source+" -> ");
		stack.push(source);
		vis[source] = true;
		
		while(!stack.isEmpty()) {
			int curr = stack.peek();
			int flag = 0;
			for(int neighbor : adj[curr]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					System.out.print(neighbor+" -> ");
					stack.push(neighbor);
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				stack.pop();
			}
		}
	}
	
	public void isCyclicUsingDfs(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] vis = new int[adj.length];
		
		for(int i=0;i<adj.length;i++) {
			vis[i] = -1;
		}
		
		stack.push(source);
		vis[source] = 1;
		
		/*
		 * -1 :- unvisited
		 * 0  :- visited and in stack
		 * 1  :- Visited and popped out from stack*/
		
		boolean isCyclic = false;
		
		while(!stack.isEmpty()) {
			int curr = stack.peek();
			int flag = 0;

			for(int neighbor : adj[curr]) {
				if(vis[neighbor]==0) {
					isCyclic = true;
				}
				if(vis[neighbor]==-1) {
					stack.push(neighbor);
					vis[neighbor] = 0;
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				int poppedEle = stack.pop();
				vis[poppedEle] = 1;
			}
		}
		
		
		if(isCyclic==true) {
			System.out.println("\nGraph is Cyclic");
		}
		else {
			System.out.println("\nGraph has no Cycle");
		}
	}
	
	public void topologicalSortMethod() {
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[adj.length];
		
		for(int i=0;i<adj.length;i++) {
			if(vis[i]==false) {
				topologicalSort(adj, i, vis, stack);
			}
		}
		
		
		while(!stack.isEmpty()) {
			int ele = stack.pop();
			System.out.print(ele+" -> ");
		}
		
	}
	
	public void topologicalSort(LinkedList<Integer>[] adj, int source, boolean[] vis, Stack<Integer> stack) {
		vis[source] = true;
		for(int neighbor : adj[source]) {
			if(!vis[neighbor]) {
				topologicalSort(adj, neighbor, vis, stack);
			}
		}
		stack.push(source);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices and edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		DirectedGraph dg = new DirectedGraph(v);

		System.out.println("Enter "+e+" number of edges");
		for(int i=0;i<e;i++) {
			System.out.println("Enter the edge no. "+(i+1));
			int source = sc.nextInt();
			int destination = sc.nextInt();
			dg.addEdge(source, destination);
		}
		
		//BFS calling
		System.out.print("\nEnter the source to start traversing(for bfs) --> ");
		int source = sc.nextInt();
		dg.bfs(source);
		
		//DFS calling
		System.out.print("\nEnter the source to start traversing(for dfs) --> ");
		int sourceForDFS = sc.nextInt();
		dg.dfs(sourceForDFS);
		
		//checking whether the graph has a cycle or not
		dg.isCyclicUsingDfs(0);
		
		//calling topological sort
		dg.topologicalSortMethod();
	}

}
