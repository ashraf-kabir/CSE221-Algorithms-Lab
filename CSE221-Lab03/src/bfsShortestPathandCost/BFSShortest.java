package bfsShortestPathandCost;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortest {
	
	public static void bfs(int[][] g, int s) {

        Vertex[] n = new Vertex[g.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = new Vertex(99999, 0, 0);
        }
        n[s].color = 1;
        n[s].dist = 0;
        n[s].parent = -1;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (q.size() != 0) {
            int u = q.remove();
            for (int v = 0; v < g.length; v++) {
                if (g[u][v] == 1) {
                    if (n[v].color == 0) {
                        n[v].color = 1;
                        n[v].dist = n[u].dist + 1;
                        n[v].parent = u;
                        q.add(v);
                    }
                }
            }
            n[u].color = 2;
        }
        
        Scanner sc = new Scanner(System.in);
        
		try {
	        System.out.println("Insert distance:");
	        int x = sc.nextInt();
	        System.out.printf("Shortest path: " + x);
	        x--;
	        int dis = x;
	        while (n[x].parent != -1) {
	            System.out.print(" -> ");
	            System.out.print(n[x].parent + 1);
	            x = n[x].parent;
	        }
	        System.out.println();
	        System.out.println("Cost: " + n[dis].dist);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}

    }

    public static void main(String[] args) throws IOException {
    	
		InputStream input = BFSShortest.class.getResourceAsStream("BFSInput.txt");
		Scanner sc = new Scanner(input);
		
		try {
			int n = sc.nextInt();
	        int graph[][] = new int[n][n];
	        int s = sc.nextInt();
	        int src = s - 1;
	        while (sc.hasNextInt()) {
	            int v1 = sc.nextInt();
	            int v2 = sc.nextInt();
	            graph[v1 - 1][v2 - 1] = 1;
	            graph[v2 - 1][v1 - 1] = 1;
	        }
	        bfs(graph, src);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
        
    }
	
}
