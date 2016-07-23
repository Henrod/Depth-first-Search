import java.util.*;

public class Graph {

	static int time;

	private Vertex[] vertices;
	private HashMap<Vertex, List<Vertex>> adj;

	public Graph (int N, List<Edge> edges) {
		vertices = new Vertex[N];
		adj = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			vertices[i - 1] = new Vertex(i);
			adj.put(vertices[i - 1], new LinkedList<>());
		}

		for (Edge e : edges) {
			adj.get(vertices[e.u]).add(vertices[e.v]);
		}
	}

	private static void initialize(Graph graph) {
		for (Vertex v : graph.vertices) {
			v.visited = false;
			v.parent = null;
		}
	}

	public Vertex[] vertices() {
		return vertices;
	}

	public List<Vertex> adj(Vertex v) {
		return adj.get(v);
	}

	public static Vertex[] DFS (Graph graph) {
		initialize(graph);
		int time = 0;

		for (Vertex v : graph.vertices()) {
			if (!v.visited) {
				Stack stack = new Stack(graph.vertices.length);
				stack.push(v);

				while (!stack.isEmpty()) {
					Vertex u = stack.pop();
					u.visited = true;

					for (Vertex x : graph.adj(u)) {
						if (!x.visited) {
							stack.push(x);
							x.parent = u;
						}
					}
				}
			}
		}

		return graph.vertices();
	}
}
