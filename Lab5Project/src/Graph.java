
public class Graph {
	private int[][] graph;
	private int vertices;  
	public Graph (int vertices) {
		// constructor for graph should build the specific N x N matrix to be analyzed
		this.vertices = vertices;
		graph = new int[vertices][vertices];
		setInitialGraph();
		
		
	}
	
	public int getVertices() {
		return vertices;
	}
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public void setEdgeValue(int row, int col, int value) {
		graph[row][col] = value;
		
		
	}

	public int getEdgeValue(int row, int col) {
		return graph[row][col];
	}

	public void setInitialGraph() {
		for(int i = 0; i < vertices; i++) {
			for(int j = 0; j < vertices; j++) {
			
				graph[i][j] = 0;
			
			
			}
		}
	}

	// recurisive method 
	// start at (0,0), try to go +1, then plus 2, then plus 3 etc etc. 
	//
	// lay mans terms. start at vertex 1. check its connections. follow the one that is closest. 
	// same thing (but dont go backwards unless there is dead end.)
	public void solve() {
		
		// base case 1 :
		// the graph is solved (all nodes have been  visited)
		
		// base case 2: 
		// reached a dead end and cant get to other nodes. 
		
		// general case:
		// start at node. check its edges. 
		// follow the next highest edge (if at 1 and connected to 3 5 7, go for 3 first) 
		// this is the new starting point for new call of the method. 
		
		
		
		
	}




}
