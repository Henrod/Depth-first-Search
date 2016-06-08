import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<Vertex> vertices = new ArrayList<Vertex>(N);
		for (int i = 1; i <= N; i++) {
			vertices.add(new Vertex(i));
		}

		HashMap<Vertex, List<Vertex>> adj = new HashMap<>();
		for (int i = 0; i < N; i++)
			adj.put(vertices.get(i), new LinkedList<Vertex>());

		for (int i = 0; i < M; i++) {
			Vertex src = vertices.get(sc.nextInt() - 1);
			Vertex dst = vertices.get(sc.nextInt() - 1);
			adj.get(src).add(dst);
		}

		Graph G = new Graph(vertices, adj);
		List<Vertex> depth_first_forest = G.DFS();

		for (Vertex v : depth_first_forest) {
			System.out.println(v.index +
			": DISCOVERED =  " + v.d +
			" FINISHED: " + v.f +
			" PARENT: " + (v.parent == null ? "nil" : v.parent.index));
		}
	}
}
