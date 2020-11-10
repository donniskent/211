import java.util.ArrayList;

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
	public ArrayList<Integer> edgesFrom(int node) {
		ArrayList<Integer> total = new ArrayList<Integer>();
		for(int i = 0; i < graph[node].length; i++) {
			if(graph[node][i] == 1) {
				total.add(i);
			}
		}
		return total; 
		
	}
	
	
	
	
	
	//   row                  column
	public int solve(int currentNode, ArrayList<Integer> unvisitedNodes) {
		
		// need an arraylist of all the nodes the current node connects to 
		ArrayList<Integer> edges = edgesFrom(currentNode);
		
		
		
		// removes all the nodes that are able to be visited from current node
		for(int i = 0; i < edges.size(); i ++) {
			if(unvisitedNodes.contains(edges.get(i))) {
				unvisitedNodes.remove(edges.get(i));
			}
		}
		
		
		
		
		
		// base case 1 
		// unvisitedNodes is empty. 
		// return 1 
		if(unvisitedNodes.isEmpty()) {
			 return 1;
		}
		
		
		
		
		
		// base case 2
		// no edges from current node to unvisited node(s), nowhere to back track to.  
		// return 0 
		if(edges.isEmpty()) {
			return 0; 
		}
		
		
		
		
		
		// general case: 
			
			int result = solve(edges.get(0), unvisitedNodes);
			if(result == 0 && edges.size() > 1) {
				edges.remove(0);
			result = solve(edges.get(0), unvisitedNodes);
			}
		return result;
		
		
		
		
		
		
		
		
		
		
	}
	
	




}
