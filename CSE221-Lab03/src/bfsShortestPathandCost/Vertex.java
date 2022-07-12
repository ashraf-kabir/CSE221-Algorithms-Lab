package bfsShortestPathandCost;

public class Vertex {
	
    public int dist;
    public int parent;
    public int color;

    public Vertex(int d, int p, int c) {
        dist = d;
        parent = p;
        color = c;
    }

}
