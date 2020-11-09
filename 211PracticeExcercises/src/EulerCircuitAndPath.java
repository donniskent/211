import java.util.ArrayList;

public class EulerCircuitAndPath {

	public static void main(String[] args) {
		EulerCircuitAndPath control = new EulerCircuitAndPath();
		control.go();

	}

	public void go() {
		int[][] matrix1 = new int[5][5]; // euler path undirected
		matrix1[0][1] = 1;
		matrix1[1][0] = 1;
		matrix1[1][2] = 1;
		matrix1[1][3] = 1;
		matrix1[1][4] = 1;
		matrix1[2][1] = 1;
		matrix1[2][3] = 1;
		matrix1[3][1] = 1;
		matrix1[3][2] = 1;
		matrix1[4][1] = 1;
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				if (matrix1[i][j] != 1) {
					matrix1[i][j] = 0;

				}
			}
		}

		int[][] matrix2 = new int[3][3]; // euler circuit
		matrix2[0][1] = 1;
		matrix2[0][2] = 1;
		matrix2[1][0] = 1;
		matrix2[1][2] = 1;
		matrix2[2][0] = 1;
		matrix2[2][1] = 1;

		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				if (matrix2[i][j] != 1) {
					matrix2[i][j] = 0;

				}
			}
		}

		int[][] matrix3 = new int[5][5]; // directed circuit
		matrix3[0][1] = 1;
		matrix3[0][2] = 1;
		matrix3[1][3] = 1;
		matrix3[2][4] = 1;
		matrix3[3][0] = 1;
		matrix3[4][0] = 1;
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix3[0].length; j++) {
				if (matrix3[i][j] != 1) {
					matrix3[i][j] = 0;

				}
			}
		}
		int[][] matrix4 = new int[5][5]; // directed path
		matrix4[0][1] = 1;
		matrix4[1][2] = 1;
		matrix4[1][4] = 1;
		matrix4[2][3] = 1;
		matrix4[3][1] = 1;
		for (int i = 0; i < matrix4.length; i++) {
			for (int j = 0; j < matrix4[0].length; j++) {
				if (matrix4[i][j] != 1) {
					matrix4[i][j] = 0;

				}
			}
		}

		int[][] graph1 = new int[5][5];
		graph1[0][1] = 1;
		graph1[0][2] = 1;
		graph1[0][3] = 1;
		graph1[1][0] = 1;
		graph1[1][4] = 1;
		graph1[2][0] = 1;
		graph1[2][3] = 1;
		graph1[3][0] = 1;
		graph1[3][2] = 1;
		graph1[3][4] = 1;
		graph1[4][1] = 1;
		graph1[4][3] = 1;
		for (int i = 0; i < graph1.length; i++) {
			for (int j = 0; j < graph1[0].length; j++) {
				if (graph1[i][j] != 1) {
					graph1[i][j] = 0;

				}
			}
		}
		
		int[][] graph2 = new int[5][5];
		graph2[0][1] = 1;
		graph2[1][4] = 1;
		graph2[2][0] = 1;
		graph2[2][3] = 1;
		graph2[4][0] = 1;
		for (int i = 0; i < graph2.length; i++) {
			for (int j = 0; j < graph2[0].length; j++) {
				if (graph2[i][j] != 1) {
					graph2[i][j] = 0;

				}
			}
		}
		
		
		
		
		
		System.out.println("matrix 1 undirected path. Expected true got: " + checkPathUndirected(matrix1)); // should pass
		System.out.println("matrix 2 undirected path. Expected false got: " + checkPathUndirected(matrix2)); // should fail

		System.out.println("matrix 1 undirected circuit. Expected false got: " + checkCircuitUndirected(matrix1)); // should fail
		System.out.println("matrix 2 undirected circuit. Expected true got: " + checkCircuitUndirected(matrix2)); // should pass

		System.out.println("matrix 3 directed circuit. Expected true got: " + checkCircuitDirected(matrix3));// should pass
		System.out.println("matrix 4 directed circuit. Expected false got: " + checkCircuitDirected(matrix4)); // should fail

		System.out.println("matrix 4 directed path. Expected true got: " + checkPathDirected(matrix4)); // should pass
		System.out.println("matrix 3 directed path. Expected false got: " + checkPathDirected(matrix3)); // should fail
	
	
	System.out.println("For Graph #1 from excercise. Checking Euler path. Got: " + checkPathUndirected(graph1));
	System.out.println("For Graph #1 from excercise. Checking Euler circuit. Got: " + checkCircuitUndirected(graph1));

	System.out.println("For Graph #2 from excercise. Checking Euler path. Got: " + checkPathDirected(graph2));
	System.out.println("For Graph #2 from excercise. Checking Euler circuit. Got: " + checkCircuitDirected(graph2));
	
	
	
	
	}

	public boolean checkCircuitUndirected(int[][] matrix) {

		int rowTotal = 0;
		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[0].length; col++) {
				rowTotal += matrix[row][col];

			}
			if (rowTotal % 2 != 0) {
				return false;
			}

			rowTotal = 0;

		}

		return true;

	}

	public boolean checkPathUndirected(int[][] matrix) {
		int rowTotal = 0;
		ArrayList<Integer> totalEdgeList = new ArrayList<Integer>();
		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[0].length; col++) {
				rowTotal += matrix[row][col];

			}

			totalEdgeList.add(rowTotal);
			rowTotal = 0;

		}

		int oddsCount = 0;

		for (int i = 0; i < totalEdgeList.size(); i++) {

			if (totalEdgeList.get(i) % 2 != 0) {
				oddsCount += 1;
			}

		}
		if (oddsCount != 2) {
			return false;
		}

		return true;

	}

	public boolean checkCircuitDirected(int[][] matrix) {
		// in degree has to be same as out degree for all vertices
		// loop though each

		int rowTotal = 0;
		ArrayList<Integer> outDegree = new ArrayList<Integer>();
		for (int row = 0; row < matrix.length; row++) {
			// add all the values in row 1 up.

			for (int col = 0; col < matrix[0].length; col++) {
				rowTotal += matrix[row][col];

			}

			outDegree.add(rowTotal);
			rowTotal = 0;

		}

		int colTotal = 0;
		ArrayList<Integer> inDegree = new ArrayList<Integer>();
		for (int col = 0; col < matrix.length; col++) {
			// add all the values in row 1 up.

			for (int row = 0; row < matrix[0].length; row++) {
				colTotal += matrix[row][col];

			}

			inDegree.add(colTotal);
			colTotal = 0;

		}

		for (int i = 0; i < inDegree.size(); i++) {

			if (inDegree.get(i) != outDegree.get(i)) {
				return false;
			}

		}

		return true;

	}

	public boolean checkPathDirected(int[][] matrix) {

		int rowTotal = 0;
		ArrayList<Integer> outDegree = new ArrayList<Integer>();
		for (int row = 0; row < matrix.length; row++) {
			// add all the values in row 1 up.

			for (int col = 0; col < matrix[0].length; col++) {
				rowTotal += matrix[row][col];

			}
			outDegree.add(rowTotal);
			rowTotal = 0;

		}

		int colTotal = 0;
		ArrayList<Integer> inDegree = new ArrayList<Integer>();
		for (int col = 0; col < matrix[0].length; col++) {
			// add all the values in row 1 up.

			for (int row = 0; row < matrix.length; row++) {
				colTotal += matrix[row][col];

			}

			inDegree.add(colTotal);
			colTotal = 0;

		}

		// in 1 inex, out - in = 1
		// in 1 index in - out = 1

		int outDegreeGreater = 0;
		int inDegreeGreater = 0;

		for (int i = 0; i < inDegree.size(); i++) {
			if (inDegree.get(i) - 1 == outDegree.get(i)) {
				inDegreeGreater++;
			}
			if (inDegree.get(i) + 1 == outDegree.get(i)) {
				outDegreeGreater++;
			}
		}
		if (inDegreeGreater == outDegreeGreater && inDegreeGreater != 0) {
			return true;
		}

		return false;

	}

}
