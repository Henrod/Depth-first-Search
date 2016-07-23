import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Edge> edges = new LinkedList<>();
		while (sc.hasNext()) {
			Edge e = new Edge();
			e.u = sc.nextInt() - 1;
			e.v = sc.nextInt() - 1;
			edges.add(e);
		}

		Graph graph = new Graph(N, edges);

		Vertex[] depth_first_forest = Graph.DFS(graph);
		for (Vertex v : depth_first_forest) {
			System.out.println(v.index +
			": PARENT: " + (v.parent == null ? "nil" : v.parent.index));
		}
	}
}
