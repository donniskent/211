import java.util.ArrayList;

public class Graph {
	private int[][] graph;
	private int vertices;

	public Graph(int vertices) {
		// constructor for graph should build the specific N x N matrix to be analyzed
		this.vertices = vertices;
		graph = new int[vertices][vertices];
		setInitialGraph();

	}

	public int getVertices() {
		return vertices;
	}

	public void setEdgeValue(int row, int col, int value) {
		graph[row][col] = value;

	}

	public int getEdgeValue(int row, int col) {
		return graph[row][col];
	}

	private void setInitialGraph() {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {

				graph[i][j] = 0;

			}
		}
	}

	private ArrayList<Integer> nodeList(int current) {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		for (int col = 0; col < vertices; col++) {

			if (graph[current][col] == 1) {
				queue.add(col);
			}
		}
		return queue;

	}

	// queue top = 0 queue bottom = queue.size -1
	public boolean solve(ArrayList<Integer> queue, ArrayList<Integer> VisitedNodes) {
		// breadth first, start by popping the queue, this will be currentNode

		// grab the front of the queue, this is currentNode
		int currentNode = queue.get(0);
		queue.remove(0);

		// add the adjacent vertices to the queue
		for (int i = 0; i < nodeList(currentNode).size(); i++) {
			queue.add(nodeList(currentNode).get(i)); // puts the adjacent nodes into the queue
		}
		if (!VisitedNodes.contains(currentNode)) {
			VisitedNodes.add(currentNode);
		}

		// base case 1: visited nodes = vertices (have to make sure duplicates arent
		// added to visited nodes
		if (VisitedNodes.size() == vertices) {
			return true;
		}

		// base case 2: queue is empty but not all vertices have been reached
		if (queue.size() == 0 && (VisitedNodes.size() < vertices)) {
			return false;
		}

		if (queue.size() == 1 && VisitedNodes.contains(queue.get(0)))
			return false;
		// general:

		return solve(queue, VisitedNodes);

	}

}
