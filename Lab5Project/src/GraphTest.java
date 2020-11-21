import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GraphTest {
	@Test
	public void constructorTest() {
		Graph graph = new Graph(6);
		if(graph.getVertices() != 6) {
			fail("Expected vertices to be 6. Got " + graph.getVertices());
		}
		for(int i = 0; i < graph.getVertices(); i++) {
			for(int j = 0; j < graph.getVertices(); j++) {
				if(graph.getEdgeValue(i, j) != 0 ) {
					fail("All spots should be zero");
				}
			}
		}
		
	}
	
	@Test
	public void setEdgesTest() {
		Graph graph = new Graph(3);
		graph.setEdgeValue(0, 1, 1);
		graph.setEdgeValue(1, 2, 1);
		if(graph.getEdgeValue(0, 1) != 1) {
			fail("Expected spot (0,1) to have a value of 1. Got" + graph.getEdgeValue(0, 1));
		}

		if(graph.getEdgeValue(2, 0) != 0) {
			fail("Value at (2,0) should be 0. Got" + graph.getEdgeValue(2, 0));
		}
	
	
	}
	@Test
	public void solveTest() {
		Graph graph = new Graph(5);
		graph.setEdgeValue(0, 1, 1);
		graph.setEdgeValue(0, 2, 1);
		graph.setEdgeValue(0, 3, 1);
		graph.setEdgeValue(0, 4, 1);
		ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(0);
		if(graph.solve(queue, visitedNodes) == false) {
			fail("Expected true when node is 0");
		}
		queue.clear();
		queue.add(1);
		visitedNodes.clear();
		
		
		
		if(graph.solve(queue, visitedNodes) == true) {
			fail("Expected false when node is 1");
		}
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

}
