public class Vertex {
	Graph.Color color;
	Vertex parent;
	int d, f;
	int index;

	public Vertex (int index) {
		this.index = index;
	}
}
