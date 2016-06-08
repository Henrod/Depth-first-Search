import java.util.*;

public class Graph {

	static int time;
	static enum Color {
		WHITE, GRAY, BLACK;
	}

	List<Vertex> vertices;
	HashMap<Vertex, List<Vertex>> adj;

	public Graph (List<Vertex> vertices, HashMap<Vertex, List<Vertex>> adj) {
		this.vertices = vertices;
		this.adj = adj;
	}

	public List<Vertex> DFS () {
		for (Vertex v : vertices) {
			v.color = Color.WHITE;
			v.parent = null;
		}

		time = 0;

		for (Vertex v : vertices) {
			if (v.color == Color.WHITE)
				DFS_Visit(v);
		}

		return vertices;
	}

	private void DFS_Visit (Vertex v) {
		time += 1;
		v.d = time;
		v.color = Color.GRAY;

		for (Vertex u : adj.get(v)) {
			if (u.color == Color.WHITE) {
				u.parent = v;
				DFS_Visit(u);
			}
		}

		v.color = Color.BLACK;
		time += 1;
		v.f = time;
	}
}
