package graph;

import java.util.*;

public class Temp {
	private LinkedList<Integer> adj[];
	Temp(int v){
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
	}
	void add(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	void bfs(int source) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[adj.length];
		
		q.add(source);
		vis[source] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr+" ");
			for(Integer neighbor: adj[curr]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					q.add(neighbor);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of vertices and edges\n");
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Temp t = new Temp(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i=0;i<e;i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			t.add(source, destination);
		}
		
		System.out.println("\nBFS Traversal");
		t.bfs(1);
	}

}
